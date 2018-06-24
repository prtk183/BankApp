package com.sbank.wrappers;

import java.math.BigDecimal;



import com.sbank.model.Bank;

public class WrapperATMCreate {
  /**--------*/
  private BigDecimal amount;
  /**--------*/
  private Long bankId;
  
  
  
  public WrapperATMCreate(BigDecimal amount, Long bankId) {
    super();
    this.amount = amount;
    this.bankId = bankId;
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

  
}
