package com.sbank.wrappers;

import java.math.BigDecimal;


public class WrapperATMAddMoneyToATM {
  
  /**--------*/
  private BigDecimal amount;
  /**--------*/
  private Long bankId;
  /**--------*/
  private Long atmID;
  
  
  public WrapperATMAddMoneyToATM(BigDecimal amount, Long bankId, Long atmID) {
    super();
    this.amount = amount;
    this.bankId = bankId;
    this.atmID = atmID;
  }
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  public Long getBankId() {
    return bankId;
  }
 
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

 
  
  public Long getAtmID() {
    return atmID;
  }
  public void setAtmID(Long atmID) {
    this.atmID = atmID;
  }
 
  
}
