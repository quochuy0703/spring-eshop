package com.huymq.springeshop.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.OrderStatus;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
    
    @Query("Select o from OrderItem o where o.orderStatus =:status")
    public Page<OrderItem> findOrderItemByStatus(@Param("status") OrderStatus status, Pageable pageable);
}
