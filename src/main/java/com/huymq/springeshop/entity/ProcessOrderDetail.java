package com.huymq.springeshop.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.huymq.springeshop.utils.OrderStatusAttributeConverter;

@Entity
@Table(name="process_order_detail")
public class ProcessOrderDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="note")
    private String note;

    @Column(name="order_status_process")
    @Convert(converter = OrderStatusAttributeConverter.class)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="order_item_id")
    private OrderItem orderItem;


    
    @Override
    public String toString() {
        return "ProcessOrderDetail [id=" + id + ", note=" + note + ", orderStatus=" + orderStatus + "]";
    }
    public ProcessOrderDetail() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public OrderItem getOrderItem() {
        return orderItem;
    }
    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    
}
