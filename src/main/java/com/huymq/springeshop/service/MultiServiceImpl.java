package com.huymq.springeshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huymq.springeshop.dao.CustomerRepository;
import com.huymq.springeshop.dao.ProductRepository;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Product;

@Service
public class MultiServiceImpl implements MultiService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Product> findAllProduct() {

        return productRepository.findAll();
    }

    @Override
    @Transactional
    public List<Product> findAllNewProduct() {
        
        return productRepository.findAllNewProduct();
    }

    @Override
    @Transactional
    public List<Product> findAllHighlightProduct() {
        
        return productRepository.findAllHighlightProduct();
    }

    // @Override
    // @Transactional
    // public Product findProductById(int theId) {
    //     Product product = null;
    //     Optional<Product> optional = productRepository.findById(theId);
    //     if(optional.isPresent()){
    //         product = optional.get();
    //     }

    //     return product;
    // }
    @Override
    @Transactional
    public Product findProductById(int theId) {

        List<Product> optional = productRepository.findProductById(theId);
        

        return optional.get(0);
    }

    @Override
    public Customer findCustomerById(int theId) {
        Customer customer = null;
        Optional<Customer> optional = customerRepository.findById(theId);
        if(optional.isPresent()){
            customer = optional.get();
        }
        return customer;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
        
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
        
    }
    
}
