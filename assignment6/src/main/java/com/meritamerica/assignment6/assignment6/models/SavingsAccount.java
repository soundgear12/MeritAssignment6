package com.meritamerica.assignment6.assignment6.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SavingsAccount extends BankAccount implements Serializable {

	/*
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	*/


	public SavingsAccount(double openingBalance) { super(openingBalance, 0.01, new Date()); }

    SavingsAccount(int accountNumber, double balance, double interestRate, Date date) {
        super(accountNumber, balance, interestRate, date);
    }

    public SavingsAccount() {
    	super();
    }
}