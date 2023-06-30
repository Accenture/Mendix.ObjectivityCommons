package signinmicroflow.helpers;

import com.mendix.core.Core;
import com.mendix.core.action.user.LoginAction;
import com.mendix.core.actionmanagement.ActionListener;
import com.mendix.logging.ILogNode;


public class LoginActionListener extends ActionListener<LoginAction>{
//	private final static ILogNode _logNode = Core.getLogger(signinmicroflow.proxies.constants.Constants.getLogNode());

	public LoginActionListener(Class<LoginAction> arg0) {
		super(arg0);
	}

	@Override
	public boolean check(LoginAction action) {
// can be used if you need to pass params to the Action
//		_logNode.trace("After sign-in check for action: " + action.getActionName());
		return true;
	}
}
