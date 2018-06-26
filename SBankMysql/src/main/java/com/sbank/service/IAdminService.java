package com.sbank.service;

import java.util.List;

import com.sbank.model.Admin;

public interface IAdminService {

  public String addAdmin(Admin object);
  
  public String removeAdmin(Long id);
  
  public List<Admin> getAdmins();
}
