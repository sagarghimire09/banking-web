package com.sagar.banking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sagar.banking.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
