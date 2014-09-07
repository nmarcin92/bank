package icebank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHelper {

    private static final String ACCOUNT_DIRECTORY = "./acc/";

    public static void saveAccount(AccountInfo account) throws IOException {
	System.out.println("saving file: "
		+ getAccountFilePath(account.getAccountId()));
	ObjectOutputStream os = null;

	try {
	    File file = new File(getAccountFilePath(account.getAccountId()));
	    if (!file.exists()) {
		file.createNewFile();
	    }
	    os = new ObjectOutputStream(new FileOutputStream(file));
	    os.writeObject(account);

	} finally {
	    if (os != null) {
		os.close();
	    }
	}
    }

    public static AccountInfo loadAccount(String accountId)
	    throws ClassNotFoundException, IOException {
	AccountInfo info = null;

	try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(
		new File(getAccountFilePath(accountId))))) {

	    info = (AccountInfo) is.readObject();

	}

	return info;
    }

    public static void deleteAccount(String accountId) {
	new File(getAccountFilePath(accountId)).delete();
    }

    private static String getAccountFilePath(String accountId) {
	return ACCOUNT_DIRECTORY + File.separator + accountId + ".acc";
    }

    public static void updateAccount(AccountInfo accountInfo)
	    throws IOException {
	deleteAccount(accountInfo.getAccountId());
	saveAccount(accountInfo);
    }
}
