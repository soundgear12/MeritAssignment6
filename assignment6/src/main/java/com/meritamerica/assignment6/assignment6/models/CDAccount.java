package com.meritamerica.assignment6.assignment6.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
public class CDAccount extends BankAccount {

    private CDOfferings cdOffering;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offerings_id")
    private CDOfferings cdoffering;
    
    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private AccountHolder accountHolder;    
    */
    
    public CDAccount(CDOfferings offering, double balance) {
        super(balance, offering.getInterestRate(), new Date());
        this.cdOffering = offering;
    }

    private CDAccount(long accountNumber, double balance, double interestRate, int term, Date date) {
        super(accountNumber, balance, interestRate, date);
        this.cdOffering = new CDOfferings(term, interestRate);
    }
    
    public CDAccount() {
    	super();

    }
    

    public CDOfferings getCdoffering() {
		return cdoffering;
	}

	public void setCdoffering(CDOfferings cdoffering) {
		this.cdoffering = cdoffering;
	}


	public CDOfferings getCdOffering() {
		return cdOffering;
	}

	public void setCdOffering(CDOfferings offering) {
		this.cdOffering = offering;
	}

	public int getTerm() { return this.cdOffering.getTerm(); }

    

   // public double futureValue(){ return super.futureValue(this.cdOffering.getTerm()); }

    

    @Override
    public boolean deposit(double amount) { return false; }

    @Override
    public boolean withdraw(double amount) { return false; }


}