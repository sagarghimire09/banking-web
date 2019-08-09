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

import com.sagar.banking.model.Account;
import com.sagar.banking.service.AccountService;
import com.sagar.banking.service.AccountTypeService;
import com.sagar.banking.service.CustomerService;

@Controller
public class AccountController {
	@Autowired
	AccountService service;
	@Autowired
	AccountTypeService accTypeService;
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/account/list")
	public String listCustomer(Model model) {
		model.addAttribute("accounts", service.getAllAccount());
		model.addAttribute("liquidity", service.calculateLiquidity(service.getAllAccount()));
		return "account/list";
	}
	
	@GetMapping("/account/create")
	public String createAccount(Model model) {
		model.addAttribute("account", new Account());
		model.addAttribute("accountTypes", accTypeService.getAllAccountType());
		model.addAttribute("customers", customerService.getAllCustomer());
		return "account/create";
	}
	
	@PostMapping("/account/save")
	public String saveAccount(@Valid @ModelAttribute("account")Account account, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "account/create";
		}
		service.saveAccount(account);
		return "redirect:/account/list";
	}
	
	@GetMapping("/account/edit/{accountId}")
	public String editAccount(@PathVariable("accountId")Long accountId, Model model) {
		Account account = service.getAccountById(accountId);
		System.out.println(account);
		if(account != null) {
			model.addAttribute("account", account);
			model.addAttribute("accountTypes", accTypeService.getAllAccountType());
			model.addAttribute("customers", customerService.getAllCustomer());
		}
		return "account/edit";
	}
	
	@PostMapping("/account/update")
	public String updateAccount(@ModelAttribute("account")Account account) {
		service.updateAccount(account);
		return "redirect:/account/list";
	}
	
	@GetMapping("/account/delete/{accountId}")
	public String deleteAccount(@PathVariable("accountId")Long accountId) {
		Account account = service.getAccountById(accountId);
		if(account != null) {
			service.deleteAccount(account);
		}
		return "redirect:/account/list";
	}
	
}
