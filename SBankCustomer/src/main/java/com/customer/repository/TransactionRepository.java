package com.customer.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.customer.model.Transaction;



public interface TransactionRepository extends MongoRepository<Transaction, Long> {
 
	@Query
  Optional<Transaction> findBytransactionId(Long transactionId);

  
}
