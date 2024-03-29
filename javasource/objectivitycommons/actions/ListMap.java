// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import java.util.ArrayList;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Maps source list into target list using simple get/set logic:
 * get value from SourceAttribute (from source entity)
 * and set it to TargetAttribute (to target entity).
 */
public class ListMap extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.util.List<IMendixObject> SourceList;
	private java.lang.String TargetEntityType;
	private java.lang.String SourceAttribute;
	private java.lang.String TargetAttribute;

	public ListMap(IContext context, java.util.List<IMendixObject> SourceList, java.lang.String TargetEntityType, java.lang.String SourceAttribute, java.lang.String TargetAttribute)
	{
		super(context);
		this.SourceList = SourceList;
		this.TargetEntityType = TargetEntityType;
		this.SourceAttribute = SourceAttribute;
		this.TargetAttribute = TargetAttribute;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		IContext ctx = this.getContext();
        ArrayList<IMendixObject> resultList = new ArrayList<IMendixObject>();

		for (IMendixObject source: SourceList) {
			IMendixObject target = Core.instantiate(ctx, this.TargetEntityType);
			Object value = source.getValue(ctx, SourceAttribute);
			target.setValue(ctx, TargetAttribute, value);
			resultList.add(target);
		}

		return resultList;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "ListMap";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
