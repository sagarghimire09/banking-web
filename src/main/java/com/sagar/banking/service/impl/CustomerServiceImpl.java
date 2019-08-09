package com.sagar.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.banking.model.Customer;
import com.sagar.banking.repository.CustomerRepository;
import com.sagar.banking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	@Override
	public Iterable<Customer> getAllCustomer() {
		return repository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return repository.findById(customerId).orElse(null);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		repository.delete(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}

}
