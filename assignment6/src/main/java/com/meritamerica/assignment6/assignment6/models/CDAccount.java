package com.meritamerica.assignment6.assignment6.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "accHolder", "offering" })
public class CDAccount extends BankAccount  implements Serializable {

	@NotNull
	@Positive
	private int term;

  
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offerings_id")
    private CDOfferings offering;
    
   /* 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    
    private AccountHolder accHolder;    
    
    
    /*
    public AccountHolder getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(AccountHolder accHolder) {
		this.accHolder = accHolder;
	}
	*/
	
	CDAccount(CDOfferings offering, double balance) {
        super(balance, offering.getInterestRate(), new Date());
        this.offering = offering;
    }

    CDAccount(int accountNumber, double balance, double interestRate, int term, Date date) {
        super(accountNumber, balance, interestRate, date);
        this.offering = new CDOfferings(term, interestRate);
    }
    
    public CDAccount() {
    	super();
    	this.offering = new CDOfferings(term, interestRate);

    }
    

    public CDOfferings getCdoffering() {
		return offering;
	}

	public void setCdoffering(CDOfferings cdoffering) {
		this.offering = cdoffering;
	}


	public CDOfferings getCdOffering() {
		return offering;
	}

	public void setCdOffering(CDOfferings offering) {
		this.offering = offering;
	}

	public int getTerm() { return offering.getTerm(); }
	
	@Override
	public void setInterestRate(double interestRate) {
		super.setInterestRate(interestRate);
		offering.setInterestRate(interestRate);
	}
	
	public double getInterestRate() {
		return offering.getInterestRate();
	}

    

   // public double futureValue(){ return super.futureValue(this.cdOffering.getTerm()); }

    

    public void setTerm(int terms) {
		this.term = terms;
		offering.setTerm(terms);
	}

	@Override
    public boolean deposit(double amount) { return false; }

    @Override
    public boolean withdraw(double amount) { return false; }


}