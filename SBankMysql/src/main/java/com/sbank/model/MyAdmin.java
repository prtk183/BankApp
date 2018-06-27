package com.sbank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MyAdmin {

  @Id
  private Long adminId;

  private String password;
  private String role;


  public MyAdmin() {
  }
  
  
  public MyAdmin(Long adminId, String password, String role) {
    super();
    this.adminId = adminId;
    this.password = password;
    this.role=role;
  }


  
  public String getRole() {
    return role;
  }

  public Long getAdminId() {
    return adminId;
  }


  public void setAdminId(Long adminId) {
    this.adminId = adminId;
  }
  public void setRole(String role) {
    this.role = role;
  }


  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  
  
}
