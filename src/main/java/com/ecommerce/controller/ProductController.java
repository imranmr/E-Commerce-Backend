package com.ecommerce.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductRepository productrepository;
	
	@GetMapping("all")
	public List<Product> getAllProduct()
	{
		List<Product> product=(List<Product>) productrepository.findAll(); 
		return product;
	}
	
	
	@GetMapping("{id}")
	public Optional<Product> getProduct(@PathVariable int id){
		return productrepository.findById(id);
	}
	
	@GetMapping("season/{season}")
	public List<Product> getProductSesaon(@PathVariable String season){
		List<Product> products = (List<Product>) productrepository.findProductBySeason(season);
		return products;
	}
	
	@GetMapping("brand/{brand}")
	public List<Product> getProductBrand(@PathVariable String brand){
		List<Product> products = (List<Product>) productrepository.findProductByBrand(brand);
		return products;
	}
	
	
	@GetMapping("category/{category}")
	public List<Product> getProductCategory(@PathVariable String category){
		List<Product> products = (List<Product>) productrepository.findProductByCategory(category);
		return products;
	}
	
	@GetMapping("price/{price}")
	public List<Product> getProductPrice(@PathVariable float price){
		List<Product> products = (List<Product>) productrepository.findProductByPrice(price);
		return products;
	}
	
	@GetMapping("price/ascending")
	public List<Product> getProductPriceAsc(){
		
		List<Product> products = (List<Product>) productrepository.findByOrderByPriceAsc();
		return products;
	}
	
	@GetMapping("price/descending")
	public List<Product> getProductPriceDes(){
		List<Product> products = (List<Product>) productrepository.findByOrderByPriceDesc();
		return products;
	}
	
	@GetMapping("color/{color}")
	public List<Product> getProductColor(@PathVariable String color){
		List<Product> products = (List<Product>) productrepository.findProductByColor(color);
		return products;
	}
	
	@GetMapping("date/{date}")
	public List<Product> getProductDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date){

		List<Product> products = (List<Product>) productrepository.findProductByCreateddate(date);
		System.out.println("Date: "+date);
		return products;
	}
	
	@GetMapping("date/ascending")
	public List<Product> getProductDateAscending(){
		List<Product> products = (List<Product>) productrepository.findByOrderByCreateddateAsc();
		return products;
	}
	
	@GetMapping("date/descending")
	public List<Product> getProductDateDescending(){
		List<Product> products = (List<Product>) productrepository.findByOrderByCreateddateDesc();
		return products;
		
	}
	
	
}

