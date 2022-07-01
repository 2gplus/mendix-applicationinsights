// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package twogapplicationinsights.proxies;

/**
 * This class can be used to add context data to the telemetry that is being sent
 */
public class AppInsightProperty
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject appInsightPropertyMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "TwoGApplicationInsights.AppInsightProperty";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Name("Name"),
		Value("Value"),
		CustomProperties("TwoGApplicationInsights.CustomProperties");

		private java.lang.String metaName;

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

	public AppInsightProperty(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "TwoGApplicationInsights.AppInsightProperty"));
	}

	protected AppInsightProperty(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject appInsightPropertyMendixObject)
	{
		if (appInsightPropertyMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.AppInsightProperty", appInsightPropertyMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a TwoGApplicationInsights.AppInsightProperty");

		this.appInsightPropertyMendixObject = appInsightPropertyMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'AppInsightProperty.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static twogapplicationinsights.proxies.AppInsightProperty initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return twogapplicationinsights.proxies.AppInsightProperty.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static twogapplicationinsights.proxies.AppInsightProperty initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new twogapplicationinsights.proxies.AppInsightProperty(context, mendixObject);
	}

	public static twogapplicationinsights.proxies.AppInsightProperty load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return twogapplicationinsights.proxies.AppInsightProperty.initialize(context, mendixObject);
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
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
	 * @return value of Value
	 */
	public final java.lang.String getValue()
	{
		return getValue(getContext());
	}

	/**
	 * @param context
	 * @return value of Value
	 */
	public final java.lang.String getValue(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Value.toString());
	}

	/**
	 * Set value of Value
	 * @param value
	 */
	public final void setValue(java.lang.String value)
	{
		setValue(getContext(), value);
	}

	/**
	 * Set value of Value
	 * @param context
	 * @param value
	 */
	public final void setValue(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String value)
	{
		getMendixObject().setValue(context, MemberNames.Value.toString(), value);
	}

	/**
	 * @return value of CustomProperties
	 */
	public final java.util.List<twogapplicationinsights.proxies.TelemetryBase> getCustomProperties() throws com.mendix.core.CoreException
	{
		return getCustomProperties(getContext());
	}

	/**
	 * @param context
	 * @return value of CustomProperties
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<twogapplicationinsights.proxies.TelemetryBase> getCustomProperties(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<twogapplicationinsights.proxies.TelemetryBase> result = new java.util.ArrayList<twogapplicationinsights.proxies.TelemetryBase>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.CustomProperties.toString());
		if (valueObject == null)
			return result;
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject))
			result.add(twogapplicationinsights.proxies.TelemetryBase.initialize(context, mendixObject));
		return result;
	}

	/**
	 * Set value of CustomProperties
	 * @param customproperties
	 */
	public final void setCustomProperties(java.util.List<twogapplicationinsights.proxies.TelemetryBase> customproperties)
	{
		setCustomProperties(getContext(), customproperties);
	}

	/**
	 * Set value of CustomProperties
	 * @param context
	 * @param customproperties
	 */
	public final void setCustomProperties(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<twogapplicationinsights.proxies.TelemetryBase> customproperties)
	{
		java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier> identifiers = new java.util.ArrayList<com.mendix.systemwideinterfaces.core.IMendixIdentifier>();
		for (twogapplicationinsights.proxies.TelemetryBase proxyObject : customproperties)
			identifiers.add(proxyObject.getMendixObject().getId());
		getMendixObject().setValue(context, MemberNames.CustomProperties.toString(), identifiers);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return appInsightPropertyMendixObject;
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
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final twogapplicationinsights.proxies.AppInsightProperty that = (twogapplicationinsights.proxies.AppInsightProperty) obj;
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
		return "TwoGApplicationInsights.AppInsightProperty";
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
