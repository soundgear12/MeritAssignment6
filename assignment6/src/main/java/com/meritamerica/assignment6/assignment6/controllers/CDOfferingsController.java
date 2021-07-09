package com.meritamerica.assignment6.assignment6.controllers;

import java.util.ArrayList;
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
import com.meritamerica.assignment6.assignment6.models.CDOfferings;
import com.meritamerica.assignment6.assignment6.models.MeritBank;
import com.meritamerica.assignment6.assignment6.repo.CDOfferingsRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping(value="/CDOfferings")
public class CDOfferingsController {
	
	@Autowired
	CDOfferingsRepository cdOfferingsRepo;
	
	
	@GetMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.OK)
	public List<CDOfferings> getcdOfferings(){
		return cdOfferingsRepo.findAll();
	}
	
	@PostMapping(value = "/CDOfferings")
	@ResponseStatus(HttpStatus.CREATED)
	public CDOfferings addcdOfferings(@RequestBody @Valid CDOfferings cdOffering) {	
		return cdOfferingsRepo.save(cdOffering);
	}
	
	@GetMapping(value = "/CDOfferings/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CDOfferings getPostById(@PathVariable int id) throws NoSuchResourceFoundException {
		CDOfferings cdo = MeritBank.getCDOfferings(id);
		if (cdo == null) {
			throw new NoSuchResourceFoundException("Invalid id");
		}	
		return cdo;
	}
	
	
}