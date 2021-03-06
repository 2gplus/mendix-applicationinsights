// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package twogapplicationinsights.proxies;

public class ExceptionTelemetry extends twogapplicationinsights.proxies.TelemetryWithMetricDataBase
{
	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "TwoGApplicationInsights.ExceptionTelemetry";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Message("Message"),
		Severity("Severity"),
		Timestamp("Timestamp"),
		SequenceId("SequenceId"),
		AdditionalMetricData("TwoGApplicationInsights.AdditionalMetricData"),
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

	public ExceptionTelemetry(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "TwoGApplicationInsights.ExceptionTelemetry"));
	}

	protected ExceptionTelemetry(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject exceptionTelemetryMendixObject)
	{
		super(context, exceptionTelemetryMendixObject);
		if (!com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.ExceptionTelemetry", exceptionTelemetryMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a TwoGApplicationInsights.ExceptionTelemetry");
	}

	/**
	 * @deprecated Use 'ExceptionTelemetry.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static twogapplicationinsights.proxies.ExceptionTelemetry initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return twogapplicationinsights.proxies.ExceptionTelemetry.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static twogapplicationinsights.proxies.ExceptionTelemetry initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new twogapplicationinsights.proxies.ExceptionTelemetry(context, mendixObject);
	}

	public static twogapplicationinsights.proxies.ExceptionTelemetry load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return twogapplicationinsights.proxies.ExceptionTelemetry.initialize(context, mendixObject);
	}

	/**
	 * @return value of Message
	 */
	public final java.lang.String getMessage()
	{
		return getMessage(getContext());
	}

	/**
	 * @param context
	 * @return value of Message
	 */
	public final java.lang.String getMessage(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Message.toString());
	}

	/**
	 * Set value of Message
	 * @param message
	 */
	public final void setMessage(java.lang.String message)
	{
		setMessage(getContext(), message);
	}

	/**
	 * Set value of Message
	 * @param context
	 * @param message
	 */
	public final void setMessage(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String message)
	{
		getMendixObject().setValue(context, MemberNames.Message.toString(), message);
	}

	/**
	 * Set value of Severity
	 * @param severity
	 */
	public final twogapplicationinsights.proxies.SeverityLevel getSeverity()
	{
		return getSeverity(getContext());
	}

	/**
	 * @param context
	 * @return value of Severity
	 */
	public final twogapplicationinsights.proxies.SeverityLevel getSeverity(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.Severity.toString());
		if (obj == null)
			return null;

		return twogapplicationinsights.proxies.SeverityLevel.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of Severity
	 * @param severity
	 */
	public final void setSeverity(twogapplicationinsights.proxies.SeverityLevel severity)
	{
		setSeverity(getContext(), severity);
	}

	/**
	 * Set value of Severity
	 * @param context
	 * @param severity
	 */
	public final void setSeverity(com.mendix.systemwideinterfaces.core.IContext context, twogapplicationinsights.proxies.SeverityLevel severity)
	{
		if (severity != null)
			getMendixObject().setValue(context, MemberNames.Severity.toString(), severity.toString());
		else
			getMendixObject().setValue(context, MemberNames.Severity.toString(), null);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final twogapplicationinsights.proxies.ExceptionTelemetry that = (twogapplicationinsights.proxies.ExceptionTelemetry) obj;
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
		return "TwoGApplicationInsights.ExceptionTelemetry";
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
