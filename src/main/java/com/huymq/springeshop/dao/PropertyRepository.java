package com.huymq.springeshop.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.huymq.springeshop.entity.ProductProperty;
@NoRepositoryBean
public interface PropertyRepository<Entity extends ProductProperty> extends Repository<Entity, Integer> {
    
}
