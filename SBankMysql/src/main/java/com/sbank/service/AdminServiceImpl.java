package com.sbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.AdminRepository;
import com.sbank.model.Admin;

@Service
public class AdminServiceImpl implements IAdminService{

  @Autowired
  AdminRepository adminRepository;
  
  
  @Override
  public List<Admin> getAdmins()
  {
    return adminRepository.findAll();
  }
  
  @Override
  public String addAdmin(Admin object) {

    Object result=null;
    
    if(object.getId()!=null && object.getPassword()!=null)
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
