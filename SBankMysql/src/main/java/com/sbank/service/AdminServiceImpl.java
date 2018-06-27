package com.sbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.AdminRepository;

import com.sbank.model.MyAdmin;

@Service
public class AdminServiceImpl implements IAdminService{

  @Autowired
  AdminRepository adminRepository;
  
  
  @Override
  public List<MyAdmin> getAdmins()
  {
    return adminRepository.findAll();
  }
  
  @Override
  public String addAdmin(MyAdmin object) {

    Object result=null;
    
    if(object.getAdminId()!=null && object.getPassword()!=null)
    {
      result = adminRepository.save(object);
      
    }
    
    return result.toString();
  }

  @Override
  public String removeAdmin(Long id) {
  
    
    adminRepository.delete(id);
    
    return "deleted";
  }

}
