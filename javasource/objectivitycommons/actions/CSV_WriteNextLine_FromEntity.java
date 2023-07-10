// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.meta.IMetaObject;
import com.mendix.systemwideinterfaces.core.meta.IMetaPrimitive;
import com.mendix.webui.CustomJavaAction;
import com.opencsv.CSVWriter;
import csv.impl.CSV;
import objectivitycommons.proxies.StringValue;

/**
 * Safer alternative for WriteNextLine from CSV module.
 * This one is more safe:
 * the original one throws an exception if the entity has more attributes than file columns.
 * 
 * Writes all (configured) attribute values from the entity as column values of CSV row.
 * This action should only be invoked from the microflow used by a ExportCSV action.
 * All attribute vales will be exported as Strings (using toString()); thus specific parsing should be part of the microflow.
 */
public class CSV_WriteNextLine_FromEntity extends CustomJavaAction<java.lang.Void>
{
	private IMendixObject Line;
	private java.lang.Boolean SortAttributesOnMapping;
	private java.lang.String AttributesToIgnore;
	private java.lang.Long AttributesToTake;
	private java.util.List<IMendixObject> __AdditionalValues;
	private java.util.List<objectivitycommons.proxies.KeyValue> AdditionalValues;

	public CSV_WriteNextLine_FromEntity(IContext context, IMendixObject Line, java.lang.Boolean SortAttributesOnMapping, java.lang.String AttributesToIgnore, java.lang.Long AttributesToTake, java.util.List<IMendixObject> AdditionalValues)
	{
		super(context);
		this.Line = Line;
		this.SortAttributesOnMapping = SortAttributesOnMapping;
		this.AttributesToIgnore = AttributesToIgnore;
		this.AttributesToTake = AttributesToTake;
		this.__AdditionalValues = AdditionalValues;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		this.AdditionalValues = java.util.Optional.ofNullable(this.__AdditionalValues)
			.orElse(java.util.Collections.emptyList())
			.stream()
			.map(__AdditionalValuesElement -> objectivitycommons.proxies.KeyValue.initialize(getContext(), __AdditionalValuesElement))
			.collect(java.util.stream.Collectors.toList());

		// BEGIN USER CODE

		/*
		 * Everything below is a copy from the original code - except of lines marked with //OBJ-ADDED and //OBJ-CHNAGED
		 */
		ILogNode logger = CSV.getLogger();
		Object contextObj = getContext().getData().get(CSV.CONTEXT_WRITER_OBJ);
		if (contextObj == null || !(contextObj instanceof CSVWriter)) {
			throw new CoreException("Reader not found, this action should be invoked from a Export CSV microflow.");
		}
		
		@SuppressWarnings("resource") // reader is closed by the ImportCSV action
		CSVWriter writer = (CSVWriter) contextObj;

		IMetaObject metaObject = Line.getMetaObject();
		//String[] csvLine = new String[metaObject.getDeclaredMetaPrimitives().size()];	//OBJ-CHNAGED: moved down: after setting limit
		String[] attributes = new String[metaObject.getDeclaredMetaPrimitives().size()];
		int offset = 0;
		
		//OBJ-ADDED
		List<String> ignoreAttribs = Arrays.asList(
			Optional
			.ofNullable(this.AttributesToIgnore)
			.orElse("")
			.split(",")
		);

		for (IMetaPrimitive primitive : metaObject.getDeclaredMetaPrimitives()) {
			String attributeName = primitive.getName();						//OBJ-ADDED
			if (ignoreAttribs.contains(attributeName)) continue;			//OBJ-ADDED
			attributes[offset] = attributeName;								//OBJ-CHNAGED: was: primitive.getName()
			offset++;
		}

		if (this.SortAttributesOnMapping) {									//OBJ-ADDED
			Arrays.sort(attributes);
		}																	//OBJ-ADDED

		//OBJ-ADDED (whole 3 lines section below)
		int limit = AttributesToTake == null ? 0 : AttributesToTake.intValue();
		if (limit == 0) limit = offset; // real length of  attributes: (excl. AttributesToIgnore)
		String[] csvLine = new String[limit + AdditionalValues.size()];

		IContext ctx = this.getContext();									//OBJ-ADDED
		for (offset = 0; offset < limit; offset++) {						//OBJ-CHNAGED: was: offset < attributes.length
			Object value = Line.getValue(ctx, attributes[offset]);			//OBJ-CHNAGED: was: getValue(getContext(), ...)
			if (value != null) {
				csvLine[offset] = value.toString();
			} else {
				csvLine[offset] = null;
			}
		}

		//OBJ-ADDED (whole loop section below)
		for (StringValue obj : AdditionalValues) {
			csvLine[offset] = obj.getValue();
			offset++;
		}

		writer.writeNext(csvLine);
		logger.trace("Written line to CSV.");
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
		return "CSV_WriteNextLine_FromEntity";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
