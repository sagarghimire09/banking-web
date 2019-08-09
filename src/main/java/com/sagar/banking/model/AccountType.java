package com.sagar.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class AccountType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountTypeId;
	@NotBlank(message="*This field is required.")
	private String accountTypeName;
	
	public Integer getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	
	@Override
	public String toString() {
		return "AccountType [accountTypeId=" + accountTypeId + ", accountTypeName=" + accountTypeName + "]";
	}
}
