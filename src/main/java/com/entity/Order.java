package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue
    private Long oid;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;

    private double totalPrice;

    private String paymentStatus; 
    private String paymentId;
	public Order() {
		super();
	}
	public Order(Long oid, User user, List<Product> products, double totalPrice, String paymentStatus,
			String paymentId) {
		super();
		this.oid = oid;
		this.user = user;
		this.products = products;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
		this.paymentId = paymentId;
	}
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
    

}
