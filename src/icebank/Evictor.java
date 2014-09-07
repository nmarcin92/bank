package icebank;

import java.io.IOException;

import Ice.Current;
import Ice.LocalObjectHolder;
import Ice.Object;
import evictor.EvictorBase;

public class Evictor extends EvictorBase {

    private static final int MAX_SIZE = 2;

    public Evictor() {
	super(MAX_SIZE);
    }

    @Override
    public Object add(Current c, LocalObjectHolder cookie) {
	try {
	    cookie.value = FileHelper.loadAccount(c.id.name);
	    return BankManager.getSilverAccounts().get(c.id.name);

	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    System.out.println("File error: " + e.getMessage());
	}

	return null;
    }

    @Override
    public void evict(Object servant, java.lang.Object cookie) {
	try {
	    FileHelper.saveAccount(((Account) servant).getAccountInfo());
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
