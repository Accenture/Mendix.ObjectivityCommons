/**
 * Returns first MxObject selected on data grid
 * @param {Object} grid - data grid dijit meta object
 * @returns {MxObject}
 */
export function getFirst(grid) {
	return grid._mxObjects.find(el => el.jsonData.guid === grid.selection[0]);
}

/**
 * Returns all MxObjects selected on data grid
 * @param {Object} grid - data grid dijit meta object
 * @returns {MxObject[]}
 */
export function getAll(grid) {
	if (grid._gridState.invertedSelection) {
		return grid._mxObjects.filter(el => !grid.selection.includes(el.jsonData.guid));
	}
	else
		return grid._mxObjects.filter(el => grid.selection.includes(el.jsonData.guid));
}

/**
 * Returns MxObjects that are displayed on data grid
 * @param {Object} grid - data grid dijit meta object
 * @param {Number} size - number of objects to return; set 0 for all
 * @returns {Promise.<MxObject[]>}
 */
export async function getSource(grid, size) {
let xPath = grid.getCurrentXPath();
return new Promise((resolve, reject) => {
	mx.data.get(
		{
			xpath: xPath,
			filter: {
				offset: 0,
				amount: size,
				sort: grid._dataSource._sorting
			},
			callback: function (objs) {
				resolve(objs);
			},
			error: function (error) {
				mx.logger.error(error);
				reject(error);
			}
		});
});
}