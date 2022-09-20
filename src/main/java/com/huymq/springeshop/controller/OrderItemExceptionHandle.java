package com.huymq.springeshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.huymq.springeshop.utils.MessageResponse;
import com.huymq.springeshop.utils.exception.OrderItemNotFoundException;

@ControllerAdvice
public class OrderItemExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<MessageResponse> handleOrderItemNotFoundException(OrderItemNotFoundException e){
        MessageResponse error = new MessageResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<MessageResponse>(error, HttpStatus.NOT_FOUND);

    }
    
}
