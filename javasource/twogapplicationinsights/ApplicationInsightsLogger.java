package twogapplicationinsights;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.logging.LogLevel;
import com.mendix.logging.LogMessage;
import com.mendix.logging.LogSubscriber;
import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;
import com.microsoft.applicationinsights.channel.concrete.inprocess.InProcessTelemetryChannel;
import com.microsoft.applicationinsights.telemetry.EventTelemetry;
import com.microsoft.applicationinsights.telemetry.ExceptionTelemetry;
import com.microsoft.applicationinsights.telemetry.MetricTelemetry;
import com.microsoft.applicationinsights.telemetry.PageViewTelemetry;
import com.microsoft.applicationinsights.telemetry.RemoteDependencyTelemetry;
import com.microsoft.applicationinsights.telemetry.RequestTelemetry;
import com.microsoft.applicationinsights.telemetry.SeverityLevel;
import com.microsoft.applicationinsights.telemetry.TraceTelemetry;

/**
 * This class is
 * 
 * @author pgussow
 */
public class ApplicationInsightsLogger extends LogSubscriber
{
	/** Holds the logger category that is used internally by this class. */
	private static String AI_LOGGER_CATEGORY = "TwoGApplicationInsights";

	/** Holds all the loggers that have been created indexed on instrumentation key */
	private static HashMap<String, ApplicationInsightsLogger> _loggers = new HashMap<>();

	/** Holds whether or not the logging to AppInsights should be stopped */
	private volatile boolean _stopped = false;

	/** Holds the telemetry client to Application Insights */
	private TelemetryClient _client;

	/** Holds the application context id that can be used. */
	private Map<String, String> _staticProperties = new HashMap<>();

	/**
	 * Holds the internal Mendix logger to log configuration information to. information logged here is not guaranteed to be logged into AppInsights as
	 * well.
	 */
	private ILogNode _internalLogger;

	/**
	 * Constructor. Creates the subscriber with the given log level.
	 * 
	 * @param level The general log level that should be logged using this subscriber
	 * @param instrumentationKey The key to use for creating the client
	 */
	private ApplicationInsightsLogger(String instrumentationKey)
	{
		super(AI_LOGGER_CATEGORY, LogLevel.INFO);

		// Create the internal logger to have a communication channel in case something fails with the communication to AppInsights
		_internalLogger = Core.getLogger(AI_LOGGER_CATEGORY);

		// We need to add the InProc telemetry channel so that the messages will actually be transmitted to Azure.
		TelemetryConfiguration.getActive().setChannel(new InProcessTelemetryChannel(TelemetryConfiguration.getActive()));

		// The Application Insights client needs to be initialized.
		_internalLogger.info("Creating AppInsights logger with key " + instrumentationKey);

		_client = new TelemetryClient();
		_client.getContext().setInstrumentationKey(instrumentationKey);
	}

	/**
	 * This method will stop the logging to application insights.
	 */
	public void stop()
	{
		_stopped = true;
	}

	/**
	 * Indicates the logger should resume the logging to Application Insights.
	 */
	public void resume()
	{
		_stopped = false;
	}

	/**
	 * This method returns the application context id that can be used.
	 * 
	 * @return The application context id that can be used.
	 */
	public String getApplicationContextId()
	{
		return _staticProperties.get("application");
	}

	/**
	 * This method sets the application context id that can be used.
	 * 
	 * @param applicationContextId The application context id that can be used.
	 */
	public void setApplicationContextId(String applicationContextId)
	{
		if (applicationContextId != null && applicationContextId.length() > 0)
		{
			_staticProperties.put("application", applicationContextId);
		}
	}

	/**
	 * This method will return the instance of the logger that can be used. If you want to specify another log level then INFO you need to call the
	 * setLogLevel before calling this method.
	 * 
	 * @param instrumentationKey The instrumentation key to get the logger for.
	 * @return The instance of the logger
	 */
	public static ApplicationInsightsLogger getInstance(String instrumentationKey)
	{
		ApplicationInsightsLogger retVal = _loggers.get(instrumentationKey);
		if (retVal == null)
		{
			synchronized (ApplicationInsightsLogger.class)
			{
				retVal = _loggers.get(instrumentationKey);
				if (retVal == null)
				{
					retVal = new ApplicationInsightsLogger(instrumentationKey);
					_loggers.put(instrumentationKey, retVal);
				}
			}
		}

		return retVal;
	}

	/**
	 * This method will set the log level of the messages that are to be recorded in Application Insights. Note that this method needs to be called before
	 * the singleton is initialized.
	 * 
	 * @param logLevel The level of the messages to log.
	 * @param instrumentationKey The instrumentation key to set the log level for.
	 */
	public void setLogLevel(LogLevel logLevel)
	{
		if (logLevel != null)
		{
			if (_internalLogger.isTraceEnabled())
			{
				_internalLogger.trace("Setting the tracked log level to " + logLevel);
			}

			setAutoSubscribeLevel(logLevel);
		}
	}

