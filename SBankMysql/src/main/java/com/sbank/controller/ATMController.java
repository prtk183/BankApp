package com.sbank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbank.dao.ATMRepository;
import com.sbank.dao.AccountRepository;
import com.sbank.dao.BankRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.ATM;
import com.sbank.model.Account;
import com.sbank.model.Bank;
import com.sbank.service.ATMService;
import com.sbank.wrappers.WrapperATMAddMoneyToATM;
import com.sbank.wrappers.WrapperATMCreate;
import com.sbank.wrappers.WrapperATMWithdraw;

@RestController
public class ATMController {

 
 
  @Autowired
  com.sbank.service.ATMServiceImpl ATMServiceImpl;
  
  @Autowired
  Environment environment;

  Logger log = Logger.getLogger(ATMController.class.getName());
  /**
   * this will call create atm in service
   * with arguments as bankid and its own details
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/createatm")
  public ResponseEntity<?> callcreateATM(@QueryParam("bankId") Integer bankId, @QueryParam("amount") Integer amount) throws HandleException
  {
    ATM atm = new ATM();
    log.info("in controller creating atm");
    System.out.println(bankId);
 Long longvar = Integer.toUnsignedLong(bankId);
 System.out.println(longvar);
    WrapperATMCreate object = new WrapperATMCreate(new BigDecimal(amount), longvar );
    System.out.println("******controller****"+object);
    atm = ATMServiceImpl.createATM(object);
    if(atm!=null)
    {return new ResponseEntity<ATM>(atm,HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"),HttpStatus.BAD_REQUEST);}
  }

  /**to add money from bank
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/addmoneyfrombank")
  public ResponseEntity<?> calladdMoneyFromBank(@QueryParam("atmId") Long atmId, @QueryParam("bankId") Long bankId, @QueryParam("amount") Integer amount) throws HandleException
  {
    ATM atm = new ATM();
    log.info("in controller calladdMoneyFromBank");
    WrapperATMAddMoneyToATM object =  new WrapperATMAddMoneyToATM(new BigDecimal(amount), atmId, bankId);
    atm = ATMServiceImpl.addMoneyFromBank(object);
 
    if(atm!=null)
    {return new ResponseEntity<ATM>(atm,HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"),HttpStatus.BAD_REQUEST);}
  }

  /**
   * call withdraw service
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/withdrawmoney")
  public ResponseEntity<?> callwithdrawMoney(@RequestBody WrapperATMWithdraw object) throws HandleException
  {
    ATM atm = new ATM();
    log.info("in controller callwithdrawMoney");
    atm = ATMServiceImpl.withdrawMoney(object);
    if(atm!=null)
    {return new ResponseEntity<ATM>(atm,HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"),HttpStatus.BAD_REQUEST);}
  }
  
  @GetMapping("/getAtms")
  public ResponseEntity<?> callgetAtm() throws HandleException
  {
   
    log.info("in controller callwithdrawMoney");
    List<ATM> listAtm = ATMServiceImpl.getAtms();
    
    if(listAtm!=null)
    {return new ResponseEntity<List<ATM>>(listAtm,HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"),HttpStatus.BAD_REQUEST);}
  }
}
