// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import java.util.Collections;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Expects list of Mendix Objects as a parameter and returns list of same elements with randomized order.
 * 
 * See Java: Collections.shuffle()
 * 
 * Example:
 * Input: 1,2,3,4,5
 * Output: 3,5,2,1,4
 */
public class ListShuffle extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.util.List<IMendixObject> listToShuffle;

	public ListShuffle(IContext context, java.util.List<IMendixObject> listToShuffle)
	{
		super(context);
		this.listToShuffle = listToShuffle;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		Collections.shuffle(listToShuffle);
		return listToShuffle;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "ListShuffle";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
