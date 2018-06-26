package com.sbank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

  @Id
  Long id;
  String password;
  String role;


  public Admin() {
  }
  
  
  public Admin(Long id, String password, String role) {
    super();
    this.id = id;
    this.password = password;
    this.role=role;
  }


  
  public String getRole() {
    return role;
  }


  public void setRole(String role) {
    this.role = role;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  
  
}
