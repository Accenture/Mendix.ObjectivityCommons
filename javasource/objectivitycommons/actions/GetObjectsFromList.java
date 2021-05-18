// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.core.Core;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.systemwideinterfaces.core.meta.IMetaObject;
import com.mendix.systemwideinterfaces.core.meta.IMetaAssociation;
import com.mendix.systemwideinterfaces.core.meta.IMetaAssociation.AssociationType;
import com.mendix.core.objectmanagement.member.MendixObjectReference;
import com.mendix.core.objectmanagement.member.MendixObjectReferenceSet;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.mendix.systemwideinterfaces.javaactions.parameters.ITemplateParameter;

/**
 * // XPathConstraint - write a single space in case you do not want to set xpath constraint
 */
public class GetObjectsFromList extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String InputEntity;
	private java.util.List<IMendixObject> SourceList;
	private java.lang.String Reference;
	private java.lang.String OutputEntity;
	private java.lang.Boolean UseXpath;
	private com.mendix.systemwideinterfaces.javaactions.parameters.IStringTemplate XPathConstraint;
	private java.lang.Boolean UseAndConjunction;

	public GetObjectsFromList(IContext context, java.lang.String InputEntity, java.util.List<IMendixObject> SourceList, java.lang.String Reference, java.lang.String OutputEntity, java.lang.Boolean UseXpath, com.mendix.systemwideinterfaces.javaactions.parameters.IStringTemplate XPathConstraint, java.lang.Boolean UseAndConjunction)
	{
		super(context);
		this.InputEntity = InputEntity;
		this.SourceList = SourceList;
		this.Reference = Reference;
		this.OutputEntity = OutputEntity;
		this.UseXpath = UseXpath;
		this.XPathConstraint = XPathConstraint;
		this.UseAndConjunction = UseAndConjunction;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		IContext ct = this.getContext();
		
		// 0. check if input list is not empty
		if (this.SourceList.size() == 0) return null;
		if (this.Reference == null || this.Reference.isBlank()) throw new com.mendix.systemwideinterfaces.MendixRuntimeException("Reference cannot be empty");

		// 1. check if entity has member defined in reference
		IMetaObject inputMeta = Core.getMetaObject(this.InputEntity);
		IMetaAssociation associationParentMeta = inputMeta.getMetaAssociationParent(this.Reference);
		IMetaAssociation associationChildMeta = inputMeta.getMetaAssociationChild(this.Reference);

		if (associationParentMeta == null && associationChildMeta == null) throw new com.mendix.systemwideinterfaces.MendixRuntimeException("Entity " + this.InputEntity + " does not contain association with declared name: " + this.Reference);
		boolean isParent = associationParentMeta != null ? true : false;

		IMetaAssociation associationMeta = isParent ? associationParentMeta : associationChildMeta;

		if (!isParent && !this.UseXpath) throw new com.mendix.systemwideinterfaces.MendixRuntimeException("Object is not an owner of the association with declared name: " + this.Reference);

		// 2. check if member is of type reference set 
		boolean isSet = associationMeta.getType() == AssociationType.REFERENCESET;

		//if (!isSet) throw new com.mendix.systemwideinterfaces.MendixRuntimeException("Declared association is not of Reference Set type");
		
		// 3. check if set corresponds to output entity
		boolean correctChild;
		if (isParent){
			IMetaObject childMeta = associationMeta.getChild();
			correctChild = childMeta.getName().equals(this.OutputEntity);	//or child subobjects equal this outputEntity
			if (!correctChild) {
				// childSubClasses.stream().filter(childOjbect -> this.OutputEntity.equals(childOjbect.getName())).findAny().orElse(null);
				List<IMetaObject> childSubClasses = (List<IMetaObject>) childMeta.getSubObjects();
				IMetaObject outputMeta = Core.getMetaObject(this.OutputEntity);
				correctChild = childSubClasses.contains(outputMeta);
			}
		}
		else {
			IMetaObject parentMeta = associationMeta.getParent();
			correctChild = parentMeta.getName().equals(this.OutputEntity);
			if (!correctChild) {
				List<IMetaObject> parentSubClasses = (List<IMetaObject>) parentMeta.getSubObjects();
				IMetaObject outputMeta = Core.getMetaObject(this.OutputEntity);
				correctChild = parentSubClasses.contains(outputMeta);
			}
		}
		if (!correctChild) throw new com.mendix.systemwideinterfaces.MendixRuntimeException("Declared association is not connected to the defined entity: " + this.OutputEntity); 

		// 4. retrieve data
		if (this.UseXpath){
			String xpath = "";
			String andOr = this.UseAndConjunction ? " and " : " or ";
			for (IMendixObject object : this.SourceList){
				xpath +=  andOr + this.Reference + "=" + object.getId().toLong();
			}

			// --- xpath
			List<ITemplateParameter> pars = this.XPathConstraint.getParameters();
			String xp = this.XPathConstraint.replacePlaceholders((placeholder, idx) -> {
				ITemplateParameter par = pars.get(idx - 1);
				Object value = par.getValue();
				if (value == null) return "NULL";
				String val = value.toString();
				switch (par.getParameterType()) {
						case STRING: return String.format("'%s'", val.replace("'", "&apos;"));
						case BOOLEAN: return String.format("%s()", val);
						case DATETIME: return String.valueOf(((Date)value).getTime());
						default: return val;
					}
			});

			xpath =String.format("//%s[", this.OutputEntity) + xpath.substring(4) + "]" + xp.toString();
			return Core.retrieveXPathQuery(ct, xpath);
		}
		else {

			List<IMendixIdentifier> childIdList = new ArrayList<IMendixIdentifier>();

			for (IMendixObject object : this.SourceList){
				if (isSet) {
					MendixObjectReferenceSet referenceSet = (MendixObjectReferenceSet) object.getMember(ct, this.Reference);
					childIdList.addAll(referenceSet.getValue(ct));
				}
				else {
					MendixObjectReference reference = (MendixObjectReference) object.getMember(ct, this.Reference);
					childIdList.add(reference.getValue(ct));
				}
			}

			childIdList = childIdList.stream()
			.distinct()
			.collect(Collectors.toList());
			return Core.retrieveIdList(ct, childIdList);			
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetObjectsFromList";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
