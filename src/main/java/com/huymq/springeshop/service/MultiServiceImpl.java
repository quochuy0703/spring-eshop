package com.huymq.springeshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huymq.springeshop.dao.CartRepository;
import com.huymq.springeshop.dao.CustomerRepository;
import com.huymq.springeshop.dao.OrderItemRepository;
import com.huymq.springeshop.dao.OrderRepository;
import com.huymq.springeshop.dao.ProductRepository;
import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Order;
import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.Product;

@Service
public class MultiServiceImpl implements MultiService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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
    @Transactional
    public Customer findCustomerById(int theId) {
        Customer customer = null;
        Optional<Customer> optional = customerRepository.findById(theId);
        if(optional.isPresent()){
            customer = optional.get();
        }
        return customer;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
        
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
        
    }

    @Override
    @Transactional
    public Cart findCartById(int theId) {

        Optional<Cart> optional = cartRepository.findById(theId);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteCartById(int theId) {

        cartRepository.deleteById(theId);
        
    }

    @Override
    @Transactional
    public void saveCart(Cart theCart) {

        cartRepository.save(theCart);
        
    }

    @Override
    @Transactional
    public void saveOrder(Order theOrder) {
        orderRepository.save(theOrder);
        
    }

    @Override
    @Transactional
    public void saveOrderItem(OrderItem theOrderItem) {
        orderItemRepository.save(theOrderItem);
        
    }
    
}
