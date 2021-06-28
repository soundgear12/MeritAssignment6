package com.meritamerica.assignment6.assignment6.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends BankAccount {

    public SavingsAccount(double openingBalance) { super(openingBalance, 0.01, new Date()); }

    private SavingsAccount(long accountNumber, double balance, double interestRate, Date date) {
        super(accountNumber, balance, interestRate, date);
    }

    public SavingsAccount() {
    	super();
    }
}