	/**
	 * This method is called when a message is received. It will create a Trace request in application insights. First it will check the category of the
	 * log message. App Insights internal messages will be ignored to avoid loops.
	 * 
	 * @param msg The log message to process.
	 */
	@Override
	public void processMessage(LogMessage msg)
	{
		if (!_stopped && msg.node != null && !AI_LOGGER_CATEGORY.equalsIgnoreCase(msg.node.name()))
		{
			// This is indeed a message that we should process
			if (_internalLogger.isTraceEnabled())
			{
				_internalLogger.trace("Going to send the message " + msg.message + " of category " + msg.node.name()
						+ " to application insights");
			}

			String message = "";
			if (msg.message != null)
			{
				message = msg.message.toString();
			}
			TraceTelemetry tt = new TraceTelemetry(message);
			
			tt.setTimestamp(new Date(msg.timestamp));
			tt.setSeverityLevel(convertLevel(msg.level));

			// Add the rest of the message information into custom properties
			Map<String, String> props = tt.getProperties();
			props.put("mendix-category", msg.node.name());
			if (msg.cause != null)
			{
				props.put("mendix-cause", convertCause(msg.cause));
			}
			if (msg.prefix != null && msg.prefix.trim().length() > 0)
			{
				props.put("mendix-prefix", msg.prefix);
			}

			// Send the telemetry for the trace message
			sendTrace(tt);
		}
	}

	/**
	 * This method will copy the static properties to the request properties
	 * 
	 * @param props The properties where they should be copied to
	 */
	private void copyStaticProperties(Map<String, String> props)
	{
		if (props != null && _staticProperties.size() > 0)
		{
			for (String name : _staticProperties.keySet())
			{
				props.put(name, _staticProperties.get(name));
			}
		}
	}

	/**
	 * This method will send the message to the application insights client
	 * 
	 * @param message The message to send
	 * @param properties Additional properties to be sent to AppInsights
	 */
	public void sendTrace(String message, Map<String, String> properties)
	{
		TraceTelemetry tt = new TraceTelemetry(message);

		if (properties != null)
		{
			// Add the application context
			Map<String, String> props = tt.getProperties();

			for (Entry<String, String> entry : properties.entrySet())
			{
				props.put(entry.getKey(), entry.getValue());
			}
		}

		// Send the message to App Insights
		sendTrace(tt);
	}

	/**
	 * This method will send the message to the application insights client
	 * 
	 * @param tt The Trace telemetry to send
	 */
	public void sendTrace(TraceTelemetry tt)
	{
		if (tt != null)
		{
			// Add the application context
			Map<String, String> props = tt.getProperties();
			copyStaticProperties(props);

			if (_internalLogger.isTraceEnabled())
			{
				_internalLogger.trace(
						"[TRACE] Going to send the trace message " + tt.getMessage() + " to application insights");
			}

			_client.trackTrace(tt);
		}
	}

	/**
	 * This method will send the request telemetry to the application insights client
	 * 
	 * @param rt The request telemetry to send
	 */
	public void sendRequest(RequestTelemetry rt)
	{
		// Add the application context
		Map<String, String> props = rt.getProperties();
		copyStaticProperties(props);

		// Send the message to App Insights
		if (_internalLogger.isTraceEnabled())
		{
			_internalLogger.trace("[REQUEST] Going to send the request telemetry for " + rt.getUrlString()
					+ " to application insights");
		}

		_client.trackRequest(rt);
	}

	/**
	 * This method will send the dependency telemetry to the application insights client
	 * 
	 * @param rdt The dependency telemetry to send
	 */
	public void sendDependency(RemoteDependencyTelemetry rdt)
	{
		// Add the application context
		Map<String, String> props = rdt.getProperties();
		copyStaticProperties(props);

		// Send the message to App Insights
		if (_internalLogger.isTraceEnabled())
		{
			_internalLogger.trace("[DEPENDENCY] Going to send the dependency telemetry for " + rdt.getName() + "/"
					+ rdt.getCommandName() + " to application insights");
		}

		_client.trackDependency(rdt);
	}

	/**
	 * This method will send the metric telemetry to the application insights client
	 * 
	 * @param mt The metic telemetry to send
	 */
	public void sendMetric(MetricTelemetry mt)
	{
		// Add the application context
		Map<String, String> props = mt.getProperties();
		copyStaticProperties(props);

		// Send the message to App Insights
		if (_internalLogger.isTraceEnabled())
		{
			_internalLogger.trace(
					"[METRIC] Going to send the metric telemetry for " + mt.getName() + " to application insights");
		}

		_client.trackMetric(mt);
	}

