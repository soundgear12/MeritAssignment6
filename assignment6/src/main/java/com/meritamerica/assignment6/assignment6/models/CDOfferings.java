package com.meritamerica.assignment6.assignment6.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CDOffering", catalog = "MeritAmerica")
public class CDOfferings {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    private int term;
    private double interestRate;

    public CDOfferings(int term, double interestRate) {
        this.term = term;
        this.interestRate = interestRate;
    }
    
    public CDOfferings() {
		/*
    	this.id = id;
		this.term = 0;
		this.interestRate = 0;
		*/
	}
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdOffering")
    private  List<CDAccount> cdAccounts;

    public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

	public int getTerm() { return this.term; }

    public double getInterestRate() { return this.interestRate; }
    
    public int getId() {
		return id;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setId(int id) {
		this.id = id;
	}

   

    public String writeToString() { return this.term + "," + this.interestRate; }


}