package com.huymq.springeshop.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huymq.springeshop.dao.BrandRepository;
import com.huymq.springeshop.dao.CartRepository;
import com.huymq.springeshop.dao.CustomerRepository;
import com.huymq.springeshop.dao.OrderItemRepository;
import com.huymq.springeshop.dao.OrderRepository;
import com.huymq.springeshop.dao.ProductRepository;
import com.huymq.springeshop.dao.RoleRepository;
import com.huymq.springeshop.dao.UserLoginRepository;
import com.huymq.springeshop.entity.Brand;
import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Order;
import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.OrderStatus;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.ProductJsonInterface;
import com.huymq.springeshop.entity.Role;
import com.huymq.springeshop.entity.UserLogin;

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

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    @Transactional
    public List<Product> findAllProduct() {

        return productRepository.findAll();
    }

    @Override
    @Transactional
    public List<Product> findAllNewProduct(boolean isNew) {
        
        return productRepository.findByNewItem(isNew);
    }

    @Override
    @Transactional
    public List<Product> findAllHighlightProduct(boolean highlight) {
        
        return productRepository.findByHighlight(highlight);
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
    public int countOrder() {
       
        return orderRepository.countOrder();
    }

    @Override
    @Transactional
    public void saveOrderItem(OrderItem theOrderItem) {
        orderItemRepository.save(theOrderItem);
        
    }

    @Override
    @Transactional
    public Page<OrderItem> findOrderItemByStatus(OrderStatus status, Pageable pageable) {
        
        return orderItemRepository.findOrderItemByStatus(status, pageable);
    }

    @Override
    public OrderItem findOrderItemById(int theId) {

        OrderItem orderItem = null;
        Optional<OrderItem> optional = orderItemRepository.findById(theId);
        if(optional.isPresent()){
            orderItem = optional.get();
        }
        return orderItem;
        
    }

    @Override
    @Transactional
    public Page<Product> findProductByType(char type, Pageable pageable) {
        
        return productRepository.findProductByType(type, false, pageable);
    }

    @Override
    @Transactional
    public Product findProductByUUID(UUID uuid) {
       
        return productRepository.findProductByUUID(uuid);
    }


    @Override
    public List<Product> findAllBannerProduct(boolean isBanner) {
        
        return productRepository.findByIsBanner(isBanner);
    }
    @Override
    @Transactional
    public List<Product> findProductsTop3ByOrderByCountSaleDesc() {
        
        return productRepository.findTop3ByOrderByCountSaleDesc();
    }

    @Override
    @Transactional
    public List<Product> findProductsTop3ByOrderByCountSeenDesc() {
        
        return productRepository.findTop3ByOrderByCountSeenDesc();
    }

    @Override
    @Transactional
    public List<Product> findProductByNewItemOrHighlightOrIsBanner(boolean isNew, boolean highlight, boolean isBanner) {
        
        return productRepository.findProductByNewItemOrHighlightOrIsBanner(isNew, highlight, isBanner);
    }

    @Override
    @Transactional
    public List<Product> findProductByPriceBetween(double minPrice, double maxPrice) {
       
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    @Transactional
    public List<Product> findProductByProductTypeAndPriceBetween(char type, double minPrice, double maxPrice) {
        
        return productRepository.findByProductTypeAndPriceBetween(null, type, minPrice, maxPrice);
    }

    @Override
    @Transactional
    public List<ProductJsonInterface> findProductJsonByProductTypeAndPriceBetween(char type, double minPrice, double maxPrice) {
       
        return productRepository.findByProductTypeAndPriceBetween(ProductJsonInterface.class, type, minPrice, maxPrice);
    }
    @Override
    @Transactional
    public List<ProductJsonInterface> findProductJsonByProductTypeAndPriceGreaterThan(char type, double minPrice) {
        
        return productRepository.findByProductTypeAndPriceGreaterThan(ProductJsonInterface.class, type, minPrice);
    }

    @Override
    @Transactional
    public List<ProductJsonInterface> findProductJsonByWord(String word) {
        
        return productRepository.findByWord(ProductJsonInterface.class,word);
    }

    @Override
    @Transactional
    public List<ProductJsonInterface> findProductJsonByBrand(int theId) {
       
        return productRepository.findByBrand(ProductJsonInterface.class, theId);
    }

    @Override
    public int countProductByNewItem(boolean isNew) {
       
        return productRepository.countByNewItem(isNew);
    }

    @Override
    public int countProductByIsBanner(boolean isBanner) {
        
        return productRepository.countByIsBanner(isBanner);
    }


    @Override
    public int countProductByHighlight(boolean highlight) {
       
        return productRepository.countByHighlight(highlight);
    }


    @Override
    @Transactional
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAllProduct(false, pageable);
    }

    @Override
    @Transactional
    public Page<Product> findAllProductIsDeleted(Pageable pageable) {
        return productRepository.findAllProduct(true, pageable);
    }

    @Override
    @Transactional
    public Customer findCustomerByEmail(String email) {
        
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    @Transactional
    public UserLogin findUserLoginById(int theId) {
        UserLogin userLogin = null;
        Optional<UserLogin> optional = userLoginRepository.findById(theId);
        if(optional.isPresent()){
            userLogin= optional.get();
        }
        return userLogin;
    }

    @Override
    @Transactional
    public UserLogin findUserLoginByEmail(String email) {
      
        return userLoginRepository.findUserLoginByEmail(email);
    }

    @Override
    @Transactional
    public void saveUserLogin(UserLogin userLogin) {
        userLoginRepository.save(userLogin);
        
    }

    @Override
    @Transactional
    public Role findRoleByName(String name) {
        
        return roleRepository.findByName(name);
    }

    @Override
    @Transactional
    public List<Brand> findBrandByType(String type) {
       
        return brandRepository.findByType(type);
    }

    @Override
    @Transactional
    public Brand findBrandByNameAndType(String name, String type) {
        
        return brandRepository.findByNameAndType(name, type);
    }

    




   

    // @Override
    // @Transactional
    // public int getCountByProductType(char type) {
     
    //     return productRepository.getCountByProductType(type);
    // }
    
}
