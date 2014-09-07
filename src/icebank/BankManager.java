package icebank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import Bank.IncorrectAccountNumber;
import Bank.IncorrectAmount;
import Bank.IncorrectData;
import Bank.NoSuchAccount;
import Bank.PersonalData;
import Bank.RequestRejected;
import Bank._BankManagerDisp;
import Bank.accountType;
import Ice.Current;
import Ice.Identity;
import Ice.StringHolder;

public class BankManager extends _BankManagerDisp {

    private static final long serialVersionUID = -7452305602000472322L;
    private static final Map<String, Account> SILVER_ACCOUNTS;
    private static final Map<String, PremiumAccount> PREMIUM_ACCOUNTS;
    private static int accountNumber = 1;

    private final Ice.ObjectAdapter adapter;

    static {
	SILVER_ACCOUNTS = new HashMap<String, Account>();
	PREMIUM_ACCOUNTS = new HashMap<String, PremiumAccount>();
    }

    public static Map<String, Account> getSilverAccounts() {
	return SILVER_ACCOUNTS;
    }

    public static Map<String, PremiumAccount> getPremiumAccounts() {
	return PREMIUM_ACCOUNTS;
    }

    public BankManager(Ice.ObjectAdapter adapter) {
	this.adapter = adapter;
    }

    public synchronized static void transfer(String srcAccountNr,
	    String destAccountNr, int amount) throws IncorrectAccountNumber,
	    IncorrectAmount {
	AccountInfo srcAccount = findAccount(srcAccountNr);
	AccountInfo destAccount = findAccount(destAccountNr);
	if (srcAccount == null || destAccount == null) {
	    throw new IncorrectAccountNumber();
	}

	if (amount > srcAccount.getAccountBalance()) {
	    throw new IncorrectAmount();
	}

	srcAccount.setAccountBalance(srcAccount.getAccountBalance() - amount);
	destAccount.setAccountBalance(destAccount.getAccountBalance() + amount);
	try {
	    FileHelper.updateAccount(srcAccount);
	    FileHelper.updateAccount(destAccount);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public synchronized void createAccount(PersonalData data, accountType type,
	    StringHolder accountID, Current __current) throws IncorrectData,
	    RequestRejected {

	Identity id = new Identity();
	id.name = UUID.randomUUID().toString();
	accountID.value = id.name;

	Account acc = new Account(new AccountInfo(id.name,
		Integer.toString(accountNumber++), data, 10000, type));
	if (accountType.SILVER == type) {
	    id.category = "silver";
	    SILVER_ACCOUNTS.put(accountID.value, acc);
	} else {
	    PremiumAccount premiumAccount = new PremiumAccount(acc);
	    PREMIUM_ACCOUNTS.put(accountID.value, premiumAccount);
	    adapter.add(premiumAccount, id);
	}

	try {
	    FileHelper.saveAccount(acc.getAccountInfo());
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void removeAccount(String accountID, Current __current)
	    throws IncorrectData, NoSuchAccount {
	if (SILVER_ACCOUNTS.containsKey(accountID)) {
	    SILVER_ACCOUNTS.remove(accountID);
	} else if (PREMIUM_ACCOUNTS.containsKey(accountID)) {
	    PREMIUM_ACCOUNTS.remove(accountID);
	} else {
	    throw new NoSuchAccount();
	}
	FileHelper.deleteAccount(accountID);
    }

    private static AccountInfo findAccount(String accountNumber) {
	for (Account acc : SILVER_ACCOUNTS.values()) {
	    if (accountNumber.equals(acc.getAccountNumber())) {
		return acc.getAccountInfo();
	    }
	}
	for (PremiumAccount acc : PREMIUM_ACCOUNTS.values()) {
	    if (accountNumber.equals(acc.getAccountNumber())) {
		return acc.getAccountInfo();
	    }
	}
	return null;
    }
}
