package com.customer.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.model.Customer;


public interface CustomerRepo  extends  MongoRepository<Customer, Long>{

}
