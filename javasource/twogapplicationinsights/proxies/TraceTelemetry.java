// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package twogapplicationinsights.proxies;

public class TraceTelemetry extends twogapplicationinsights.proxies.TelemetryBase
{
	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "TwoGApplicationInsights.TraceTelemetry";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Message("Message"),
		Level("Level"),
		Timestamp("Timestamp"),
		SequenceId("SequenceId"),
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

	public TraceTelemetry(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "TwoGApplicationInsights.TraceTelemetry"));
	}

	protected TraceTelemetry(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject traceTelemetryMendixObject)
	{
		super(context, traceTelemetryMendixObject);
		if (!com.mendix.core.Core.isSubClassOf("TwoGApplicationInsights.TraceTelemetry", traceTelemetryMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a TwoGApplicationInsights.TraceTelemetry");
	}

	/**
	 * @deprecated Use 'TraceTelemetry.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static twogapplicationinsights.proxies.TraceTelemetry initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return twogapplicationinsights.proxies.TraceTelemetry.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static twogapplicationinsights.proxies.TraceTelemetry initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new twogapplicationinsights.proxies.TraceTelemetry(context, mendixObject);
	}

	public static twogapplicationinsights.proxies.TraceTelemetry load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return twogapplicationinsights.proxies.TraceTelemetry.initialize(context, mendixObject);
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
	 * Set value of Level
	 * @param level
	 */
	public final twogapplicationinsights.proxies.SeverityLevel getLevel()
	{
		return getLevel(getContext());
	}

	/**
	 * @param context
	 * @return value of Level
	 */
	public final twogapplicationinsights.proxies.SeverityLevel getLevel(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.Level.toString());
		if (obj == null)
			return null;

		return twogapplicationinsights.proxies.SeverityLevel.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of Level
	 * @param level
	 */
	public final void setLevel(twogapplicationinsights.proxies.SeverityLevel level)
	{
		setLevel(getContext(), level);
	}

	/**
	 * Set value of Level
	 * @param context
	 * @param level
	 */
	public final void setLevel(com.mendix.systemwideinterfaces.core.IContext context, twogapplicationinsights.proxies.SeverityLevel level)
	{
		if (level != null)
			getMendixObject().setValue(context, MemberNames.Level.toString(), level.toString());
		else
			getMendixObject().setValue(context, MemberNames.Level.toString(), null);
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final twogapplicationinsights.proxies.TraceTelemetry that = (twogapplicationinsights.proxies.TraceTelemetry) obj;
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
		return "TwoGApplicationInsights.TraceTelemetry";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Override
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
