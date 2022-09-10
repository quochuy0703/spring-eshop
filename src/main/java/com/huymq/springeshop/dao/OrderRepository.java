package com.huymq.springeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huymq.springeshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
