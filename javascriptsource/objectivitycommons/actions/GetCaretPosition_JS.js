// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
import "mx-global";
import { Big } from "big.js";

// BEGIN EXTRA CODE
// END EXTRA CODE

/**
 * @returns {Promise.<Big>}
 */
export async function GetCaretPosition_JS() {
	// BEGIN USER CODE
	var place;
  	var input = document.querySelector('.mx-input-stayfocused').children.item(0);
	place = input.selectionEnd;
	return place
	
	// END USER CODE
}
