package com.sagar.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sagar.banking.model.Customer;
import com.sagar.banking.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/customer/list")
	public String listCustomer(Model model) {
		model.addAttribute("customers", service.getAllCustomer());
		return "customer/list";
	}
	
	@GetMapping("/customer/create")
	public String createCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/create";
	}
	
	@PostMapping("/customer/save")
	public String saveCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult bindingResult, Model model) {
		System.out.println(customer);
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "customer/create";
		}
		service.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/edit/{customerId}")
	public String editCustomer(@PathVariable("customerId")Long customerId, Model model) {
		Customer customer = service.getCustomerById(customerId);
		if(customer != null) {
			model.addAttribute("customer", customer);
		}
		return "customer/edit";
	}
	
	@PostMapping("/customer/update")
	public String updateCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors",bindingResult.getAllErrors());
			return "customer/edit";
		}
		service.updateCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer/delete/{customerId}")
	public String deleteCustomer(@PathVariable("customerId")Long customerId) {
		Customer customer = service.getCustomerById(customerId);
		if(customer != null) {
			service.deleteCustomer(customer);
		}
		return "redirect:/customer/list";
	}
}
