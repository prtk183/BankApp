package com.customer.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	@Id
	Long customerId;
	Long bankId;
	Long accountId;
	Long atmId;
	Long customerMobileNo;
	String customerName;
	String customerCity;
	
	
	/**--constructors-------.*/
	public Customer(){}


	public Customer(Long customerId, Long bankId, Long accountId, Long atmId, Long customerMobileNo,
			String customerName, String customerCity) {
		super();
		this.customerId = customerId;
		this.bankId = bankId;
		this.accountId = accountId;
		this.atmId = atmId;
		this.customerMobileNo = customerMobileNo;
		this.customerName = customerName;
		this.customerCity = customerCity;
	}

	/**---getters and setters----------.*/
	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Long getBankId() {
		return bankId;
	}


	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}


	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}


	public Long getAtmId() {
		return atmId;
	}


	public void setAtmId(Long atmId) {
		this.atmId = atmId;
	}


	public Long getCustomerMobileNo() {
		return customerMobileNo;
	}


	public void setCustomerMobileNo(Long customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerCity() {
		return customerCity;
	}


	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	

	
	
}
