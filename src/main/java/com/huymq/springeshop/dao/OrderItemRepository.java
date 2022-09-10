package com.huymq.springeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huymq.springeshop.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
    
}
