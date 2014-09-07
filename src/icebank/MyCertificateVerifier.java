package icebank;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import IceSSL.CertificateVerifier;
import IceSSL.NativeConnectionInfo;

public class MyCertificateVerifier implements CertificateVerifier {

    private PublicKey pk;

    public MyCertificateVerifier() {
	try {
	    InputStream inStream = new FileInputStream("sr2014ca.crt");
	    CertificateFactory cf = CertificateFactory.getInstance("X.509");
	    X509Certificate cert = (X509Certificate) cf
		    .generateCertificate(inStream);
	    pk = cert.getPublicKey();
	    inStream.close();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (CertificateException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public boolean verify(NativeConnectionInfo info) {
	Certificate cert = info.nativeCerts[0];
	if (cert != null) {
	    X509Certificate x509Cert = (X509Certificate) cert;
	    if (x509Cert != null) {
		try {
		    x509Cert.verify(pk);
		    return true;
		} catch (CertificateEncodingException e) {
		    e.printStackTrace();
		} catch (InvalidKeyException e) {
		    e.printStackTrace();
		} catch (CertificateException e) {
		    e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
		    e.printStackTrace();
		} catch (NoSuchProviderException e) {
		    e.printStackTrace();
		} catch (SignatureException e) {
		    e.printStackTrace();
		}
	    }
	}
	return false;
    }
}
