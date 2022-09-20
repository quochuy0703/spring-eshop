package com.huymq.springeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huymq.springeshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    @Query("select count(o) from Order o")
    public int countOrder();
}
