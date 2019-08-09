package com.sagar.banking.service;


import com.sagar.banking.model.Customer;

public interface CustomerService {
	Iterable<Customer> getAllCustomer();
	Customer saveCustomer(Customer customer);
	Customer getCustomerById(Long customerId);
	void deleteCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	
}
