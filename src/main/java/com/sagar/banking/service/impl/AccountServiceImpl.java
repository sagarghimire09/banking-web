package com.sagar.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.banking.model.Account;
import com.sagar.banking.repository.AccountRepository;
import com.sagar.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository repository;

	@Override
	public Iterable<Account> getAllAccount() {
		return repository.findAll();
	}

	@Override
	public Account saveAccount(Account account) {
		return repository.save(account);
	}

	@Override
	public Account getAccountById(Long accountId) {
		return repository.findById(accountId).orElse(null);
	}

	@Override
	public void deleteAccount(Account account) {
		repository.delete(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return repository.save(account);
	}
	
	public float calculateLiquidity(Iterable<Account> accounts) {
		float sumDeposit = 0.0f;
		if(accounts == null) return sumDeposit;
		for(Account a : accounts) {
			if(a.getAccountType().getAccountTypeName().equals("Checking") || a.getAccountType().getAccountTypeName().equals("Savings")) {
				sumDeposit += a.getBalance();
			}else {
				sumDeposit -= a.getBalance();
			}
		}
		return sumDeposit;
	}

}
