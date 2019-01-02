// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package twogapplicationinsights.proxies;

public class MetricTelemetry extends twogapplicationinsights.proxies.TelemetryBase
{
	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "TwoGApplicationInsights.MetricTelemetry";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Name("Name"),
		Min("Min"),
		Max("Max"),
		Count("Count"),
		StandardDeviation("StandardDeviation"),
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

	public MetricTelemetry(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "TwoGApplicationInsights.MetricTelemetry"));
	}

	protected MetricTelemetry(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject metricTelemetryMendixObject)
	{
		super(context, metricTelemetryMendixObject);
		if (!com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.MetricTelemetry", metricTelemetryMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a TwoGApplicationInsights.MetricTelemetry");
	}

	/**
	 * @deprecated Use 'MetricTelemetry.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static twogapplicationinsights.proxies.MetricTelemetry initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return twogapplicationinsights.proxies.MetricTelemetry.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static twogapplicationinsights.proxies.MetricTelemetry initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new twogapplicationinsights.proxies.MetricTelemetry(context, mendixObject);
	}

	public static twogapplicationinsights.proxies.MetricTelemetry load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return twogapplicationinsights.proxies.MetricTelemetry.initialize(context, mendixObject);
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
	 * @return value of Min
	 */
	public final java.math.BigDecimal getMin()
	{
		return getMin(getContext());
	}

	/**
	 * @param context
	 * @return value of Min
	 */
	public final java.math.BigDecimal getMin(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.Min.toString());
	}

	/**
	 * Set value of Min
	 * @param min
	 */
	public final void setMin(java.math.BigDecimal min)
	{
		setMin(getContext(), min);
	}

	/**
	 * Set value of Min
	 * @param context
	 * @param min
	 */
	public final void setMin(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal min)
	{
		getMendixObject().setValue(context, MemberNames.Min.toString(), min);
	}

	/**
	 * @return value of Max
	 */
	public final java.math.BigDecimal getMax()
	{
		return getMax(getContext());
	}

	/**
	 * @param context
	 * @return value of Max
	 */
	public final java.math.BigDecimal getMax(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.Max.toString());
	}

	/**
	 * Set value of Max
	 * @param max
	 */
	public final void setMax(java.math.BigDecimal max)
	{
		setMax(getContext(), max);
	}

	/**
	 * Set value of Max
	 * @param context
	 * @param max
	 */
	public final void setMax(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal max)
	{
		getMendixObject().setValue(context, MemberNames.Max.toString(), max);
	}

	/**
	 * @return value of Count
	 */
	public final java.lang.Integer getCount()
	{
		return getCount(getContext());
	}

	/**
	 * @param context
	 * @return value of Count
	 */
	public final java.lang.Integer getCount(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.Count.toString());
	}

	/**
	 * Set value of Count
	 * @param count
	 */
	public final void setCount(java.lang.Integer count)
	{
		setCount(getContext(), count);
	}

	/**
	 * Set value of Count
	 * @param context
	 * @param count
	 */
	public final void setCount(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer count)
	{
		getMendixObject().setValue(context, MemberNames.Count.toString(), count);
	}

	/**
	 * @return value of StandardDeviation
	 */
	public final java.math.BigDecimal getStandardDeviation()
	{
		return getStandardDeviation(getContext());
	}

	/**
	 * @param context
	 * @return value of StandardDeviation
	 */
	public final java.math.BigDecimal getStandardDeviation(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.StandardDeviation.toString());
	}

	/**
	 * Set value of StandardDeviation
	 * @param standarddeviation
	 */
	public final void setStandardDeviation(java.math.BigDecimal standarddeviation)
	{
		setStandardDeviation(getContext(), standarddeviation);
	}

	/**
	 * Set value of StandardDeviation
	 * @param context
	 * @param standarddeviation
	 */
	public final void setStandardDeviation(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal standarddeviation)
	{
		getMendixObject().setValue(context, MemberNames.StandardDeviation.toString(), standarddeviation);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final twogapplicationinsights.proxies.MetricTelemetry that = (twogapplicationinsights.proxies.MetricTelemetry) obj;
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
		return "TwoGApplicationInsights.MetricTelemetry";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Override
	@Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
