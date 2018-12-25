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
import com.mendix.webui.CustomJavaAction;
import com.mendix.core.Core;
import twogapplicationinsights.ApplicationInsightsLogger;
import twogapplicationinsights.helpers.DataHelper;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Use this action in the startup flow to initialize the connection to the Application Insights container. The instrumentation key is mandatory
 */
public class InitializeApplicationInsights extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String InstrumentationKey;
	private java.lang.String Application;
	private java.lang.String LogLevel;
	private java.util.List<IMendixObject> __StandardProperties;
	private java.util.List<twogapplicationinsights.proxies.AppInsightProperty> StandardProperties;

	public InitializeApplicationInsights(IContext context, java.lang.String InstrumentationKey, java.lang.String Application, java.lang.String LogLevel, java.util.List<IMendixObject> StandardProperties)
	{
		super(context);
		this.InstrumentationKey = InstrumentationKey;
		this.Application = Application;
		this.LogLevel = LogLevel;
		this.__StandardProperties = StandardProperties;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.StandardProperties = new java.util.ArrayList<twogapplicationinsights.proxies.AppInsightProperty>();
		if (__StandardProperties != null)
			for (IMendixObject __StandardPropertiesElement : __StandardProperties)
				this.StandardProperties.add(twogapplicationinsights.proxies.AppInsightProperty.initialize(getContext(), __StandardPropertiesElement));

		// BEGIN USER CODE
		if (InstrumentationKey == null || InstrumentationKey.trim().length() == 0)
		{
			throw new IllegalArgumentException("The instrumentation key must be filled.");
		}

		ApplicationInsightsLogger logger = ApplicationInsightsLogger.getInstance(InstrumentationKey);

		// Set the log level if something else that INFO is wanted
		if ((this.LogLevel != null) && !this.LogLevel.isEmpty())
		{
			logger.setLogLevel(com.mendix.logging.LogLevel.valueOf(this.LogLevel.toUpperCase()));
		}
		
		logger.setApplicationContextId(Application);
		
		logger.setStaticProperties(DataHelper.convertProperties(StandardProperties));
		
		

		Core.registerLogSubscriber(logger);

		return Boolean.TRUE;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "InitializeApplicationInsights";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
