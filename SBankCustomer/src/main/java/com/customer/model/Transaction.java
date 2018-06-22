package com.customer.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transaction {
  
  /**------transactionId----.**/
  @Id
  private Long transactionId;
  /**-----customer-----.*/
  
  private Long customerId;
  
  /**----account------.*/
  private Long accountId;
  
  /**-----amount-----.*/
  private BigDecimal amount;
  
  /**-----transactionType-----.*/
  private String transactionType;
  


  /**
   * default constructor.
   */
  public Transaction()
  {
    
  }
  
  
  
  public Transaction(Long transactionId, Long customerId, Long accountId, BigDecimal amount, String transactionType) {
	super();
	this.transactionId = transactionId;
	this.customerId = customerId;
	this.accountId = accountId;
	this.amount = amount;
	this.transactionType = transactionType;
}



public Long getCustomerId() {
	return customerId;
}



public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}



public Long getAccountId() {
	return accountId;
}



public void setAccountId(Long accountId) {
	this.accountId = accountId;
}



/**.
   * @return.
   */
  public Long getTransactionId() {
    return transactionId;
  }
  
  /**.
   * @param transactionId.
   */
  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

 

  
  /**.
   * @return.
   */
  public BigDecimal getAmount() {
    return amount;
  }
 
  /**.
   * @param amount.
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
 
  /**.
   * @return.
   */
  public String getTransactionType() {
    return transactionType;
  }
  
  /**.
   * @param transactionType.
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }


}
