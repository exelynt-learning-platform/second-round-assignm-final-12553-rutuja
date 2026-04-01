package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long uid;
	String name;
	String address;
	String contactNo;
   String username;
    String password;
     String role;
	 public User() {
		super();
	 }
	 public User(Long uid, String name, String address, String contactNo, String username, String password,
			String role) {
		super();
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.username = username;
		this.password = password;
		this.role = role;
	 }
	 public Long getUid() {
		 return uid;
	 }
	 public void setUid(Long uid) {
		 this.uid = uid;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getAddress() {
		 return address;
	 }
	 public void setAddress(String address) {
		 this.address = address;
	 }
	 public String getContactNo() {
		 return contactNo;
	 }
	 public void setContactNo(String contactNo) {
		 this.contactNo = contactNo;
	 }
	 public String getUsername() {
		 return username;
	 }
	 public void setUsername(String username) {
		 this.username = username;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public void setPassword(String password) {
		 this.password = password;
	 }
	 public String getRole() {
		 return role;
	 }
	 public void setRole(String role) {
		 this.role = role;
	 }
	
}
