package icebank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import SR.CertSignerPrx;
import SR.CertSignerPrxHelper;

public class Signer {

    public static void main(String[] args) {

	Ice.Communicator ic = null;
	try {

	    // Inicjalizacja ICE
	    ic = Ice.Util.initialize(args);

	    // Ice.PluginManager pluginManager = ic.getPluginManager();
	    // Ice.Plugin plugin = pluginManager.getPlugin("IceSSL");
	    // IceSSL.Plugin sslPlugin = (IceSSL.Plugin) plugin;

	    // Utworzenie proxy na podstawie linii w pliku konfiguracyjnym
	    Ice.ObjectPrx base = ic.propertyToProxy("SR.proxy");

	    // Rzutowanie
	    CertSignerPrx certSigner = CertSignerPrxHelper.checkedCast(base);
	    if (certSigner == null) {
		throw new Error("Invalid proxy");
	    }

	    // Wywo³anie zdalnych operacji
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    System.in));

	    System.out.print("Enter csr file path:");
	    String path = in.readLine();

	    byte[] csrFileContent = new byte[2047];
	    FileInputStream csrFileIn = new FileInputStream(new File(path));
	    FileOutputStream crtFileOut = new FileOutputStream(new File(
		    path.replace(".csr", "crt")));

	    csrFileIn.read(csrFileContent);
	    byte[] crtFileContent = certSigner.signCSR("Marcin", "Nowak",
		    csrFileContent);
	    crtFileOut.write(crtFileContent);

	} catch (FileNotFoundException e) {
	    System.out.println("File doesn't exist");
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (ic != null) {
		try {
		    ic.destroy();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}

    }
}
