package com.customer.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.wrappers.CreateAccountWrapper;
import com.customer.wrappers.WrapperAccountDeposite;
import com.customer.wrappers.WrapperClass;
import com.customer.wrappers.WrapperTransaction;
import com.customer.wrappers.WrapperUpdateCustomer;
import com.sbank.exception.HandleException;

@Service
public class CustomerServiceImpl implements ICustomerService {

	
	@Autowired
	private InterServicecalls call;
	
	@Autowired
	private TransactionServiceImpl tsi;
	
	/** it will call rest end point create customer of bankMysql microservice.
	 * @see com.customer.service.ICustomerService#createCustomer(java.lang.Long, java.lang.String, java.lang.Integer)
	 */	
	@Override
	public String createCustomer(Long bankId, String customerName, Integer pin) {
		
		WrapperClass object = new WrapperClass(bankId, customerName, pin);
		System.out.println(
				"calling interservice with "+object);
		call.callCreateCustomer(object);
		
		return null;
	}

	@Override
	public Object createAccount(Long bankid, Long customerId, Integer amount) {
		// TODO Auto-generated method stub
		
		CreateAccountWrapper object = new CreateAccountWrapper(bankid, customerId, amount);
		call.callCreateAccount(object);
		
		return "account created";
	}
	
	/** 
	 * @see com.customer.service.ICustomerService#withdrawMoney()
	 */
	@Override
	public String withdrawMoney(Long bankid, Long customerId, Integer amount, Long accountId) {
		BigDecimal amt = new BigDecimal(amount);
		
		WrapperAccountDeposite object = new WrapperAccountDeposite(accountId, customerId, bankid, amt);
		Object result =call.callWithdrawMoney(object);
		WrapperTransaction tax = new WrapperTransaction(customerId, accountId, "WITHDRAW", amt);
		try {
			tsi.createTransaction(tax);
		} catch (HandleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result!=null)
			return "Withdraw Succesfull";
			else
				return null;
	}

	@Override
	public String depositMoney(Long bankid, Long customerId, Integer amount, Long accountId) {
		// TODO Auto-generated method stub
		
		BigDecimal amt = new BigDecimal(amount);
		
		WrapperAccountDeposite object = new WrapperAccountDeposite(accountId, customerId, bankid, amt);
		
		Object result = call.callDepositeMoney(object);
		WrapperTransaction tax = new WrapperTransaction(customerId, accountId, "DEPOSIT", amt);
		try {
			tsi.createTransaction(tax);
		} catch (HandleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result!=null)
		return "Deposit Succesfull";
		else
			return null;
	}

	@Override
	public String getTransactionReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateAccountDetails(String oldname, String newname, Long customerId, Long bankId) {
		
		WrapperUpdateCustomer object = new WrapperUpdateCustomer(customerId, newname, bankId);
		System.out.println("****b4 calling *******"+object);
		Object result = call.callUpdateCustomer(object);
		
		if(result!=null)
		return result;
		else
			return null;
	}



	

}
