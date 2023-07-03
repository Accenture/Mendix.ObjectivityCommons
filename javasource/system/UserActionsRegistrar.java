package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(objectivitycommons.actions.Clone.class);
    registrator.registerUserAction(objectivitycommons.actions.commitInSeparateDatabaseTransactionWithoutEvent.class);
    registrator.registerUserAction(objectivitycommons.actions.getBySQL.class);
    registrator.registerUserAction(objectivitycommons.actions.GetTypeAsString.class);
    registrator.registerUserAction(objectivitycommons.actions.ListCreateSimple.class);
    registrator.registerUserAction(objectivitycommons.actions.ListGetByIndex.class);
    registrator.registerUserAction(objectivitycommons.actions.RetrieveEnhanced.class);
    registrator.registerUserAction(objectivitycommons.actions.RetrieveFromList.class);
    registrator.registerUserAction(objectivitycommons.actions.runSQL.class);
    registrator.registerUserAction(objectivitycommons.actions.StringBetween.class);
    registrator.registerUserAction(objectivitycommons.actions.StringJoin.class);
    registrator.registerUserAction(objectivitycommons.actions.StringReplaceRegex.class);
    registrator.registerUserAction(objectivitycommons.actions.StringSplit.class);
    registrator.registerUserAction(signinmicroflow.actions.OverwriteDefaultLoginAction.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
