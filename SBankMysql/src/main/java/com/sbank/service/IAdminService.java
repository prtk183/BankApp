package com.sbank.service;

import java.util.List;


import com.sbank.model.MyAdmin;

public interface IAdminService {

  public String addAdmin(MyAdmin object);
  
  public String removeAdmin(Long id);
  
  public List<MyAdmin> getAdmins();

  public String verifyAdmin(Long id, String password);
}
