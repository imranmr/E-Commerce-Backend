package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userID")
	private int userID;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private long phone_number;
	
	public int getUserID() {
	return userID;}
	public void setUserID(int userID) {
	this.userID = userID;}
	public String getUsername() {
	return username;}
	public void setUsername(String username) {
	this.username = username;}
	public String getPassword() {
	return password;}
	public void setPassword(String password) {
	this.password = password;}
	public String getEmail() {
	return email;}
	public void setEmail(String email) {
	this.email = email;}
	public long getPhone_number() {
	return phone_number;}
	public void setPhone_number(long phone_number) {
	this.phone_number = phone_number;}
	private String username;
		
	
	
	
	
}

