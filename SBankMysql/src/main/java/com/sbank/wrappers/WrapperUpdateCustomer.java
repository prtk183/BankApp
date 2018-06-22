package com.sbank.wrappers;

public class WrapperUpdateCustomer {

  /**------id of customer------.*/
  private Long id;
  /**-------customer name to update-----*/
  private String customerName;
  /**--------customer bank name----------.*/
  private Long customerBankId;
  
  /**----constructor-------.*/
  WrapperUpdateCustomer()
  {
    
  }
  
  

  @Override
  public String toString() {
    return "WrapperUpdateCustomer [id=" + id + ", customerName=" + customerName
        + ", customerBankId=" + customerBankId + "]";
  }



  /**----------getters and setters-----.*/
  public Long getCustomerBankId() {
    return customerBankId;
  }
  public void setCustomerBankId(Long customerBankId) {
    this.customerBankId = customerBankId;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getCustomerName() {
    return customerName;
  }
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


}
