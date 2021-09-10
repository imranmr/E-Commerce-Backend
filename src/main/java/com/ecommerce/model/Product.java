package com.ecommerce.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid")
	private int productid;
	
	@Column(name = "season")
	private String season;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "color")
	private String color;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "discount")
	private int discount;
//	
//	@OneToOne
//	private Purchase purchase;
	
	public int getProductid() {
return productid;}

public void setProductid(int productid) {
this.productid = productid;}

public String getSeason() {
return season;}

public void setSeason(String season) {
this.season = season;}

public String getBrand() {
return brand;}

public void setBrand(String brand) {
this.brand = brand;}

public String getCategory() {
return category;}

public void setCategory(String category) {
this.category = category;}

public float getPrice() {
return price;}

public void setPrice(float price) {
this.price = price;}

public String getColor() {
return color;}

public void setColor(String color) {
this.color = color;}

public Date getCreateddate() {
return createddate;}

public void setCreateddate(Date createddate) {
this.createddate = createddate;}

public int getDiscount() {
return discount;}

public void setDiscount(int discount) {
this.discount = discount;}



//public Purchase getPurchase() {
//return purchase;}
//
//public void setPurchase(Purchase purchase) {
//this.purchase = purchase;}
//	
	


	
	
}

