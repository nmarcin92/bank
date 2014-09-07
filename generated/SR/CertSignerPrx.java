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

public interface CertSignerPrx extends Ice.ObjectPrx
{
    public byte[] signCSR(String name, String surname, byte[] csrFile)
        throws DataTooLong,
               IncorrectCSRFile;

    public byte[] signCSR(String name, String surname, byte[] csrFile, java.util.Map<String, String> __ctx)
        throws DataTooLong,
               IncorrectCSRFile;

    public Ice.AsyncResult begin_signCSR(String name, String surname, byte[] csrFile);

    public Ice.AsyncResult begin_signCSR(String name, String surname, byte[] csrFile, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_signCSR(String name, String surname, byte[] csrFile, Ice.Callback __cb);

    public Ice.AsyncResult begin_signCSR(String name, String surname, byte[] csrFile, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_signCSR(String name, String surname, byte[] csrFile, Callback_CertSigner_signCSR __cb);

    public Ice.AsyncResult begin_signCSR(String name, String surname, byte[] csrFile, java.util.Map<String, String> __ctx, Callback_CertSigner_signCSR __cb);

    public byte[] end_signCSR(Ice.AsyncResult __result)
        throws DataTooLong,
               IncorrectCSRFile;
}
