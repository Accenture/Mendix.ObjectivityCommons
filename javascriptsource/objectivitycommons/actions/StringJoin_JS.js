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
 * See:
 * JamCommons: StringJoin
 * Java: String.join
 * JavaScript: Array.join
 * @param {MxObject[]} list - Input list of objects to join
 * @param {string} separator
 * @param {string} attribute - Name of attribute to get value to join for each List item
 * @returns {Promise.<string>}
 */
export async function StringJoin_JS(list, separator, attribute) {
	// BEGIN USER CODE
	let sep = separator || '';
	let atr = attribute || '';
	let parts = list.map(obj => obj.get(atr));
	let ret = parts.join(sep);
	return Promise.resolve(ret);
	// END USER CODE
}
