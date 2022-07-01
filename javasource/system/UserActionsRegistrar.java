package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(system.actions.VerifyPassword.class);
    registrator.registerUserAction(twogapplicationinsights.actions.InitializeApplicationInsights.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackDependency.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackEvent.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackException.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackMetric.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackPageView.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackRequest.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackTrace.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackTraceExtended.class);
  }
}
