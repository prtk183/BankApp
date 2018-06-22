package com.customer.service;

import org.springframework.cloud.netflix.feign.FeignClient;


public interface ICustomerService {

	
	public String createCustomer(Long bankId, String customerName, Integer pin);
	
	public Object createAccount(Long bankid, Long customerId, Integer amount); 
	
	public Object updateAccountDetails(String oldname, String newname, Long customerId, Long bankId);
	
	public String withdrawMoney(Long bankid, Long customerId, Integer amount, Long accountId);
	
	
	public String getTransactionReport();
	
	public String deleteAccount();


	public String depositMoney(Long bankid, Long customerId, Integer amount, Long accountId);
}
