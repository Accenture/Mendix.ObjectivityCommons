// from NanoflowCommons
export function serializeMxObject(obj) {
	if (!obj) return null;
	return obj.getAttributes().reduce(function (accumulator, attr) {
		accumulator[attr] = obj.get(attr); // TODO: getMxObjectAttributeValue(obj, attr);
		return accumulator;
	}, {});
}

export function stringify(val, space) {
	return JSON.stringify(val, null, space ? Number(space) : 2);
}

//TODO
// async function getMxObjectAttributeValue(obj, attr) {
// 	let val = obj.get(attr);
// 	let getter =
// 		obj.isObjectReference(attr) ? {guid: val} :
// 		obj.isObjectReferenceSet(attr) ? {guids: val} :
// 		null;
// 	return new Promise((resolve, reject) => {
// 		if (getter) {
// 			getter['callback'] = function (res) {resolve(res);}
// 			getter['error'] = function (res) {reject(res);}
// 			mx.data.get(getter);
// 		}
// 		else resolve(val);
// 	});
// }