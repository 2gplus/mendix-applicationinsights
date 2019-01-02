// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package twogapplicationinsights.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import com.microsoft.applicationinsights.telemetry.RemoteDependencyTelemetry;
import twogapplicationinsights.ApplicationInsightsLogger;
import twogapplicationinsights.helpers.TelemetryConverterHelper;

public class TrackDependency extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String InstrumentationKey;
	private IMendixObject __Dependency;
	private twogapplicationinsights.proxies.DependencyTelemetry Dependency;

	public TrackDependency(IContext context, java.lang.String InstrumentationKey, IMendixObject Dependency)
	{
		super(context);
		this.InstrumentationKey = InstrumentationKey;
		this.__Dependency = Dependency;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.Dependency = __Dependency == null ? null : twogapplicationinsights.proxies.DependencyTelemetry.initialize(getContext(), __Dependency);

		// BEGIN USER CODE

		// Step 1: Convert the Mendix Dependency object to the AppInsights Dependency object
		RemoteDependencyTelemetry rdt = TelemetryConverterHelper.convertRemoteDependencyTelemetry(Dependency);

		// Step 2: send the metric to AppInsights loggers
		if (InstrumentationKey == null || InstrumentationKey.length() == 0)
		{
			ApplicationInsightsLogger.sendDependencyToAll(rdt);
		}
		else
		{
			ApplicationInsightsLogger logger = ApplicationInsightsLogger.getInstance(InstrumentationKey);
			logger.sendDependency(rdt);
		}

		return Boolean.TRUE;

		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "TrackDependency";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
