package com.meritamerica.assignment6.assignment6.models;

import java.text.ParseException;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BankAccount {

    // region instance variables

    private Date accountOpenedOn;
    
    @Id
    @Column(name="accountNumber")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long accountNumber;
    private double interestRate;
    private double balance;
 
    // endregion
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountNumber", referencedColumnName = "id")
    private AccountHolder accountHolder;
    
    public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	// region constructors
    BankAccount(double balance, double interestRate){
        this(MeritBank.getNextAccountNumber(), balance, interestRate, new Date());
    }

    BankAccount(double balance, double interestRate, Date accountOpenedOn) {
        this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn);
    }

    protected BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
    	this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
        this.accountOpenedOn = accountOpenedOn;
    }
    // endregion
    
    BankAccount() {
    	this.accountNumber = MeritBank.getNextAccountNumber();
        this.balance = 0;
        this.interestRate = 0;
        this.accountOpenedOn = new Date();
    }


	// region getters/setters
    
    
    public void setAccountOpenedOn(Date accountOpenedOn) {
		this.accountOpenedOn = accountOpenedOn;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() { return this.accountNumber; }

    public double getBalance() { return this.balance; }

    public double getInterestRate() { return this.interestRate; }

    public Date getOpenedOn() { return this.accountOpenedOn; }

    public boolean withdraw(double amount){
        if (this.balance - amount < 0) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }

    public boolean deposit (double amount){
        if (amount < 0) {
            return false;
        } else {
            this.balance += amount;
            return true;
        }
    }

	public double futureValue(int term) {
		double factor = 1 + interestRate;
		return Math.pow(factor, term) * balance;
	}



 
    // endregion

    // region read/write from string
   

    

   
}