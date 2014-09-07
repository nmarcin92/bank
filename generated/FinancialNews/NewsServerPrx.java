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
// Generated from file `FinancialNews.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package FinancialNews;

public interface NewsServerPrx extends Ice.ObjectPrx
{
    public void registerForNews(NewsReceiverPrx subscriber);

    public void registerForNews(NewsReceiverPrx subscriber, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_registerForNews(NewsReceiverPrx subscriber);

    public Ice.AsyncResult begin_registerForNews(NewsReceiverPrx subscriber, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_registerForNews(NewsReceiverPrx subscriber, Ice.Callback __cb);

    public Ice.AsyncResult begin_registerForNews(NewsReceiverPrx subscriber, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_registerForNews(NewsReceiverPrx subscriber, Callback_NewsServer_registerForNews __cb);

    public Ice.AsyncResult begin_registerForNews(NewsReceiverPrx subscriber, java.util.Map<String, String> __ctx, Callback_NewsServer_registerForNews __cb);

    public void end_registerForNews(Ice.AsyncResult __result);
}
