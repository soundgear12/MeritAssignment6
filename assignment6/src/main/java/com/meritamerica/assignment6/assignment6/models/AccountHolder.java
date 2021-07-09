package com.meritamerica.assignment6.assignment6.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "AccountHolders", catalog = "MeritBank")
public class AccountHolder {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
    
	
	@OneToMany(fetch = FetchType.LAZY)
    private List<CheckingAccount> checkingAccounts;
	 
	@OneToMany(fetch = FetchType.LAZY)
    private  List<SavingsAccount> savingsAccounts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="accHolder")
    private  List<CDAccount> cdAccounts;
	
	
    private CDOfferings[] cdOfferings;
	
	@OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private AccountHoldersContactDetails accountHolderContactDetails;
	
    public AccountHoldersContactDetails getAccountHolderContactDetails() {
		return accountHolderContactDetails;
	}



	public void setAccountHolderContactDetails(AccountHoldersContactDetails accountHolderContactDetails) {
		this.accountHolderContactDetails = accountHolderContactDetails;
	}
	int numberOfCheckingAccounts = 0;
    
	int numberOfSavingsAccounts = 0;
	
	int numberOfCDAccounts = 0;

	double combinedBalance = 0;
    private final double MAX_NEW_ACCOUNT_BALANCE = 250000.0;
    //endregion

    
   
  
    
    //region Constructors
    public AccountHolder() {
        
        this.checkingAccounts = new ArrayList <CheckingAccount>();
		this.savingsAccounts =new ArrayList <SavingsAccount>();
		this.cdAccounts = new ArrayList <CDAccount>();
		this.combinedBalance = 0;
    }
    //endregion
    
  

    //region Basic Info Getters/Setters
    
    public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

    //endregion



	public int getNumberOfCheckingAccounts() {
		return this.checkingAccounts.size();
	}



	public void setNumberOfCheckingAccounts(int numberOfCheckingAccounts) {
		this.numberOfCheckingAccounts = numberOfCheckingAccounts;
	}



	public double getCheckingBalance() {
		double chkBal = 0;
		for (int i = 0; i < checkingAccounts.size(); i++) {
			
			chkBal += checkingAccounts.get(i).getBalance();
		}
		return chkBal;
	}







	public int getNumberOfSavingsAccounts() {
		return this.savingsAccounts.size();
	}



	public void setNumberOfSavingsAccounts(int numberOfSavingsAccounts) {
		this.numberOfSavingsAccounts = numberOfSavingsAccounts;
	}



	public double getSavingsBalance() {
		double svgBal = 0;
		for (int i = 0; i < savingsAccounts.size(); i++) {
			
			svgBal += savingsAccounts.get(i).getBalance();
		}
		return svgBal;
	}







	public int getNumberOfCDAccounts() {
		return this.cdAccounts.size();
	}



	public void setNumberOfCDAccounts(int numberOfCDAccounts) {
		this.numberOfCDAccounts = numberOfCDAccounts;
	}



	public double getCdBalance() {
		double cdaBal = 0;
		for (int i = 0; i < cdAccounts.size(); i++) {
			
			cdaBal += cdAccounts.get(i).getBalance();
		}
		return cdaBal;
	}





	public double getCombinedBalance() {
		return combinedBalance;
	}



	public void setCombinedBalance(double combinedBalance) {
		this.combinedBalance = combinedBalance;
	}



	public List<CheckingAccount> getCheckingAccounts() {
		return this.checkingAccounts;
	}



	public List<SavingsAccount> getSavingsAccounts() {
		return this.savingsAccounts;
	}
	
	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}



	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}
	
	public CDOfferings[] getCDOfferings() {
		return cdOfferings;
	}

    
    //region CheckingAccount Methods
	public CheckingAccount addCheckingAccount(double openingBalance) {
		if (openingBalance < 0.0){
			return null;
		}
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		CheckingAccount ca = new CheckingAccount(openingBalance);
		
		return this.addCheckingAccount(ca); 
	
	}
	
	public  CheckingAccount addCheckingAccount(CheckingAccount chk) {
			this.checkingAccounts.add(chk);
			return chk;   
    }
	

	

	
	
	
    
	//region SavingsAccount Methods
	
	public SavingsAccount addSavingsAccount(double openingBalance) {
		if (openingBalance<0.0){
			return null;
		}
		
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		
		SavingsAccount sa = new SavingsAccount(openingBalance);
		return this.addSavingsAccount(sa);
	}
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccounts.add(savingsAccount);  
		return savingsAccount;
	}
    //region CDAccount Methods



	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}
    
	
	

    
    
    
}