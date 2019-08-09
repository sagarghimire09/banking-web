package com.sagar.banking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sagar.banking.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
