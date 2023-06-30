package signinmicroflow.helpers;

import java.util.Map;
import java.util.UUID;

import javax.naming.ServiceUnavailableException;

import com.mendix.core.Core;
import com.mendix.core.action.user.LoginAction;
import com.mendix.logging.ILogNode;
import com.mendix.m2ee.api.IMxRuntimeRequest;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.AuthenticationRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.ISession;
import com.mendix.systemwideinterfaces.core.IUser;
import com.mendix.systemwideinterfaces.core.UserBlockedException;

import system.proxies.User;


public class SignInMicroflowLoginAction extends LoginAction{
	private final static ILogNode _logNode = Core.getLogger(signinmicroflow.proxies.constants.Constants.getLogNode());

	private String userName;
	private String password;
	private IMxRuntimeRequest request;
	private String currentSessionId;
	public final static String USER_NAME_PARAM = "userName";
	public final static String PASSWORD_PARAM = "password";
	private Map<String, ? extends Object> params;

	public SignInMicroflowLoginAction(Map<String, ? extends Object> params) {
		super(Core.createSystemContext(), params);
		this.params = params;
		
		this.userName = (String) params.get(USER_NAME_PARAM);
		this.password = (String) params.get(PASSWORD_PARAM);
		this.currentSessionId = (String)params.get("currentSessionId");
	    this.request = (IMxRuntimeRequest)params.get("request");
	
	}

	@Override
	public ISession execute() throws Exception {
		// if you have existing java code which overwrite LoginAction copy the code from that Action to here or vice versa.
		_logNode.trace("After sign-in action started for"
			+ " username: " + this.userName
			+ " and currentSessionId: " + this.currentSessionId);

		_logNode.trace("Calling signIn_Before MF for " + this.userName);
		boolean beforeResult = signinmicroflow.proxies.microflows.Microflows.signIn_Before(
			getContext(),
			this.userName,
			this.password);
		if (!beforeResult) {
			logAndThrow(new MendixRuntimeException("Calling signIn_Before MF for " + this.userName + " returned false."));
		}

		IContext sysContext = Core.createSystemContext();
		IUser user = Core.getUser(getContext(), this.userName);
		if (user == null)
			logAndThrow(new AuthenticationRuntimeException("Login FAILED: unknown user '" + this.userName + "'."));
		else if (user.isWebserviceUser())
			logAndThrow(new AuthenticationRuntimeException("Login FAILED: client login attempt for web service user '" + this.userName + "'."));
		else if (user.isAnonymous())
			logAndThrow(new AuthenticationRuntimeException("Login FAILED: client login attempt for guest user '" + this.userName + "'."));
		else if (user.isActive() == false)
			logAndThrow(new AuthenticationRuntimeException("Login FAILED: user '" + this.userName + "' is not active."));
		else if (user.isBlocked() == true)
			logAndThrow(new UserBlockedException("Login FAILED: user '" + this.userName + "' is blocked."));
		else if (user.getUserRoleNames().isEmpty())
			logAndThrow(new AuthenticationRuntimeException("Login FAILED: user '" + this.userName + "' does not have any user roles."));
		else if (!Core.authenticate(Core.createSystemContext(), user, this.password)) 
		{	
			_logNode.trace("Not authenticated");
			Object obj = (Integer)user.getMendixObject().getValue(getContext(),"FailedLogins")+1;
			user.getMendixObject().setValue(getContext(),"FailedLogins",obj);
			if ( (Integer)user.getMendixObject().getValue(getContext(),"FailedLogins") >= 3) {
				user.getMendixObject().setValue(getContext(),"Blocked",true);
				Core.commit(getContext(), user.getMendixObject());
				logAndThrow(new UserBlockedException("User "+ user.getName() + " blocked"));
			}
			Core.commit(getContext(), user.getMendixObject());
			logAndThrow(new AuthenticationRuntimeException("Login FAILED: invalid password for user '" + user.getName() + "'."));
		}
					
		ISession newSession = null;
		ISession oldSession = null;
		User anoUser = null;
		if(currentSessionId != null && currentSessionId != ""){
			oldSession = Core.getSessionById(UUID.fromString(currentSessionId));
			if(oldSession != null)
				anoUser = User.load(sysContext, oldSession.getUserId());
		}
			
		newSession = super.execute();
		User signInUser = User.load(sysContext, newSession.getUserId());
		
		_logNode.trace("Calling signIn_After MF - but only if"
			+ " signInUser != null: " + (signInUser != null));
		if(signInUser != null)
			signinmicroflow.proxies.microflows.Microflows.signIn_After(
				newSession.createContext(),
				anoUser,
				signInUser,
				this.password);
		
		return newSession;
	}

	private void logAndThrow(Exception ex) throws Exception {
		_logNode.trace(ex.getMessage());
		throw ex;
	}
}
