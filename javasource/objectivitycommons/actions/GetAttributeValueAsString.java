// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import com.mendix.core.objectmanagement.member.MendixDateTime;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import communitycommons.DateTime;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.IMendixObjectMember;

/**
 * Returns value of the named attribute for the provided object as a string.
 */
public class GetAttributeValueAsString extends CustomJavaAction<java.lang.String>
{
	private IMendixObject Entity;
	private java.lang.String AttributeName;
	private java.lang.String DateFormat;
	private java.lang.Boolean ReturnNullAsBlank;

	public GetAttributeValueAsString(IContext context, IMendixObject Entity, java.lang.String AttributeName, java.lang.String DateFormat, java.lang.Boolean ReturnNullAsBlank)
	{
		super(context);
		this.Entity = Entity;
		this.AttributeName = AttributeName;
		this.DateFormat = DateFormat;
		this.ReturnNullAsBlank = ReturnNullAsBlank;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		if(!Entity.hasMember(AttributeName)) return null;
		
		IMendixObjectMember<?> memberToGet = Entity.getMember(getContext(), AttributeName);

		if (!this.ReturnNullAsBlank) {
			Object valueObject = memberToGet.getValue(getContext());
			if (valueObject == null) return null;
		}
		
		String valueString = memberToGet.parseValueToString(getContext());
		
		if( memberToGet instanceof MendixDateTime && DateFormat != null) {
			Date date = DateTime.longToDateTime(Long.parseLong(valueString));
			DateFormat dateFormat = new SimpleDateFormat(DateFormat);  
			return dateFormat.format(date);		  
		}

		return valueString;
	
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetAttributeValueAsString";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
