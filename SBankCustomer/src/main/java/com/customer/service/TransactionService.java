package com.customer.service;

import java.util.List;

import com.customer.model.Transaction;
import com.customer.wrappers.WrapperTransaction;
import com.sbank.exception.HandleException;


public interface TransactionService {


  
	/**
	   * @param obj
	   * @return
	   * @throws HandleException
	   */
	  public Transaction createTransaction(WrapperTransaction obj) throws HandleException;
	  
  /**
   * @param obj
   * @return
   * @throws HandleException
   */
  public List<Transaction> generteTransactionReport(Long obj, Long ob3) throws HandleException;
  
  

}
