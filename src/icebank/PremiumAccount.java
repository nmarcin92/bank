package icebank;

import Bank.IncorrectAccountNumber;
import Bank.IncorrectAmount;
import Bank.IncorrectData;
import Bank._PremiumAccountDisp;
import Bank.currency;
import Ice.Current;
import Ice.FloatHolder;
import Ice.IntHolder;

public class PremiumAccount extends _PremiumAccountDisp {

    private static final long serialVersionUID = 405671552082527926L;
    private Account account;

    public PremiumAccount(Account account) {
	this.account = account;
    }

    @Override
    public void calculateLoan(int amount, currency curr, int period,
	    IntHolder totalCost, FloatHolder interestRate, Current __current)
	    throws IncorrectData {
	// TODO Auto-generated method stub

    }

    @Override
    public int getBalance(Current __current) {
	return account.getBalance();
    }

    @Override
    public String getAccountNumber(Current __current) {
	return account.getAccountNumber();
    }

    @Override
    public void transfer(String accountNumber, int amount, Current __current)
	    throws IncorrectAccountNumber, IncorrectAmount {
	account.transfer(accountNumber, amount);
    }

    public AccountInfo getAccountInfo() {
	return account.getAccountInfo();
    }
}
