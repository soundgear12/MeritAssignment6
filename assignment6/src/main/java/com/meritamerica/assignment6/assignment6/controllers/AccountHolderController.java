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
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.meritamerica.assignment6.assignment6.repo.CDAccountsRepository;
import com.meritamerica.assignment6.assignment6.repo.CDOfferingsRepository;
import com.meritamerica.assignment6.assignment6.repo.CheckingAccountRepository;
import com.meritamerica.assignment6.assignment6.repo.SavingsAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@RestController
@RequestMapping(value="/AccountHolder")
public class AccountHolderController {
	
	@Autowired
    AccountHoldersRepository accountsRepo;
	
	@Autowired
	AccountHolderContactDetailsRepository accountHolderContactDetailsRepo;
	
	@Autowired
	CheckingAccountRepository checkingAccountRepo;
	
	@Autowired
	SavingsAccountRepository savingsAccountRepo;
	
	@Autowired
	CDAccountsRepository cdAccountsRepo;
	
	@Autowired
	CDOfferingsRepository CDOfferingsRepo;

	// AccountHolder
	@GetMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolder() {
		return accountsRepo.findAll();
		
	}
	
	
	@PostMapping(value = "/AccountHolder")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
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
		AccountHolder ach = this.getPostById(id);
		accountsRepo.save(ach);
		chk.setAccountHolder(ach);
		return checkingAccountRepo.save(chk);
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CheckingAccount> getCheckingAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		return checkingAccountRepo.findAll();

		
	}
	
	/*
	@GetMapping(value = "/AccountHolder/{id}/CheckingAccounts")
	@ResponseStatus(HttpStatus.OK)
	public CheckingAccount[] getCheckingId(@PathVariable int id) throws NoSuchResourceFoundException {
		return checkingAccountRepo.getById(id);
		
	}
	*/
	
	
	
	//SavingsAccount
	@PostMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable int id, @RequestBody @Valid SavingsAccount svg) throws NoSuchResourceFoundException {
		AccountHolder ach = this.getPostById(id);
		accountsRepo.save(ach);
		svg.setAccountHolder(ach);
		return savingsAccountRepo.save(svg);
	}
	
	@GetMapping(value = "/AccountHolder/{id}/SavingsAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		return savingsAccountRepo.findAll();
	}
	
	
	//CDAccounts
	@PostMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.CREATED)
	public CDAccount addCDAccount(@PathVariable int id, @RequestBody @Valid CDAccount cda) throws NoSuchResourceFoundException {

		AccountHolder ach = getPostById(id);
		accountsRepo.save(ach);
		cda.setAccountHolder(ach);
		cdAccountsRepo.save(cda);
		return cda;
	}
	
	@GetMapping(value = "/AccountHolder/{id}/CDAccounts")
	@ResponseStatus(HttpStatus.OK)
	public List<CDAccount> getCDAccount(@PathVariable int id) throws NoSuchResourceFoundException {
		AccountHolder ach = getPostById(id);
		return cdAccountsRepo.findAll();
	}
	
	
}
