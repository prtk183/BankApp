/**
 * 
 */
package com.customer.wrappers;


/**
 * @author trainee
 *
 */
public class WrapperClass {
 /**--------bankId-----*/
  public Long bankId;
  /**-----customer--------*/
  public String customerName;
  
  public Integer pin;
  
  
  
  @Override
public String toString() {
	return "WrapperClass [bankId=" + bankId + ", customerName=" + customerName + ", pin=" + pin + "]";
}
public WrapperClass(Long bankId, String customerName, Integer pin) {
	super();
	this.bankId = bankId;
	this.customerName = customerName;
	this.pin = pin;
}
public String getCustomerName() {
    return customerName;
  }
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  public Integer getPin() {
    return pin;
  }
  public void setPin(Integer pin) {
    this.pin = pin;
  }
  
  
	public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
 
	

	
	
	
}
