/**
 * 
 */
package com.sbank.wrappers;

import com.sbank.model.Customer;
import com.sbank.model.Bank;

/**
 * @author trainee
 *
 */
public class WrapperClass {
 /**--------bankId-----*/
  public Long bankId;
  /**-----customer--------*/
  public String customerName;
  
  
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
  public Integer pin;
  
	public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
 
	

	
	
	
}
