package icebank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Bank.AccountPrx;
import Bank.AccountPrxHelper;
import Bank.BankManagerPrx;
import Bank.BankManagerPrxHelper;
import Bank.PersonalData;
import Bank.accountType;
import Ice.StringHolder;

public class Client {

    private static final String SERVER_ADDRESS = "127.0.0.1";

    public static void main(String[] args) {

	Ice.Communicator ic = null;
	try {

	    // Inicjalizacja ICE
	    ic = Ice.Util.initialize(args);

	    // Ice.PluginManager pluginManager = ic.getPluginManager();
	    // Ice.Plugin plugin = pluginManager.getPlugin("IceSSL");
	    // IceSSL.Plugin sslPlugin = (IceSSL.Plugin) plugin;

	    // Utworzenie proxy na podstawie linii w pliku konfiguracyjnym
	    Ice.ObjectPrx base = ic.propertyToProxy("BankManagerProxy");

	    // Rzutowanie
	    BankManagerPrx bankManager = BankManagerPrxHelper.checkedCast(base);
	    if (bankManager == null) {
		throw new Error("Invalid proxy");
	    }

	    // Wywo³anie zdalnych operacji
	    String line = null;
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    System.in));

	    System.out.print("Enter your firstname:");
	    String name = in.readLine();
	    System.out.print("Enter your surname: ");
	    String surname = in.readLine();
	    System.out.print("Enter your PESEL: ");
	    String pesel = in.readLine();
	    System.out.println("Enter your account type (silver/premium)");
	    String accountTypeString = in.readLine();

	    accountType accType = null;
	    if ("silver".equals(accountTypeString)) {
		accType = accountType.SILVER;
	    } else if ("premium".equals(accountTypeString)) {
		accType = accountType.PREMIUM;
	    } else {
		System.out
			.println("Invalid account type. Choosing default (silver).");
		accType = accountType.SILVER;
	    }

	    StringHolder accountId = new StringHolder();

	    PersonalData personalData = new PersonalData(name, surname, pesel);
	    bankManager.createAccount(personalData, accType, accountId);

	    StringBuilder proxyString = new StringBuilder();

	    if (accountType.SILVER == accType) {
		proxyString.append("silver/");
	    }

	    proxyString.append(accountId.value + ":tcp -p 12001 -h "
		    + SERVER_ADDRESS + ":udp -p 12000 -h " + SERVER_ADDRESS
		    + ":ssl -p 12001 -h " + SERVER_ADDRESS);

	    Ice.ObjectPrx accBase = ic.stringToProxy(proxyString.toString());
	    AccountPrx account = AccountPrxHelper.checkedCast(accBase);

	    while (true) {
		try {
		    System.out.print("-> ");
		    System.out.flush();
		    line = in.readLine();

		    switch (line) {
		    case "exit":
			bankManager.removeAccount(accountId.value);
			System.exit(0);
		    case "number":
			System.out.println(account.getAccountNumber());
			break;
		    case "balance":
			System.out.println(account.getBalance());
			break;
		    case "transfer":
			System.out.print("+ Enter account number: ");
			String accNumber = in.readLine();
			System.out.print("+ Enter amount: ");
			int amount = Integer.parseInt(in.readLine());
			account.transfer(accNumber, amount);
			break;
		    default:
			System.out.println("Unrecognized command");
			break;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }

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
