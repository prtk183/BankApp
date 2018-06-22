package com.customer.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.customer.model.Transaction;
import com.customer.service.TransactionServiceImpl;
import com.sbank.exception.HandleException;



@Controller
public class TransactionController {
  
  @Autowired
  TransactionServiceImpl transactonServiceImpl;
  
  @Autowired
  Environment environment;
  
  Logger log = Logger.getLogger(TransactionController.class.getName());
 
  
  
  /**
 * @param object
 * @return
 * @throws HandleException
 */
@PostMapping("/createtransaction")
  public  ResponseEntity<?> createTransaction( @RequestBody com.customer.wrappers.WrapperTransaction object) throws HandleException
  {
   log.info("in transaction controller createTransaction");
    Transaction tax = transactonServiceImpl.createTransaction(object);
    if(tax!=null)
    {return new ResponseEntity<Transaction>(tax, HttpStatus.OK);}
    else
    { return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}
   }
 
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  @GetMapping("/generatetransactionreport/{accountId}/{customerId}")
  public  ResponseEntity<?> generatetransactionreport( @PathVariable("accountId") Long accountId, @PathVariable("customerId") Long customerId) throws HandleException
  {  log.info("in transaction controller generatetransactionreport ");
    List<Transaction> tax = transactonServiceImpl.generteTransactionReport(accountId, customerId);
     if(tax!=null)
       {return new ResponseEntity<List<Transaction>>(tax, HttpStatus.OK);}
     else
     {       return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}
    }
  
}
