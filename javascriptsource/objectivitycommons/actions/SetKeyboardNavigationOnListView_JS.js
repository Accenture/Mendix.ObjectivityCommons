// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
import "mx-global";
import { Big } from "big.js";
import { FocusNext } from "../../webactions/actions/FocusNext.js"
import { FocusPrevious } from "../../webactions/actions/FocusPrevious.js"

// BEGIN EXTRA CODE
function keyDownEventHandler(event, target) {
	if (event.keyCode === 13) {
		event.preventDefault();
		target.click();
	}
	else if (event.keyCode === 40) {
		FocusNext();
	}
	else if (event.keyCode === 38) {
		FocusPrevious();
	}
};
// END EXTRA CODE

/**
 * JavaScript Action JS_ListView_KeyboardNavigation provides keyboard navigation events on list view items
 * 
 * Dependency:
 *   WebActions module
 * 
 * Configuration:
 * 1. Import WebActions app store module.
 * 2. Include JS_ListView_KeyboardNavigation action in your project.
 * 3. Set unique name on List view widget Common tab.
 * 4. On page under listview add a data view with nanoflow data source having the JavaScript action.
 * 5. Configure the action by providing selector 'mx-name-<name from step 3>'.
 * @param {string} selector - List view name class e.g. 'mx-name-listview1'
 * @returns {Promise.<void>}
 */
export async function SetKeyboardNavigationOnListView_JS(selector) {
	// BEGIN USER CODE
	let ulNode = document.querySelector(selector + ' ul');
	if (!ulNode) return;
	let list = ulNode.children;
	for (const li of list) {
		li.addEventListener("keydown", function (event) {
			keyDownEventHandler(event, li);
		});
		li.setAttribute("tabindex", "0");
	}
	ulNode.removeEventListener("DOMNodeInserted", listKeyUpHandler);
	ulNode.addEventListener("DOMNodeInserted", listKeyUpHandler);

	function listKeyUpHandler(e) {
		if (e.target && e.target.tagName === 'LI') {
			e.target.addEventListener("keydown", function (event) {
				keyDownEventHandler(event, e.target);
			});
			e.target.setAttribute("tabindex", "0");
		}
	}
	// END USER CODE
}