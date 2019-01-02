// This file was generated by Mendix Modeler 7.8.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package demo.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the Demo module
	public static twogapplicationinsights.proxies.DependencyTelemetry dS_NewDependencyMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "Demo.DS_NewDependencyMessage", params);
			return result == null ? null : twogapplicationinsights.proxies.DependencyTelemetry.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static twogapplicationinsights.proxies.EventTelemetry dS_NewEventMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "Demo.DS_NewEventMessage", params);
			return result == null ? null : twogapplicationinsights.proxies.EventTelemetry.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static twogapplicationinsights.proxies.ExceptionTelemetry dS_NewExceptionMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "Demo.DS_NewExceptionMessage", params);
			return result == null ? null : twogapplicationinsights.proxies.ExceptionTelemetry.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static twogapplicationinsights.proxies.MetricTelemetry dS_NewMetricMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "Demo.DS_NewMetricMessage", params);
			return result == null ? null : twogapplicationinsights.proxies.MetricTelemetry.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static twogapplicationinsights.proxies.PageViewTelemetry dS_NewPageViewMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "Demo.DS_NewPageViewMessage", params);
			return result == null ? null : twogapplicationinsights.proxies.PageViewTelemetry.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static twogapplicationinsights.proxies.RequestTelemetry dS_NewRequestMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "Demo.DS_NewRequestMessage", params);
			return result == null ? null : twogapplicationinsights.proxies.RequestTelemetry.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static twogapplicationinsights.proxies.TraceTelemetry dS_NewTraceMessage(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			IMendixObject result = (IMendixObject)Core.execute(context, "Demo.DS_NewTraceMessage", params);
			return result == null ? null : twogapplicationinsights.proxies.TraceTelemetry.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendDependencyMessage(IContext context, twogapplicationinsights.proxies.DependencyTelemetry _dependencyTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("DependencyTelemetry", _dependencyTelemetry == null ? null : _dependencyTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendDependencyMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendEventMessage(IContext context, twogapplicationinsights.proxies.EventTelemetry _eventTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("EventTelemetry", _eventTelemetry == null ? null : _eventTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendEventMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendExceptionMessage(IContext context, twogapplicationinsights.proxies.ExceptionTelemetry _exceptionTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("ExceptionTelemetry", _exceptionTelemetry == null ? null : _exceptionTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendExceptionMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendMetricMessage(IContext context, twogapplicationinsights.proxies.MetricTelemetry _metricTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("MetricTelemetry", _metricTelemetry == null ? null : _metricTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendMetricMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendPageViewMessage(IContext context, twogapplicationinsights.proxies.PageViewTelemetry _pageViewTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("PageViewTelemetry", _pageViewTelemetry == null ? null : _pageViewTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendPageViewMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendRequestMessage(IContext context, twogapplicationinsights.proxies.RequestTelemetry _requestTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("RequestTelemetry", _requestTelemetry == null ? null : _requestTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendRequestMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendTraceExtendedMessage(IContext context, twogapplicationinsights.proxies.TraceTelemetry _traceTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("TraceTelemetry", _traceTelemetry == null ? null : _traceTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendTraceExtendedMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SendTraceMessage(IContext context, twogapplicationinsights.proxies.TraceTelemetry _traceTelemetry)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("TraceTelemetry", _traceTelemetry == null ? null : _traceTelemetry.getMendixObject());
			Core.execute(context, "Demo.IVK_SendTraceMessage", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sUB_AfterStartup(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			return (java.lang.Boolean)Core.execute(context, "Demo.SUB_AfterStartup", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.util.List<twogapplicationinsights.proxies.MetricData> sUB_CreateAditionalMetricData(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			java.util.List<IMendixObject> objs = Core.execute(context, "Demo.SUB_CreateAditionalMetricData", params);
			java.util.List<twogapplicationinsights.proxies.MetricData> result = null;
			if (objs != null)
			{
				result = new java.util.ArrayList<twogapplicationinsights.proxies.MetricData>();
				for (IMendixObject obj : objs)
					result.add(twogapplicationinsights.proxies.MetricData.initialize(context, obj));
			}
			return result;
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static java.util.List<twogapplicationinsights.proxies.AppInsightProperty> sUB_CreateAditionalProperty(IContext context)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			java.util.List<IMendixObject> objs = Core.execute(context, "Demo.SUB_CreateAditionalProperty", params);
			java.util.List<twogapplicationinsights.proxies.AppInsightProperty> result = null;
			if (objs != null)
			{
				result = new java.util.ArrayList<twogapplicationinsights.proxies.AppInsightProperty>();
				for (IMendixObject obj : objs)
					result.add(twogapplicationinsights.proxies.AppInsightProperty.initialize(context, obj));
			}
			return result;
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}