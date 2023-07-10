// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import java.util.List;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

/**
 * Retrieve an object of the provided type by GUID.
 */
public class RetrieveObjectByGuid extends CustomJavaAction<IMendixObject>
{
	private java.lang.String entity;
	private java.lang.Long objectGuid;

	public RetrieveObjectByGuid(IContext context, java.lang.String entity, java.lang.Long objectGuid)
	{
		super(context);
		this.entity = entity;
		this.objectGuid = objectGuid;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		List<IMendixObject> mxObjects = Core.retrieveXPathQuery(getContext(),
				"//" + this.entity + "[id=" + this.objectGuid + "]");

		if (mxObjects.size() == 0) {
			return null;
		} else if (mxObjects.size() == 1) {
			return mxObjects.get(0);
		} else {
			throw new IllegalArgumentException("More then one object is found for id: " + this.objectGuid);
		}

		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "RetrieveObjectByGuid";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}