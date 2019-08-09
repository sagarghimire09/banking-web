package com.sagar.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountId;
	@Column(nullable=false)
	@NotNull(message="*This field is required.")
	private Long accountNumber;
	private float balance;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@OneToOne
	@JoinColumn(name="accountType_id")
	private AccountType accountType;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", customer=" + customer + ", accountType=" + accountType + "]";
	}
}
