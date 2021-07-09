package com.meritamerica.assignment6.assignment6.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="accounHolderContact")
public class AccountHoldersContactDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
    //region InstanceVariables
	
	@Column
     String firstName;
     String middleName;
     String lastName;
     String ssn;
     
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "id", referencedColumnName = "id")
     private AccountHolder accountHolder;
	
     public AccountHoldersContactDetails() {
    	 this.id = id;
    	 this.firstName = "";
         this.middleName = "";
         this.lastName = "";
         this.ssn = "";
     }
     
     
     public AccountHolder getAccountHolder() {
		return accountHolder;
	}


	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}


	public String getFirstName() {
         return firstName;
     }

     public void setFirstName(String firstName) {
         this.firstName = firstName;
     }
     
     public String getMiddleName() {
         return middleName;
     }

     public void setMiddleName(String middleName) {
         this.middleName = middleName;
     }

     public String getLastName() {
         return lastName;
     }

     public void setLastName(String lastName) {
         this.lastName = lastName;
     }

     public String getSSN() {
         return ssn;
     }

     public void setSSN(String ssn) {
         this.ssn = ssn;
     }
     
}
