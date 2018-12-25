package twogapplicationinsights.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microsoft.applicationinsights.telemetry.SeverityLevel;
import com.microsoft.applicationinsights.telemetry.Telemetry;

import twogapplicationinsights.proxies.AppInsightProperty;

public class DataHelper
{
	/**
	 * This method will convert the properties into a map with simple string/string properties so they acn be added to the App Insights telemetry classes.
	 * 
	 * @param properties The properties as defined in the models
	 * @return The converted properties
	 */
	public static Map<String, String> convertProperties(List<AppInsightProperty> properties)
	{
		HashMap<String, String> retVal = new HashMap<String, String>();

		if (properties != null && properties.size() > 0)
		{
			for (AppInsightProperty property : properties)
			{
				retVal.put(property.getName(), property.getValue());
			}
		}

		return retVal;
	}

	/**
	 * This method adds the properties to the telemetry request.
	 * 
	 * @param t The telemetry to add the properties to
	 * @param properties The properties to add
	 */
	public static void addToTelemetry(Telemetry t, List<AppInsightProperty> properties)
	{
		if (t != null && properties != null)
		{
			Map<String, String> props = t.getProperties();

			for (AppInsightProperty property : properties)
			{
				props.put(property.getName(), property.getValue());
			}
		}
	}

	/**
	 * This method converts the Mendix proxy for the severity level to the App Insights Severity Level
	 * 
	 * @param src The Mendix proxy
	 * @return The AppInsights severity
	 */
	public static SeverityLevel convert(twogapplicationinsights.proxies.SeverityLevel src)
	{
		SeverityLevel retVal = SeverityLevel.Verbose;

		if (src != null)
		{
			switch (src)
			{
			case Critical:
				return SeverityLevel.Critical;
			case Error:
				return SeverityLevel.Error;
			case Information:
				return SeverityLevel.Information;
			case Warning:
				return SeverityLevel.Warning;
			case Verbose:
				return SeverityLevel.Verbose;
			}
		}
		return retVal;
	}
}
