package com.meritamerica.assignment6.assignment6.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class CheckingAccount extends BankAccount {

    public CheckingAccount(double openingBalance) { super(openingBalance, 0.0001, new Date()); }

    private CheckingAccount(long accountNumber, double balance, double interestRate, Date date) {
        super(accountNumber, balance, interestRate, date);
    }
    
    public CheckingAccount() {
    	super();
    }

   
}