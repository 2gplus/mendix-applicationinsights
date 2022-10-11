// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package twogapplicationinsights.actions;

import com.mendix.logging.LogLevel;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import twogapplicationinsights.ApplicationInsightsLogger;
import twogapplicationinsights.proxies.LoggerLevel;
import twogapplicationinsights.proxies.SeverityLevel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GetLoggerLevels extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String InstrumentationKey;

	public GetLoggerLevels(IContext context, java.lang.String InstrumentationKey)
	{
		super(context);
		this.InstrumentationKey = InstrumentationKey;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE

		var retVal = new ArrayList<LoggerLevel>();

		if (InstrumentationKey == null || InstrumentationKey.length() == 0)
		{
			throw new Exception("Instrumentation key missing");
		}
		ApplicationInsightsLogger logger = ApplicationInsightsLogger.getInstance(InstrumentationKey);
		logger.getSubscriptions().forEach((k, v) -> {
			var ll = new LoggerLevel(getContext());
			ll.setLogNode(k.name());
			ll.setLogLevel(convert(v));
		});

		retVal.sort(Comparator.comparing(LoggerLevel::getLogNode));

		return retVal.stream().map(o -> o.getMendixObject()).collect(Collectors.toList());
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetLoggerLevels";
	}

	// BEGIN EXTRA CODE
	private SeverityLevel convert(LogLevel ll)
	{
		var retVal = SeverityLevel.Verbose;

		if (ll == LogLevel.CRITICAL)
		{
			retVal = SeverityLevel.Critical;
		}
		else if (ll == LogLevel.WARNING)
		{
			retVal = SeverityLevel.Warning;
		}
		else if (ll == LogLevel.INFO)
		{
			retVal = SeverityLevel.Information;
		}
		else if (ll == LogLevel.NONE)
		{
			retVal = SeverityLevel.None;
		}

		return retVal;
	}
	// END EXTRA CODE
}