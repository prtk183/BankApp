package com.sbank.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sbank.model.Admin;
import com.sbank.service.AdminServiceImpl;

@Controller
public class AdminController {
  
  @Autowired
  AdminServiceImpl adminServiceImpl;

  
  @GetMapping("/getAdmins")
  public ResponseEntity<?> callGetAdmin()
  {
  
   List<Admin> result = adminServiceImpl.getAdmins();
   if(result!=null)
     return new ResponseEntity<List<Admin>>(result,HttpStatus.OK);
   else
     return new ResponseEntity<String>("No Admins",HttpStatus.FAILED_DEPENDENCY);
  }
  
  
  @PostMapping("/addAdmin")
  public ResponseEntity<String> callAddAdmin(@QueryParam("id") Long id,@QueryParam("role") String role, @QueryParam("password") String password)
  {
   Admin object = new Admin(id, password, role); 
   Object result = adminServiceImpl.addAdmin(object);
   if(result!=null)
     return new ResponseEntity<String>("Admin created",HttpStatus.OK);
   else
     return new ResponseEntity<String>("Not Added",HttpStatus.FAILED_DEPENDENCY);
  }
  
  @PostMapping("/removeAdmin")
  public ResponseEntity<String> callremoveAdmin(@QueryParam("id") Long id)
  {
  
   Object result = adminServiceImpl.removeAdmin(id);
   if(result!=null)
     return new ResponseEntity<String>("Admin removed",HttpStatus.OK);
   else
     return new ResponseEntity<String>("Not removed",HttpStatus.FAILED_DEPENDENCY);
  }
}
