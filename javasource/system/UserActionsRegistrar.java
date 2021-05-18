package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(objectivitycommons.actions.CreateObjectList.class);
    registrator.registerUserAction(objectivitycommons.actions.GetObjectsFromList.class);
    registrator.registerUserAction(objectivitycommons.actions.GetTypeAsString.class);
    registrator.registerUserAction(objectivitycommons.actions.RetrieveEnhanced.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
