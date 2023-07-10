// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package oql.proxies;

public class ExamplePersonResult
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject examplePersonResultMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "OQL.ExamplePersonResult";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Number("Number"),
		Name("Name"),
		DateOfBirth("DateOfBirth"),
		Age("Age"),
		LongAge("LongAge"),
		Active("Active"),
		HeightInDecimal("HeightInDecimal"),
		Gender("Gender"),
		ExamplePersonResult_ExamplePerson("OQL.ExamplePersonResult_ExamplePerson"),
		Result_MarriedTo("OQL.Result_MarriedTo");

		private final java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public ExamplePersonResult(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected ExamplePersonResult(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject examplePersonResultMendixObject)
	{
		if (examplePersonResultMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, examplePersonResultMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.examplePersonResultMendixObject = examplePersonResultMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'ExamplePersonResult.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static oql.proxies.ExamplePersonResult initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return oql.proxies.ExamplePersonResult.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static oql.proxies.ExamplePersonResult initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new oql.proxies.ExamplePersonResult(context, mendixObject);
	}

	public static oql.proxies.ExamplePersonResult load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return oql.proxies.ExamplePersonResult.initialize(context, mendixObject);
	}

	/**
	 * Commit the changes made on this proxy object.
	 * @throws com.mendix.core.CoreException
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 * @throws com.mendix.core.CoreException
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of Number
	 */
	public final java.lang.Long getNumber()
	{
		return getNumber(getContext());
	}

	/**
	 * @param context
	 * @return value of Number
	 */
	public final java.lang.Long getNumber(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Long) getMendixObject().getValue(context, MemberNames.Number.toString());
	}

	/**
	 * Set value of Number
	 * @param number
	 */
	public final void setNumber(java.lang.Long number)
	{
		setNumber(getContext(), number);
	}

	/**
	 * Set value of Number
	 * @param context
	 * @param number
	 */
	public final void setNumber(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Long number)
	{
		getMendixObject().setValue(context, MemberNames.Number.toString(), number);
	}

	/**
	 * @return value of Name
	 */
	public final java.lang.String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final java.lang.String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(java.lang.String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @return value of DateOfBirth
	 */
	public final java.util.Date getDateOfBirth()
	{
		return getDateOfBirth(getContext());
	}

	/**
	 * @param context
	 * @return value of DateOfBirth
	 */
	public final java.util.Date getDateOfBirth(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.DateOfBirth.toString());
	}

	/**
	 * Set value of DateOfBirth
	 * @param dateofbirth
	 */
	public final void setDateOfBirth(java.util.Date dateofbirth)
	{
		setDateOfBirth(getContext(), dateofbirth);
	}

	/**
	 * Set value of DateOfBirth
	 * @param context
	 * @param dateofbirth
	 */
	public final void setDateOfBirth(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date dateofbirth)
	{
		getMendixObject().setValue(context, MemberNames.DateOfBirth.toString(), dateofbirth);
	}

	/**
	 * @return value of Age
	 */
	public final java.lang.Integer getAge()
	{
		return getAge(getContext());
	}

	/**
	 * @param context
	 * @return value of Age
	 */
	public final java.lang.Integer getAge(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.Age.toString());
	}

	/**
	 * Set value of Age
	 * @param age
	 */
	public final void setAge(java.lang.Integer age)
	{
		setAge(getContext(), age);
	}

	/**
	 * Set value of Age
	 * @param context
	 * @param age
	 */
	public final void setAge(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer age)
	{
		getMendixObject().setValue(context, MemberNames.Age.toString(), age);
	}

	/**
	 * @return value of LongAge
	 */
	public final java.lang.Long getLongAge()
	{
		return getLongAge(getContext());
	}

	/**
	 * @param context
	 * @return value of LongAge
	 */
	public final java.lang.Long getLongAge(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Long) getMendixObject().getValue(context, MemberNames.LongAge.toString());
	}

	/**
	 * Set value of LongAge
	 * @param longage
	 */
	public final void setLongAge(java.lang.Long longage)
	{
		setLongAge(getContext(), longage);
	}

	/**
	 * Set value of LongAge
	 * @param context
	 * @param longage
	 */
	public final void setLongAge(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Long longage)
	{
		getMendixObject().setValue(context, MemberNames.LongAge.toString(), longage);
	}

	/**
	 * @return value of Active
	 */
	public final java.lang.Boolean getActive()
	{
		return getActive(getContext());
	}

	/**
	 * @param context
	 * @return value of Active
	 */
	public final java.lang.Boolean getActive(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Boolean) getMendixObject().getValue(context, MemberNames.Active.toString());
	}

	/**
	 * Set value of Active
	 * @param active
	 */
	public final void setActive(java.lang.Boolean active)
	{
		setActive(getContext(), active);
	}

	/**
	 * Set value of Active
	 * @param context
	 * @param active
	 */
	public final void setActive(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Boolean active)
	{
		getMendixObject().setValue(context, MemberNames.Active.toString(), active);
	}

	/**
	 * @return value of HeightInDecimal
	 */
	public final java.math.BigDecimal getHeightInDecimal()
	{
		return getHeightInDecimal(getContext());
	}

	/**
	 * @param context
	 * @return value of HeightInDecimal
	 */
	public final java.math.BigDecimal getHeightInDecimal(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.HeightInDecimal.toString());
	}

	/**
	 * Set value of HeightInDecimal
	 * @param heightindecimal
	 */
	public final void setHeightInDecimal(java.math.BigDecimal heightindecimal)
	{
		setHeightInDecimal(getContext(), heightindecimal);
	}

	/**
	 * Set value of HeightInDecimal
	 * @param context
	 * @param heightindecimal
	 */
	public final void setHeightInDecimal(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal heightindecimal)
	{
		getMendixObject().setValue(context, MemberNames.HeightInDecimal.toString(), heightindecimal);
	}

	/**
	 * Set value of Gender
	 * @param gender
	 */
	public final oql.proxies.Gender getGender()
	{
		return getGender(getContext());
	}

	/**
	 * @param context
	 * @return value of Gender
	 */
	public final oql.proxies.Gender getGender(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.Gender.toString());
		if (obj == null) {
			return null;
		}
		return oql.proxies.Gender.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of Gender
	 * @param gender
	 */
	public final void setGender(oql.proxies.Gender gender)
	{
		setGender(getContext(), gender);
	}

	/**
	 * Set value of Gender
	 * @param context
	 * @param gender
	 */
	public final void setGender(com.mendix.systemwideinterfaces.core.IContext context, oql.proxies.Gender gender)
	{
		if (gender != null) {
			getMendixObject().setValue(context, MemberNames.Gender.toString(), gender.toString());
		} else {
			getMendixObject().setValue(context, MemberNames.Gender.toString(), null);
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of ExamplePersonResult_ExamplePerson
	 */
	public final oql.proxies.ExamplePerson getExamplePersonResult_ExamplePerson() throws com.mendix.core.CoreException
	{
		return getExamplePersonResult_ExamplePerson(getContext());
	}

	/**
	 * @param context
	 * @return value of ExamplePersonResult_ExamplePerson
	 * @throws com.mendix.core.CoreException
	 */
	public final oql.proxies.ExamplePerson getExamplePersonResult_ExamplePerson(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		oql.proxies.ExamplePerson result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.ExamplePersonResult_ExamplePerson.toString());
		if (identifier != null) {
			result = oql.proxies.ExamplePerson.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of ExamplePersonResult_ExamplePerson
	 * @param examplepersonresult_exampleperson
	 */
	public final void setExamplePersonResult_ExamplePerson(oql.proxies.ExamplePerson examplepersonresult_exampleperson)
	{
		setExamplePersonResult_ExamplePerson(getContext(), examplepersonresult_exampleperson);
	}

	/**
	 * Set value of ExamplePersonResult_ExamplePerson
	 * @param context
	 * @param examplepersonresult_exampleperson
	 */
	public final void setExamplePersonResult_ExamplePerson(com.mendix.systemwideinterfaces.core.IContext context, oql.proxies.ExamplePerson examplepersonresult_exampleperson)
	{
		if (examplepersonresult_exampleperson == null) {
			getMendixObject().setValue(context, MemberNames.ExamplePersonResult_ExamplePerson.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.ExamplePersonResult_ExamplePerson.toString(), examplepersonresult_exampleperson.getMendixObject().getId());
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Result_MarriedTo
	 */
	public final oql.proxies.ExamplePerson getResult_MarriedTo() throws com.mendix.core.CoreException
	{
		return getResult_MarriedTo(getContext());
	}

	/**
	 * @param context
	 * @return value of Result_MarriedTo
	 * @throws com.mendix.core.CoreException
	 */
	public final oql.proxies.ExamplePerson getResult_MarriedTo(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		oql.proxies.ExamplePerson result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Result_MarriedTo.toString());
		if (identifier != null) {
			result = oql.proxies.ExamplePerson.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of Result_MarriedTo
	 * @param result_marriedto
	 */
	public final void setResult_MarriedTo(oql.proxies.ExamplePerson result_marriedto)
	{
		setResult_MarriedTo(getContext(), result_marriedto);
	}

	/**
	 * Set value of Result_MarriedTo
	 * @param context
	 * @param result_marriedto
	 */
	public final void setResult_MarriedTo(com.mendix.systemwideinterfaces.core.IContext context, oql.proxies.ExamplePerson result_marriedto)
	{
		if (result_marriedto == null) {
			getMendixObject().setValue(context, MemberNames.Result_MarriedTo.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.Result_MarriedTo.toString(), result_marriedto.getMendixObject().getId());
		}
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return examplePersonResultMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
			return true;
		}
		if (obj != null && getClass().equals(obj.getClass()))
		{
			final oql.proxies.ExamplePersonResult that = (oql.proxies.ExamplePersonResult) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return entityName;
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
