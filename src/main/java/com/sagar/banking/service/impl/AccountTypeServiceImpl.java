package com.sagar.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.banking.model.AccountType;
import com.sagar.banking.repository.AccountTypeRepository;
import com.sagar.banking.service.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
	@Autowired
	AccountTypeRepository repository;
	
	@Override
	public Iterable<AccountType> getAllAccountType() {
		return repository.findAll();
	}

}
