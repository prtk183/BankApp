package com.sbank.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbank.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
