package com.customer.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.customer.wrappers.CreateAccountWrapper;
import com.customer.wrappers.WrapperAccountDeposite;
import com.customer.wrappers.WrapperClass;
import com.customer.wrappers.WrapperUpdateCustomer;


@FeignClient("MysqlBank")
public interface InterServicecalls {

	@PostMapping("/createcustomer")
	public Object callCreateCustomer(WrapperClass object);
	
	@PostMapping("/createaccount")
	public Object callCreateAccount(CreateAccountWrapper object);
	
	@PostMapping("/depositemoney")
	public Object callDepositeMoney(WrapperAccountDeposite object);
	
	@PostMapping("/withdrawmoneyfromaccount")
	public Object callWithdrawMoney(WrapperAccountDeposite object);
	
	@PostMapping("/updatecustomer")
	public Object callUpdateCustomer(WrapperUpdateCustomer object);
}
