package com.meritamerica.assignment6.assignment6.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;


import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="checkingAccount")
//@JsonIgnoreProperties(value = { "accHolder" })
public class CheckingAccount extends BankAccount implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public CheckingAccount(double openingBalance) { super(openingBalance, 0.0001, new Date()); }

    public CheckingAccount(int accountNumber, double balance, double interestRate, Date date) {
        super(accountNumber, balance, interestRate, date);
    }
    
    public CheckingAccount() {
    	super();
    }

   
}