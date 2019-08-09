package com.sagar.banking.service;

import com.sagar.banking.model.Account;

public interface AccountService {
	Iterable<Account> getAllAccount();
	Account saveAccount(Account account);
	Account getAccountById(Long accountId);
	void deleteAccount(Account account);
	Account updateAccount(Account account);
	float calculateLiquidity(Iterable<Account> accounts);
}
