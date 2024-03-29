// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `Bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Bank;

public interface BankManagerPrx extends Ice.ObjectPrx
{
    public void createAccount(PersonalData data, accountType type, Ice.StringHolder accountID)
        throws IncorrectData,
               RequestRejected;

    public void createAccount(PersonalData data, accountType type, Ice.StringHolder accountID, java.util.Map<String, String> __ctx)
        throws IncorrectData,
               RequestRejected;

    public Ice.AsyncResult begin_createAccount(PersonalData data, accountType type);

    public Ice.AsyncResult begin_createAccount(PersonalData data, accountType type, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_createAccount(PersonalData data, accountType type, Ice.Callback __cb);

    public Ice.AsyncResult begin_createAccount(PersonalData data, accountType type, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_createAccount(PersonalData data, accountType type, Callback_BankManager_createAccount __cb);

    public Ice.AsyncResult begin_createAccount(PersonalData data, accountType type, java.util.Map<String, String> __ctx, Callback_BankManager_createAccount __cb);

    public void end_createAccount(Ice.StringHolder accountID, Ice.AsyncResult __result)
        throws IncorrectData,
               RequestRejected;

    public void removeAccount(String accountID)
        throws IncorrectData,
               NoSuchAccount;

    public void removeAccount(String accountID, java.util.Map<String, String> __ctx)
        throws IncorrectData,
               NoSuchAccount;

    public Ice.AsyncResult begin_removeAccount(String accountID);

    public Ice.AsyncResult begin_removeAccount(String accountID, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_removeAccount(String accountID, Ice.Callback __cb);

    public Ice.AsyncResult begin_removeAccount(String accountID, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_removeAccount(String accountID, Callback_BankManager_removeAccount __cb);

    public Ice.AsyncResult begin_removeAccount(String accountID, java.util.Map<String, String> __ctx, Callback_BankManager_removeAccount __cb);

    public void end_removeAccount(Ice.AsyncResult __result)
        throws IncorrectData,
               NoSuchAccount;
}
