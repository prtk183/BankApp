package com.sbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbank.dao.AdminRepository;

import com.sbank.model.MyAdmin;

@Service
public class AdminServiceImpl implements IAdminService{

  /**----------------adminRepository object-------.*/
  @Autowired
  AdminRepository adminRepository;
  
  /** fetch admin's records for db.
   * @see com.sbank.service.IAdminService#getAdmins()
   */
  @Override
  public List<MyAdmin> getAdmins()
  {
    return adminRepository.findAll();
  }
  
  /** it will add admin.
  /* (non-Javadoc)
   * @see com.sbank.service.IAdminService#addAdmin(com.sbank.model.MyAdmin)
   */
  @Override
  public String addAdmin(MyAdmin object) {

    Object result=null;
    
    if(object.getAdminId()!=null && object.getPassword()!=null)
    {
      result = adminRepository.save(object);
      
    }
    
    return result.toString();
  }

  /** will find the admin by its id and delete it
  /* (non-Javadoc)
   * @see com.sbank.service.IAdminService#removeAdmin(java.lang.Long)
   */
  @Override
  public String removeAdmin(Long id) {
  
    
    adminRepository.delete(id);
    
    return "deleted";
  }

  /** this verify the admin's credentials through DB.
   * @see com.sbank.service.IAdminService#verifyAdmin(java.lang.Long, java.lang.String)
   */
  @Override
  public String verifyAdmin(Long id, String password) {
   String result=null;
    if(id!=null && password!=null)
   {
    MyAdmin admin = adminRepository.findOne(id);
    
    if(id==admin.getAdminId() && password==admin.getPassword())
    {
      
      result=admin.getRole();
    }
    
   }
    return result;
  }

}
