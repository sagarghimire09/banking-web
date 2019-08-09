package com.sagar.banking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sagar.banking.model.AccountType;

@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType, Integer> {

}
