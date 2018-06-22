package com.customer.controller;

import java.math.BigDecimal;

import javax.ws.rs.QueryParam;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.service.CustomerServiceImpl;


@RestController
public class CustomerController {

	Logger Log = Logger.getLogger("Inside"+CustomerController.class);
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	
	/** calling create account with parameters
	 * @param bankid
	 * @param customerName
	 * @param pin
	 * @return
	 */
	@PostMapping("/createaccount")
	public ResponseEntity<?> callCreateAccount(@QueryParam("bankid") Long bankid, @QueryParam("customerId") Long customerId, @QueryParam("amount") Integer amount){
		

	    Log.info("calling comtroller create customer");
	   
	 
	 
	    final Object result = customerServiceImpl.createAccount(bankid, customerId, amount);
	    if(result!=null)

	    {return new ResponseEntity<String>(result.toString(), HttpStatus.OK);}
	    else
	    {return new ResponseEntity<String>("Error in account creation", HttpStatus.BAD_GATEWAY);}
	    
	}
	
	@PostMapping("/DepositMoney")
	public ResponseEntity<?> callDepositeMoney(@QueryParam("bankid") Long bankid,@QueryParam("customerId") Long customerId,@QueryParam("amount") Integer amount,@QueryParam("accountId") Long accountId){
		

	    Log.info("calling comtroller create customer");
	   
	 
	    final Object result = customerServiceImpl.depositMoney(bankid, customerId, amount, accountId );
	    if(result!=null)

	    {return new ResponseEntity<String>(result.toString(), HttpStatus.OK);}
	    else
	    {return new ResponseEntity<String>("Error in account creation", HttpStatus.BAD_GATEWAY);}
	    
	}
	
	@PostMapping("/WithdrawMoney")
	public ResponseEntity<?> callWithdrawMoney(@QueryParam("bankid") Long bankid,@QueryParam("customerId") Long customerId,@QueryParam("amount") Integer amount,@QueryParam("accountId") Long accountId){
		

	    Log.info("calling comtroller create customer");
	   
	 
	    final Object result = customerServiceImpl.withdrawMoney(bankid, customerId, amount, accountId);
	    if(result!=null)

	    {return new ResponseEntity<String>(result.toString(), HttpStatus.OK);}
	    else
	    {return new ResponseEntity<String>("Error in account creation", HttpStatus.BAD_GATEWAY);}
	    
	}
	
	@PostMapping("/update")
	ResponseEntity<?> callUpdateAccountDetails(@QueryParam("customerName") String customerName, @QueryParam("newName") String newName, @QueryParam("customerId") Long customerId, @QueryParam("bankId") Long bankId){
		

		   System.out.println(customerName);
		    System.out.println(customerId);
		    System.out.println(bankId);
		    System.out.println("to updtae "+newName);
		    
	    Log.info("calling comtroller create customer");
	   
	 
	    final Object result = customerServiceImpl.updateAccountDetails(customerName, newName, customerId, bankId);
	    if(result!=null)

	    {return new ResponseEntity<String>("UPdated succesfully", HttpStatus.OK);}
	    else
	    {return new ResponseEntity<String>("Error in account creation", HttpStatus.BAD_GATEWAY);}
	    
	}
	
	
}
