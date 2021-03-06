// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package twogapplicationinsights.proxies;

public class TelemetryBase
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject telemetryBaseMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "TwoGApplicationInsights.TelemetryBase";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Timestamp("Timestamp"),
		SequenceId("SequenceId"),
		CustomProperties("TwoGApplicationInsights.CustomProperties");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public TelemetryBase(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "TwoGApplicationInsights.TelemetryBase"));
	}

	protected TelemetryBase(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject telemetryBaseMendixObject)
	{
		if (telemetryBaseMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.TelemetryBase", telemetryBaseMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a TwoGApplicationInsights.TelemetryBase");

		this.telemetryBaseMendixObject = telemetryBaseMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'TelemetryBase.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static twogapplicationinsights.proxies.TelemetryBase initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return twogapplicationinsights.proxies.TelemetryBase.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static twogapplicationinsights.proxies.TelemetryBase initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		if (com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.DependencyTelemetry", mendixObject.getType()))
			return twogapplicationinsights.proxies.DependencyTelemetry.initialize(context, mendixObject);

		if (com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.EventTelemetry", mendixObject.getType()))
			return twogapplicationinsights.proxies.EventTelemetry.initialize(context, mendixObject);

		if (com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.MetricTelemetry", mendixObject.getType()))
			return twogapplicationinsights.proxies.MetricTelemetry.initialize(context, mendixObject);

		if (com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.RequestTelemetry", mendixObject.getType()))
			return twogapplicationinsights.proxies.RequestTelemetry.initialize(context, mendixObject);

		if (com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.TelemetryWithMetricDataBase", mendixObject.getType()))
			return twogapplicationinsights.proxies.TelemetryWithMetricDataBase.initialize(context, mendixObject);

		if (com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.TraceTelemetry", mendixObject.getType()))
			return twogapplicationinsights.proxies.TraceTelemetry.initialize(context, mendixObject);

		return new twogapplicationinsights.proxies.TelemetryBase(context, mendixObject);
	}

	public static twogapplicationinsights.proxies.TelemetryBase load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return twogapplicationinsights.proxies.TelemetryBase.initialize(context, mendixObject);
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
	 * @return value of Timestamp
	 */
	public final java.util.Date getTimestamp()
	{
		return getTimestamp(getContext());
	}

	/**
	 * @param context
	 * @return value of Timestamp
	 */
	public final java.util.Date getTimestamp(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.Timestamp.toString());
	}

	/**
	 * Set value of Timestamp
	 * @param timestamp
	 */
	public final void setTimestamp(java.util.Date timestamp)
	{
		setTimestamp(getContext(), timestamp);
	}

	/**
	 * Set value of Timestamp
	 * @param context
	 * @param timestamp
	 */
	public final void setTimestamp(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date timestamp)
	{
		getMendixObject().setValue(context, MemberNames.Timestamp.toString(), timestamp);
	}

	/**
	 * @return value of SequenceId
	 */
	public final java.lang.String getSequenceId()
	{
		return getSequenceId(getContext());
	}

	/**
	 * @param context
	 * @return value of SequenceId
	 */
	public final java.lang.String getSequenceId(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.SequenceId.toString());
	}

	/**
	 * Set value of SequenceId
	 * @param sequenceid
	 */
	public final void setSequenceId(java.lang.String sequenceid)
	{
		setSequenceId(getContext(), sequenceid);
	}

	/**
	 * Set value of SequenceId
	 * @param context
	 * @param sequenceid
	 */
	public final void setSequenceId(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String sequenceid)
	{
		getMendixObject().setValue(context, MemberNames.SequenceId.toString(), sequenceid);
	}

	/**
	 * @return value of CustomProperties
	 */
	public final java.util.List<twogapplicationinsights.proxies.AppInsightProperty> getCustomProperties() throws com.mendix.core.CoreException
	{
		return getCustomProperties(getContext());
	}

	/**
	 * @param context
	 * @return value of CustomProperties
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<twogapplicationinsights.proxies.AppInsightProperty> getCustomProperties(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<twogapplicationinsights.proxies.AppInsightProperty> result = new java.util.ArrayList<twogapplicationinsights.proxies.AppInsightProperty>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.CustomProperties.toString());
		if (valueObject == null)
			return result;
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject))
			result.add(twogapplicationinsights.proxies.AppInsightProperty.initialize(context, mendixObject));
		return result;
	}

	/**
	 * Set value of CustomProperties
	 * @param customproperties
	 */
	public final void setCustomProperties(java.util.List<twogapplicationinsights.proxies.AppInsightProperty> customproperties)
	{
		setCustomProperties(getContext(), customproperties);
	}

	/**
	 * Set value of CustomProperties
	 * @param context
	 * @param customproperties
	 */
	public final void setCustomProperties(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<twogapplicationinsights.proxies.AppInsightProperty> customproperties)
	{
		java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier> identifiers = new java.util.ArrayList<com.mendix.systemwideinterfaces.core.IMendixIdentifier>();
		for (twogapplicationinsights.proxies.AppInsightProperty proxyObject : customproperties)
			identifiers.add(proxyObject.getMendixObject().getId());
		getMendixObject().setValue(context, MemberNames.CustomProperties.toString(), identifiers);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return telemetryBaseMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final twogapplicationinsights.proxies.TelemetryBase that = (twogapplicationinsights.proxies.TelemetryBase) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "TwoGApplicationInsights.TelemetryBase";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
