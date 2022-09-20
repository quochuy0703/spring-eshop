package com.huymq.springeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.huymq.springeshop.utils.CheckoutForm;

@Entity
@Table(name="address_order")
public class OrderAddress {
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

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="zip_code")
    private String zipCode;

  

    @Override
    public String toString() {
        return "OrderAddress [address=" + address + ", city=" + city + ", country=" + country + ", email=" + email
                + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", phone=" + phone + ", state="
                + state + ", zipCode=" + zipCode + "]";
    }

    public OrderAddress() {
    }


    public OrderAddress(CheckoutForm checkoutForm){
        
        this.firstName= checkoutForm.getFirstName();
        this.lastName= checkoutForm.getLastName();
        this.email= checkoutForm.getEmail();
        this.phone= checkoutForm.getPhone();
        this.address= checkoutForm.getAddress();
        this.city= checkoutForm.getCity();
        this.state= checkoutForm.getPhone();
        this.country= checkoutForm.getCountry();
        this.zipCode= checkoutForm.getZipCode();
        
        
    }
    public int getId() {
        return id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }




}
