package twogapplicationinsights.helpers;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import com.mendix.core.CoreException;
import com.microsoft.applicationinsights.telemetry.Duration;
import com.microsoft.applicationinsights.telemetry.EventTelemetry;
import com.microsoft.applicationinsights.telemetry.ExceptionTelemetry;
import com.microsoft.applicationinsights.telemetry.MetricTelemetry;
import com.microsoft.applicationinsights.telemetry.PageViewTelemetry;
import com.microsoft.applicationinsights.telemetry.RemoteDependencyTelemetry;
import com.microsoft.applicationinsights.telemetry.RequestTelemetry;
import com.microsoft.applicationinsights.telemetry.TraceTelemetry;

import twogapplicationinsights.proxies.MetricData;

/**
 * This class contains utility methods to convert the Mendix data objects into the Microsofts telemetry objects that can be passed on the AppInsights
 * APIs
 * 
 * @author pgussow
 */
public class TelemetryConverterHelper
{
	/**
	 * This method will convert the Remote Dependency Telemetry.
	 * 
	 * @return The converted Remote Dependency Telemetry
	 * @throws CoreException In case of any Mendix data exceptions
	 */
	public static RemoteDependencyTelemetry convertRemoteDependencyTelemetry(
			twogapplicationinsights.proxies.DependencyTelemetry dependency) throws CoreException
	{
		RemoteDependencyTelemetry rdt = new RemoteDependencyTelemetry();

		rdt.setName(dependency.getName());
		rdt.setTimestamp(dependency.getTimestamp());

		rdt.setCommandName(dependency.getCommand());
		rdt.setDuration(new Duration(dependency.getDuration()));

		rdt.setSuccess(dependency.getSuccess());
		rdt.setResultCode(dependency.getResultCode());
		rdt.setTarget(dependency.getTarget());

		DataHelper.addToTelemetry(rdt, dependency.getCustomProperties());
		return rdt;
	}

	/**
	 * This method will convert the Event Telemetry.
	 * 
	 * @return The converted Event Telemetry
	 * @throws CoreException In case of any Mendix data exceptions
	 */
	public static EventTelemetry convertEventTelemetry(twogapplicationinsights.proxies.EventTelemetry event)
			throws CoreException
	{
		EventTelemetry et = new EventTelemetry();

		et.setName(event.getName());
		et.setTimestamp(event.getTimestamp());

		if (event.getSequenceId() != null && event.getSequenceId().trim().length() > 0)
		{
			et.setSequence(event.getSequenceId());
		}

		DataHelper.addToTelemetry(et, event.getCustomProperties());

		return et;
	}

	/**
	 * This method will convert the Exception Telemetry.
	 * 
	 * @return The converted Exception Telemetry
	 * @throws CoreException In case of any Mendix data exceptions
	 */
	public static ExceptionTelemetry convertExceptionTelemetry(
			twogapplicationinsights.proxies.ExceptionTelemetry exception) throws CoreException
	{
		// Since the exception API is based on a throwable we'll create it here
		java.lang.Exception exc = new Exception(exception.getMessage());
		ExceptionTelemetry et = new ExceptionTelemetry(exc);

		et.setTimestamp(exception.getTimestamp());

		if (exception.getSequenceId() != null && exception.getSequenceId().trim().length() > 0)
		{
			et.setSequence(exception.getSequenceId());
		}

		et.setSeverityLevel(DataHelper.convert(exception.getSeverity()));

		// Convert the metrics
		List<MetricData> metrics = exception.getAdditionalMetricData();
		if (metrics != null && metrics.size() > 0)
		{
			ConcurrentMap<String, Double> targetMetrics = et.getMetrics();
			for (MetricData md : metrics)
			{
				if (md.getValue() != null)
				{
					targetMetrics.put(md.getName(), md.getValue().doubleValue());
				}
			}
		}

		DataHelper.addToTelemetry(et, exception.getCustomProperties());
		return et;
	}

