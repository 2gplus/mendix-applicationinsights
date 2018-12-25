package system;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.mendix.core.actionmanagement.IActionRegistrator;

@Component(immediate = true)
public class UserActionsRegistrar
{
  @Reference
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(system.actions.VerifyPassword.class);
    registrator.registerUserAction(twogapplicationinsights.actions.InitializeApplicationInsights.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackDependency.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackMetric.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackRequest.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackTrace.class);
    registrator.registerUserAction(twogapplicationinsights.actions.TrackTraceExtended.class);
  }
}
