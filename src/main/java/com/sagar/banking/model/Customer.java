package com.sagar.banking.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;
	@Column(nullable=false)
	@NotNull(message="*This field is required.")
	private Long customerNumber;
	@NotBlank(message="*This field is required.")
	private String firstName;
	private String middleName;
	@NotBlank(message="*This field is required.")
	private String lastName;
	@NotBlank(message="*This field is required.")
	private String emailAddress;
	private String contactPhoneNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="*This field is required.")
	private LocalDate dateOfBirth;
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Account> accounts;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerNumber=" + customerNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", contactPhoneNumber=" + contactPhoneNumber + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