	/**
	 * This method will convert the Metric Telemetry.
	 * 
	 * @return The converted Metric Telemetry
	 * @throws CoreException In case of any Mendix data exceptions
	 */
	public static MetricTelemetry convertMetricTelemetry(twogapplicationinsights.proxies.MetricTelemetry metric)
			throws CoreException
	{
		MetricTelemetry mt = new MetricTelemetry();

		mt.setName(metric.getName());
		mt.setTimestamp(metric.getTimestamp());

		if (metric.getMin() != null && (new BigDecimal(0)).compareTo(metric.getMin()) > 0)
		{
			mt.setMin(metric.getMin().doubleValue());
		}

		if (metric.getMax() != null && (new BigDecimal(0)).compareTo(metric.getMax()) > 0)
		{
			mt.setMax(metric.getMax().doubleValue());
		}

		if (metric.getCount() != null)
		{
			mt.setCount(metric.getCount());
		}

		if (metric.getStandardDeviation() != null)
		{
			mt.setStandardDeviation(metric.getStandardDeviation().doubleValue());
		}

		DataHelper.addToTelemetry(mt, metric.getCustomProperties());
		return mt;
	}

	/**
	 * This method will convert the Request Telemetry.
	 * 
	 * @return The converted Request Telemetry
	 * @throws CoreException In case of any Mendix data exceptions
	 * @throws MalformedURLException In case the UTRl is not a valid URL string
	 */
	public static RequestTelemetry convertRequestTelemetry(twogapplicationinsights.proxies.RequestTelemetry request)
			throws MalformedURLException, CoreException
	{
		RequestTelemetry rt = new RequestTelemetry();

		rt.setName(request.getName());
		rt.setUrl(request.getUrl());
		rt.setTimestamp(request.getTimestamp());

		rt.setDuration(new Duration(request.getDuration()));
		rt.setResponseCode(request.getResponseCode());

		rt.setSuccess(request.getSuccess());
		rt.setSource(request.getSource());

		rt.setSamplingPercentage(request.getSamplingPercentage().doubleValue());

		DataHelper.addToTelemetry(rt, request.getCustomProperties());
		return rt;
	}

	/**
	 * This method will convert the Trace Telemetry.
	 * 
	 * @return The converted Trace Telemetry
	 * @throws CoreException In case of any Mendix data exceptions
	 */
	public static TraceTelemetry convertTraceTelemetry(twogapplicationinsights.proxies.TraceTelemetry trace)
			throws CoreException
	{
		TraceTelemetry tt = new TraceTelemetry();

		tt.setMessage(trace.getMessage());
		tt.setTimestamp(trace.getTimestamp());

		tt.setSeverityLevel(DataHelper.convert(trace.getLevel()));

		DataHelper.addToTelemetry(tt, trace.getCustomProperties());
		return tt;
	}

	/**
	 * This method will convert the Page View Telemetry.
	 * 
	 * @return The converted Page View Telemetry
	 * @throws CoreException In case of any Mendix data exceptions
	 */
	public static PageViewTelemetry convertPageViewTelemetry(twogapplicationinsights.proxies.PageViewTelemetry pageView)
			throws CoreException
	{
		PageViewTelemetry pvt = new PageViewTelemetry();

		pvt.setName(pageView.getName());
		pvt.setTimestamp(pageView.getTimestamp());

		if (pageView.getSequenceId() != null && pageView.getSequenceId().trim().length() > 0)
		{
			pvt.setSequence(pageView.getSequenceId());
		}

		if (pageView.getUrl() != null && pageView.getUrl().trim().length() > 0)
		{
			pvt.setSequence(pageView.getUrl());
		}

		pvt.setDuration(pageView.getDuration());

		// Convert the metrics
		List<MetricData> metrics = pageView.getAdditionalMetricData();
		if (metrics != null && metrics.size() > 0)
		{
			ConcurrentMap<String, Double> targetMetrics = pvt.getMetrics();
			for (MetricData md : metrics)
			{
				if (md.getValue() != null)
				{
					targetMetrics.put(md.getName(), md.getValue().doubleValue());
				}
			}
		}

		DataHelper.addToTelemetry(pvt, pageView.getCustomProperties());
		return pvt;
	}
}
