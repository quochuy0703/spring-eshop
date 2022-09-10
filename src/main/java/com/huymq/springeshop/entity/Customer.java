package com.huymq.springeshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;


    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Address> addresses = new ArrayList<>();


    public void addCart(Cart cart){
        carts.add(cart);
        cart.setCustomer(this);
    }

    public void addOrder(Order order){
        orders.add(order);
        order.setCustomer(this);
    }
    public void addAddress(Address address){
        addresses.add(address);
        address.setCustomer(this);
    }

    
    public int getId() {
        return id;
    }


    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer [email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Cart> getCarts() {
        return carts;
    }


    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    




}
