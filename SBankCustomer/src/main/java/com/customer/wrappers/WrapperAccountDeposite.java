package com.customer.wrappers;

import java.math.BigDecimal;



public class WrapperAccountDeposite {
  /**------------*/
 private Long accountId;
 /**------------*/
  private Long customerId;
  /**------------*/
  private Long bankId;
  /**------------*/
  private BigDecimal amount;
  
  
  
  public WrapperAccountDeposite(Long accountId, Long customerId, Long bankId, BigDecimal amount) {
    super();
    this.accountId = accountId;
    this.customerId = customerId;
    this.bankId = bankId;
    this.amount = amount;
  }
  public Long getAccountId() {
    return accountId;
  }
  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }
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
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
 
 
 

}
