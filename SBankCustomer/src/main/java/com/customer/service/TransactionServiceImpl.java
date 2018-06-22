package com.customer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.customer.model.Transaction;
import com.customer.repository.TransactionRepository;
import com.customer.wrappers.WrapperTransaction;
import com.sbank.exception.HandleException;



@Service
public class TransactionServiceImpl implements TransactionService{


  
  /**----------------customerServiceImpl object------------------------.*/
  @Autowired
  private CustomerServiceImpl customerServiceImpl;
  
  /**----------------transactionRepository object---------------------.*/
  @Autowired
  private TransactionRepository transactionRepository;
  

  
  /**----------------log object------------------.*/
  Logger log = Logger.getLogger(TransactionServiceImpl.class.getName());

  /**/
  /* generating report for an id
   * @see com.sbank.service.TransactionService#generteTransactionReport(com.sbank.wrappers.WrapperTransaction)
   */
  @Override
  public List<Transaction> generteTransactionReport(final Long accountId, final Long customerId) throws HandleException {
    log.info("in trnsaction service generteTransactionReport");
 if(accountId!=null && customerId!=null)
 {
    List<Transaction> transactionList  = transactionRepository.findAll();
   
    List<Transaction> transactionReportForById= new ArrayList<Transaction>();
 
    System.out.println("b+"+accountId);
    for(Transaction ts :transactionList)
    {
   
      transactionReportForById.add(transactionRepository.findBytransactionId(ts.getTransactionId()).get());

    }
   
    if(transactionReportForById.isEmpty())
    {
      throw new HandleException("no reposrts");
    }
    else
    {
       return transactionReportForById;
    }
 }
 else
 {
   throw new HandleException("error");

 }
  }

@Override
public Transaction createTransaction(WrapperTransaction obj) throws HandleException {

	Random random = new Random();
	
	Long tid = random.nextLong(); 
	Transaction entity = new Transaction(tid, obj.getCustomerId(), obj.getAccount(), obj.getAmount(), obj.getTtype());
	transactionRepository.save(entity);
	return null;
}

  

}
