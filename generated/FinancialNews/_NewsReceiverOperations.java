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

public interface _NewsReceiverOperations
{
    void exchangeRate(Currency curr1, Currency curr2, float rate, Ice.Current __current);

    void interestRate(Currency curr, float rate, Ice.Current __current);
}
