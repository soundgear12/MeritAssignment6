package com.meritamerica.assignment6.assignment6.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "AccountHolder", catalog = "MeritBank")
public class AccountHolder {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
    //region InstanceVariables
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "accountHolder")
    private CheckingAccount[] checkingAccounts;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "accountHolder")
    private  SavingsAccount[] savingsAccounts;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "accountHolder")
    private  List<CDAccount> cdAccounts;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "accountHolder")
    private CDOfferings[] cdOfferings;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "accountHolder")
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
    	this.id = id;
        
        this.checkingAccounts = new CheckingAccount[0];
		this.savingsAccounts = new SavingsAccount[0];
		this.cdAccounts = new ArrayList <CDAccount>();
		this.combinedBalance = 0;
    }
    //endregion
    
  

    //region Basic Info Getters/Setters
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

    //endregion



	public int getNumberOfCheckingAccounts() {
		return this.checkingAccounts.length;
	}



	public void setNumberOfCheckingAccounts(int numberOfCheckingAccounts) {
		this.numberOfCheckingAccounts = numberOfCheckingAccounts;
	}



	public double getCheckingBalance() {
		double chkBal = 0;
		for (int i = 0; i < checkingAccounts.length; i++) {
			
			chkBal += checkingAccounts[i].getBalance();
		}
		return chkBal;
	}







	public int getNumberOfSavingsAccounts() {
		return this.savingsAccounts.length;
	}



	public void setNumberOfSavingsAccounts(int numberOfSavingsAccounts) {
		this.numberOfSavingsAccounts = numberOfSavingsAccounts;
	}



	public double getSavingsBalance() {
		double svgBal = 0;
		for (int i = 0; i < savingsAccounts.length; i++) {
			
			svgBal += savingsAccounts[i].getBalance();
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



	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
	}



	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
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
		return addCheckingAccount(ca); 
	
	}
	
	public  CheckingAccount addCheckingAccount(CheckingAccount chk) {
			CheckingAccount[] temp = Arrays.copyOf(checkingAccounts, checkingAccounts.length + 1);
			temp[temp.length - 1] = chk;
			checkingAccounts = temp;
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
		return addSavingsAccount(sa);
	}
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
			SavingsAccount[] temp = Arrays.copyOf(savingsAccounts, savingsAccounts.length + 1);
			temp[temp.length - 1] = savingsAccount;
			savingsAccounts = temp;
		return savingsAccount;
	}
    //region CDAccount Methods
    
	
	

    
    
    
}