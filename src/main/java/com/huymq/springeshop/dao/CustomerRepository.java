package com.huymq.springeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huymq.springeshop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
