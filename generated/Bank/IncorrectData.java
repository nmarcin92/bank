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

public class IncorrectData extends Ice.UserException
{
    public IncorrectData()
    {
    }

    public IncorrectData(Throwable __cause)
    {
        super(__cause);
    }

    public IncorrectData(String reason)
    {
        this.reason = reason;
    }

    public IncorrectData(String reason, Throwable __cause)
    {
        super(__cause);
        this.reason = reason;
    }

    public String
    ice_name()
    {
        return "Bank::IncorrectData";
    }

    public String reason;

    protected void
    __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice("::Bank::IncorrectData", -1, true);
        __os.writeString(reason);
        __os.endWriteSlice();
    }

    protected void
    __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        reason = __is.readString();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 1617389767L;
}
