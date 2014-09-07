package icebank;

import java.io.Serializable;

import Bank.PersonalData;
import Bank.accountType;

public class AccountInfo implements Serializable {

    private static final long serialVersionUID = -6935042094987557850L;

    private String accountId;
    private String accountNumber;
    private PersonalData personalData;
    private int accountBalance;
    private accountType type;

    public AccountInfo(String accountId, String accountNumber,
	    PersonalData personalData, int accountBalance, accountType type) {
	this.accountId = accountId;
	this.accountNumber = accountNumber;
	this.personalData = personalData;
	this.accountBalance = accountBalance;
	this.type = type;
    }

    public String getAccountId() {
	return accountId;
    }

    public void setAccountId(String accountId) {
	this.accountId = accountId;
    }

    public String getAccountNumber() {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
    }

    public PersonalData getPersonalData() {
	return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
	this.personalData = personalData;
    }

    public int getAccountBalance() {
	return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
	this.accountBalance = accountBalance;
    }

    public accountType getType() {
	return type;
    }

    public void setType(accountType type) {
	this.type = type;
    }
}
