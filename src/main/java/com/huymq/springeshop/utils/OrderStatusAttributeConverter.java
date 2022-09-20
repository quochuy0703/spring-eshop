package com.huymq.springeshop.utils;

import javax.persistence.AttributeConverter;

import com.huymq.springeshop.entity.OrderStatus;

public class OrderStatusAttributeConverter implements AttributeConverter<OrderStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStatus attribute) {
        if (attribute == null)
            return null;
 
        switch (attribute) {
        case UNPROCESSED:
            return 0;
 
        case READY_TO_SHIP:
            return 1;
 
        case PROCESSED:
            return 2;
 
        case SHIPPED:
            return 3;
 
        case COMPLETED:
            return 4;
        case IN_CANCEL:
            return 5;
        case CANCELLED:
            return 6;
 
        default:
            throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;
 
        switch (dbData) {
        case 0:
            return OrderStatus.UNPROCESSED;
 
        case 1:
            return OrderStatus.READY_TO_SHIP;
 
        case 2:
            return OrderStatus.PROCESSED;
 
        case 3:
            return OrderStatus.SHIPPED;
 
        case 4:
            return OrderStatus.COMPLETED;
        case 5:
            return OrderStatus.IN_CANCEL;
        case 6:
            return OrderStatus.CANCELLED;
 
        default:
            throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
    
}
