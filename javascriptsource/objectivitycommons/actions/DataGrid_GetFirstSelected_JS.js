// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
import { Big } from "big.js";
import { getFirst } from "./Grid_SelectionHelper.js"

// BEGIN EXTRA CODE


// END EXTRA CODE

/**
 * This action returns first selected object from `grid`.
 * @param {string} gridName - DOM selector of data grid e.g. mx-name-datagrid0
 * @param {string} outputEntity - Type of returned object list
 * @returns {Promise.<MxObject>}
 */
export async function DataGrid_GetFirstSelected_JS(gridName, outputEntity) {
	// BEGIN USER CODE
    let node = document.querySelector("." + gridName);
    let grid = dijit.registry.byNode(node);
    let selectedMxObjects = getFirst(grid);
    return selectedMxObjects;
	// END USER CODE
}
