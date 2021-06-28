package com.meritamerica.assignment6.assignment6.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.validation.Valid;


public class MeritBank {
	
	private static List<CDOfferings> cdos = new ArrayList<CDOfferings>();
	private static List<AccountHolder> achs = new ArrayList<AccountHolder>();
	private static List<CheckingAccount> chks = new ArrayList<CheckingAccount>();
	private static List<SavingsAccount> svgs = new ArrayList<SavingsAccount>();
	private static List<CDAccount> cdas = new ArrayList<CDAccount>();
	
	public static void addaccountholder(@Valid AccountHolder ach) {
		achs.add(ach);
	}
	
	public static void addCheckingAccount(@Valid CheckingAccount chk) {
		chks.add(chk);
	}
	
	public static void addSavingsAccount(@Valid SavingsAccount svg) {
		svgs.add(svg);
	}
	
	public static void addCDAccount(@Valid CDAccount cda) {
		cdas.add(cda);
	}
	
	public static AccountHolder getaccountHolder(int id) {
		for (int i = 0; i < achs.size(); i++) {
			if (achs.get(i).getId() == id) {
				return achs.get(i);
			}
		}
		return null;
	}
	
	public static CheckingAccount getCheckingAccount (int id) {
		for (int i = 0; i < achs.size(); i++) {
			for (int j =0; j <chks.size(); j++) {
				if (chks.get(i).getAccountNumber() == id) {
					return chks.get(i);
				}
			}
		}
		return null;
	}
	
	public static SavingsAccount getSavingsAccount (int id) {
		for (int i = 0; i < achs.size(); i++) {
			for (int j =0; j <svgs.size(); j++) {
				if (svgs.get(i).getAccountNumber() == id) {
					return svgs.get(i);
				}
			}
		}
		return null;
	}
	
	public static CDAccount getCDAccount (int id) {
		for (int i = 0; i < achs.size(); i++) {
			for (int j =0; j <cdas.size(); j++) {
				if (cdas.get(i).getAccountNumber() == id) {
					return cdas.get(i);
				}
			}
		}
		return null;
	}
	
	public static CDOfferings getCDOfferings (int id) {
		for (int i = 0; i < achs.size(); i++) {
			for (int j =0; j < cdos.size(); j++) {
				if (cdos.get(i).getId() == id) {
					return cdos.get(i);
				}
			}
		}
		return null;
	}

	static ArrayList<AccountHolder> accountHolders;

	public static List<AccountHolder> getAccountHolders() {
		return achs;
	}
	
	public static ArrayList<AccountHolder>  sortAccountHolders() {
		Arrays.asList(accountHolders);
		return accountHolders;
	}

	
	public static List<CheckingAccount> getCheckingAccounts() {
		
		return chks;
	}

	public static List<CDOfferings> getCDOfferings() {
		
		return cdos;
	}
	
	public static List<SavingsAccount> getSavingsAccounts() {
		return svgs;
	}
	
	public static void addCDO(CDOfferings cdo) {
		cdos.add(cdo);
	}
	
	public static void clearCDOfferings() {
		cdos = null;
	}
	
	/*
	static CDOfferings getBestCDOffering(double depositAmount) {
		double bestIR = -1;
		CDOfferings bestCDO = null;
		for (int i = 0; i < CDOfferings.nextId; i++) {
			CDOfferings cdo = cdOffering[i];
			double interestRate = cdo.getInterestRate();
			if (interestRate > bestIR) {
				bestIR = interestRate;
				bestCDO = cdo;
			}
		}
	}	
				
	static CDOfferings getSecondBestCDOffering(double depositAmount) {
		double bestIR = -1;
		CDOfferings secondCDO = null; 
		CDOfferings bestCDO = null;
		for (int i = 0; i < cdOfferings.nextId; i++) {
			CDOfferings cdo = cdOffering[i];
			double interestRate = cdo.getInterestRate();
			if (interestRate > bestIR) {
				bestIR = interestRate;
				secondCDO = bestCDO;
				bestCDO = cdo;
			}
		}
		return secondCDO;
	}
	*/
	
	public static void main(String[] args) {
		
	}
	
	static void setNextAccountNumber(long nextAccountNumber) {
		nextAccountNumber = accountNumber;
	}
	static long getNextAccountNumber() {
		accountNumber++;
		return accountNumber;
	}
	static long accountNumber;
	
	public double getTotalBalances() {
		double total = 0;
		for (AccountHolder a : accountHolders) {
			total += a.getCombinedBalance();
		}
		
		return total;
	}
	
	static double totalBalances() {
		double CombinedBalance = 0;
		for (int i = 0; i < achs.size(); i++) {
			AccountHolder accHolder = achs.get(i);
			CombinedBalance = CombinedBalance + accHolder.getCombinedBalance();
		}
		return CombinedBalance;
	}
	static double futureValue(double presentValue, double interestRate, int term) {
			double factor = 1+interestRate;
			return Math.pow(factor, term) * presentValue;
	}



	

	
}