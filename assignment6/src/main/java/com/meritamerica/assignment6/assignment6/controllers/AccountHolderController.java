package com.meritamerica.assignment6.assignment6.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment6.assignment6.exceptions.NoSuchResourceFoundException;
import com.meritamerica.assignment6.assignment6.models.AccountHolder;
import com.meritamerica.assignment6.assignment6.models.AccountHoldersContactDetails;
import com.meritamerica.assignment6.assignment6.models.CDAccount;
import com.meritamerica.assignment6.assignment6.models.CheckingAccount;
import com.meritamerica.assignment6.assignment6.models.MeritBank;
import com.meritamerica.assignment6.assignment6.models.SavingsAccount;
import com.meritamerica.assignment6.assignment6.repo.AccountHolderContactDetailsRepository;
import com.meritamerica.assignment6.assignment6.repo.AccountHoldersRepository;
import com.meritamerica.assignment6.assignment6.repo.CheckingAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@RestController
public class AccountHolderController {
	
	@Autowired
    AccountHoldersRepository accountsRepo;
	
	@Autowired
	AccountHolderContactDetailsRepository accountHolderContactDetailsRepository;
	
	@Autowired
	CheckingAccountRepository checkingAccountRepo;

	// AccountHolder
	@GetMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolder() {
		return accountsRepo.findAll();
		
	}
	
	
	@PostMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder ach) {
		AccountHoldersContactDetails achDetails = ach.getAccountHolderContactDetails();
		achDetails.setAccountHolder(ach);
		
		return accountsRepo.save(ach);
	}
	
	
	

	
	@GetMapping(value = "/AccountHolder/{id}")
	public AccountHolder getPostById(@PathVariable int id) throws NoSuchResourceFoundException {
		return accountsRepo.getById(id);
	}
	
	
	//CheckingAccount
	@PostMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CheckingAccount addCheckingAccount(@PathVariable int id, @RequestBody @Valid CheckingAccount chk) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		
		chk.setAccountHolder(ach);
		return checkingAccountRepo.save(chk);
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public CheckingAccount[] getCheckingAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		
		return ach.getCheckingAccounts();
	}
	
	
	//SavingsAccount
	@PostMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable int id, @RequestBody @Valid SavingsAccount svg) throws NoSuchResourceFoundException {
		//checkingaccounts.add(checkingAccount);
		AccountHolder ach = getPostById(id);
		ach.addSavingsAccount(svg);
		return svg;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public SavingsAccount[] getSavingsAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		return ach.getSavingsAccounts();
	}
	
	
	//CDAccounts
	@PostMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@PathVariable int id, @RequestBody @Valid CDAccount cda) throws NoSuchResourceFoundException {
		//checkingaccounts.add(checkingAccount);
		AccountHolder ach = getPostById(id);
		accountsrepo.
		return cda;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public CDAccount[] getCDAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		return ach.getCdAccounts();
	}
	
}
