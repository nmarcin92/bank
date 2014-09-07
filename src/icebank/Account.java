package icebank;

import Bank.IncorrectAccountNumber;
import Bank.IncorrectAmount;
import Bank._AccountDisp;
import Ice.Current;

public class Account extends _AccountDisp {

    private static final long serialVersionUID = 4567743766584232841L;

    private AccountInfo accountInfo;

    public Account(AccountInfo info) {
	this.accountInfo = info;
    }

    public AccountInfo getAccountInfo() {
	return accountInfo;
    }

    @Override
    public int getBalance(Current __current) {
	return accountInfo.getAccountBalance();
    }

    @Override
    public String getAccountNumber(Current __current) {
	return accountInfo.getAccountNumber();
    }

    @Override
    public void transfer(String accountNumber, int amount, Current __current)
	    throws IncorrectAccountNumber, IncorrectAmount {
	BankManager.transfer(accountInfo.getAccountNumber(), accountNumber,
		amount);

    }

}
