package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name="apitoken")
	private long apitoken;
	
	@Column(name="username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private long phone_number;
	
//	@OneToOne
//	private Purchase purchase;
	
	
//	public Purchase getPurchase() {
//	return purchase;}
//	public void setPurchase(Purchase purchase) {
//	this.purchase = purchase;}
	
public long getApitoken() {
		return apitoken;}
	public void setApitoken(long apitoken) {
		this.apitoken = apitoken;}

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
	
		
	
	
	
	
}

