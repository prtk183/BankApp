package com.sbank.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbank.model.MyAdmin;
import com.sbank.service.AdminServiceImpl;

@RestController
public class AdminController {
  
  /**-------------dminserviceinmpl object------------.*/
  @Autowired
  AdminServiceImpl adminServiceImpl;

  
  /** calling verify admin service.
   * @param id
   * @param password
   * @return
   */
  @PostMapping("/verifyAdmin")
  public ResponseEntity<?> callVerifyAdmin(@PathVariable("loginId") Long id, @PathVariable("password") String password )
  {
  
   String result = adminServiceImpl.verifyAdmin(id, password);
   if(result!=null)
     return new ResponseEntity<String>(result,HttpStatus.OK);
   else
     return new ResponseEntity<String>("No data found",HttpStatus.FAILED_DEPENDENCY);
  }
  

  /** call get admin service.
   * @return
   */
  @GetMapping("/getAdmins")
  public ResponseEntity<?> callGetAdmin()
  {
  
   List<MyAdmin> result = adminServiceImpl.getAdmins();
   if(result!=null)
     return new ResponseEntity<List<MyAdmin>>(result,HttpStatus.OK);
   else
     return new ResponseEntity<String>("No Admins",HttpStatus.FAILED_DEPENDENCY);
  }
  
  
  /** call add admin service.
   * @param id
   * @param role
   * @param password
   * @return
   */
  @PostMapping("/addAdmin")
  public ResponseEntity<String> callAddAdmin(@QueryParam("id") Long id,@QueryParam("role") String role, @QueryParam("password") String password)
  {
    MyAdmin object = new MyAdmin(id, password, role); 
   Object result = adminServiceImpl.addAdmin(object);
   if(result!=null)
     return new ResponseEntity<String>("Admin created",HttpStatus.OK);
   else
     return new ResponseEntity<String>("Not Added",HttpStatus.FAILED_DEPENDENCY);
  }
  
  
  /** call remove admin service.
   * @param id
   * @return
   */
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
