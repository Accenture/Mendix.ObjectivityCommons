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
import java.util.List;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import objectivitycommons.proxies.KeyValue;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.thirdparty.org.json.JSONObject;

/**
 * Generates a list of attributes for provided JSON object as a KeyValue list.
 * 
 * Input: 
 *      JSON object (string)
 * 
 * Output: 
 *      List of KeyValue objects:
 *      KeyValue:
 *               - Key    - key of the attribute
 *               - Value - value of the attribute
 *               - Index - order number (0-indexed) within a single container
 * 
 * Example:
 *      For JSON: {"id":1, "name": "name1"}
 * 
 *      Result: [{Key: "id", Value: "1"}, {Key: "name", Value: "name1"}]
 */
public class JSON_Object_GetKeyValuePairs extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String JSON;

	public JSON_Object_GetKeyValuePairs(IContext context, java.lang.String JSON)
	{
		super(context);
		this.JSON = JSON;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
	    List<IMendixObject> result = new ArrayList<IMendixObject>();
	    IContext ctx = this.getContext();

		JSONObject obj = new JSONObject(JSON);
		String[] names = JSONObject.getNames(obj);
		for (int idxNames = 0 ; idxNames < names.length; idxNames++) {
			var key = names[idxNames];
			var value = obj.optString(key);
			KeyValue dto = new KeyValue(ctx);
		    dto.setKey(key);
		    dto.setValue(value);
		    dto.setIndex(idxNames);
		    result.add(dto.getMendixObject());
		}
		return result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "JSON_Object_GetKeyValuePairs";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
