// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.core.objectmanagement.member.MendixAutoNumber;
import com.mendix.core.objectmanagement.member.MendixObjectReference;
import com.mendix.core.objectmanagement.member.MendixObjectReferenceSet;
import com.mendix.systemwideinterfaces.core.IMendixObjectMember;
import com.mendix.webui.CustomJavaAction;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

/**
 * Clones objects fully - all attributes and associations
 * 
 * - Source: the original object to copy
 * - Target: the object to copy it into (should be of the same type, or a specialization)
 * 
 * System attributes are ignored
 */
public class Clone extends CustomJavaAction<java.lang.Void>
{
	private IMendixObject source;
	private IMendixObject target;

	public Clone(IContext context, IMendixObject source, IMendixObject target)
	{
		super(context);
		this.source = source;
		this.target = target;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		IContext c = this.getContext();
		Map<String, ? extends IMendixObjectMember<?>> members = source.getMembers(c);
		String type = source.getType() + "/";
		List<String> toskip = Arrays.asList(("createdDate,changedDate,System.owner,System.changedBy").split(","));
		for (String key : members.keySet()) {
			if (!toskip.contains(key) && !toskip.contains(type + key)) {
				IMendixObjectMember<?> m = members.get(key);
				if (m.isVirtual()) {
					continue;
				}
				if (m instanceof MendixAutoNumber) {
					continue;
				}
				target.setValue(c, key, m.getValue(c));
			}
		}
		return null;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Clone";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}