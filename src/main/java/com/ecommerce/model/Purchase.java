package com.ecommerce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="purchaseid")
	private int puchaseid;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usertoken",referencedColumnName="apitoken")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productid",referencedColumnName="productid")
	private Product product;
	
	@Column(name="purchasedate")
	private LocalDateTime purchasedate;
		
	@Column(name="category")
	private String category;

	public int getPuchaseid() {
	return puchaseid;}
	
	public void setPuchaseid(int puchaseid) {
	this.puchaseid = puchaseid;}
	
	public User getUser() {
	return user;}
	
	public void setUser(User user) {
	this.user = user;}
	
	public Product getProduct() {
	return product;}
	
	public void setProduct(Product product) {
	this.product = product;}
	
	public LocalDateTime getPurchasedate() {
	return purchasedate;}
	
	public void setPurchasedate(LocalDateTime localDateTime) {
	this.purchasedate = localDateTime;}
	
	public String getCategory() {
	return category;}
	
	public void setCategory(String category) {
	this.category = category;}
			

}