	/**
	 * This method will send the exception telemetry to application insights.
	 * 
	 * @param et The exception telemetry details
	 */
	public void sendException(ExceptionTelemetry et)
	{
		// Add the application context
		Map<String, String> props = et.getProperties();
		copyStaticProperties(props);

		// Send the message to App Insights
		if (_internalLogger.isTraceEnabled())
		{
			_internalLogger.trace("[EXCEPTION] Going to send the exception telemetry for " + et.getEnvelopName()
					+ " to application insights");
		}

		_client.trackException(et);
	}

	/**
	 * This method will send the event telemetry to application insights.
	 * 
	 * @param et The event telemetry details
	 */
	public void sendEvent(EventTelemetry et)
	{
		// Add the application context
		Map<String, String> props = et.getProperties();
		copyStaticProperties(props);

		// Send the message to App Insights
		if (_internalLogger.isTraceEnabled())
		{
			_internalLogger.trace(
					"[EXCEPTION] Going to send the event telemetry for " + et.getName() + " to application insights");
		}

		_client.trackEvent(et);
	}

	/**
	 * This method will send the page view telemetry to application insights.
	 * 
	 * @param pvt The page view telemetry details
	 */
	public void sendPageView(PageViewTelemetry pvt)
	{
		// Add the application context
		Map<String, String> props = pvt.getProperties();
		copyStaticProperties(props);

		// Send the message to App Insights
		if (_internalLogger.isTraceEnabled())
		{
			_internalLogger.trace("[EXCEPTION] Going to send the page view telemetry for " + pvt.getName()
					+ " to application insights");
		}

		_client.trackPageView(pvt);
	}

	/**
	 * This method will send the trace method to all active loggers
	 * 
	 * @param message The message to send the trace for
	 * @param properties Additional properties to be sent to AppInsights
	 */
	public static void sendTraceToAll(String message, Map<String, String> properties)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendTrace(message, properties);
		}
	}

	/**
	 * This method will send the trace method to all active loggers
	 * 
	 * @param tt The message to send the trace for
	 */
	public static void sendTraceToAll(TraceTelemetry tt)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendTrace(tt);
		}
	}

	/**
	 * This method will send the metric telemetry to all active loggers
	 * 
	 * @param mt The metric telemetry to send the trace for
	 */
	public static void sendMetricToAll(MetricTelemetry mt)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendMetric(mt);
		}
	}
	
	/**
	 * This method will send the event telemetry to all active loggers
	 * 
	 * @param mt The event telemetry to send the trace for
	 */
	public static void sendEventToAll(EventTelemetry mt)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendEvent(mt);
		}
	}
	
	/**
	 * This method will send the exception telemetry to all active loggers
	 * 
	 * @param mt The exception telemetry to send the trace for
	 */
	public static void sendExceptionToAll(ExceptionTelemetry mt)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendException(mt);
		}
	}
	
	/**
	 * This method will send the page view telemetry to all active loggers
	 * 
	 * @param mt The page view telemetry to send the trace for
	 */
	public static void sendPageViewToAll(PageViewTelemetry mt)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendPageView(mt);
		}
	}

	/**
	 * This method will send the dependency telemetry to all active loggers
	 * 
	 * @param rdt The dependency telemetry to send the trace for
	 */
	public static void sendDependencyToAll(RemoteDependencyTelemetry rdt)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendDependency(rdt);
		}
	}

	/**
	 * This method will send the request telemetry to all active loggers
	 * 
	 * @param rt The request telemetry to send the trace for
	 */
	public static void sendRequestToAll(RequestTelemetry rt)
	{
		for (ApplicationInsightsLogger logger : _loggers.values())
		{
			logger.sendRequest(rt);
		}
	}

	/**
	 * This method will convert the exception into a normal string
	 * 
	 * @param cause The exception to convert
	 * @return The string representation of the cause
	 */
	private String convertCause(Throwable cause)
	{
		if (cause == null)
		{
			return null;
		}

		Writer stringWriter = new StringWriter();
		cause.printStackTrace(new PrintWriter(stringWriter));

		return stringWriter.toString();
	}

	/**
	 * This method will convert the log level of Mendix into the Severity category of AppInsights
	 * 
	 * @param level The Mendix log level
	 * @return The Severity level of Application insights
	 */
	private SeverityLevel convertLevel(LogLevel level)
	{
		switch (level)
		{
		case CRITICAL:
			return SeverityLevel.Critical;
		case ERROR:
			return SeverityLevel.Error;
		case INFO:
			return SeverityLevel.Information;
		case WARNING:
			return SeverityLevel.Warning;
		default:
			return SeverityLevel.Verbose;
		}
	}

	/**
	 * This method adds the static properties to the list. These will be sent with each request
	 * 
	 * @param newProperties The properties that should be added to each traces
	 */
	public void setStaticProperties(Map<String, String> newProperties)
	{
		for (String name : newProperties.keySet())
		{
			_staticProperties.put(name, newProperties.get(name));
		}
	}
}
