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
// Generated from file `CertSigner.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SR;

public class IncorrectName extends Ice.UserException
{
    public IncorrectName()
    {
    }

    public IncorrectName(Throwable __cause)
    {
        super(__cause);
    }

    public String
    ice_name()
    {
        return "SR::IncorrectName";
    }

    protected void
    __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice("::SR::IncorrectName", -1, true);
        __os.endWriteSlice();
    }

    protected void
    __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = -644492872L;
}
