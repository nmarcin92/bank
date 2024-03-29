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

public interface NewsReceiverPrx extends Ice.ObjectPrx
{
    public void exchangeRate(Currency curr1, Currency curr2, float rate);

    public void exchangeRate(Currency curr1, Currency curr2, float rate, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_exchangeRate(Currency curr1, Currency curr2, float rate);

    public Ice.AsyncResult begin_exchangeRate(Currency curr1, Currency curr2, float rate, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_exchangeRate(Currency curr1, Currency curr2, float rate, Ice.Callback __cb);

    public Ice.AsyncResult begin_exchangeRate(Currency curr1, Currency curr2, float rate, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_exchangeRate(Currency curr1, Currency curr2, float rate, Callback_NewsReceiver_exchangeRate __cb);

    public Ice.AsyncResult begin_exchangeRate(Currency curr1, Currency curr2, float rate, java.util.Map<String, String> __ctx, Callback_NewsReceiver_exchangeRate __cb);

    public void end_exchangeRate(Ice.AsyncResult __result);

    public void interestRate(Currency curr, float rate);

    public void interestRate(Currency curr, float rate, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_interestRate(Currency curr, float rate);

    public Ice.AsyncResult begin_interestRate(Currency curr, float rate, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_interestRate(Currency curr, float rate, Ice.Callback __cb);

    public Ice.AsyncResult begin_interestRate(Currency curr, float rate, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_interestRate(Currency curr, float rate, Callback_NewsReceiver_interestRate __cb);

    public Ice.AsyncResult begin_interestRate(Currency curr, float rate, java.util.Map<String, String> __ctx, Callback_NewsReceiver_interestRate __cb);

    public void end_interestRate(Ice.AsyncResult __result);
}
