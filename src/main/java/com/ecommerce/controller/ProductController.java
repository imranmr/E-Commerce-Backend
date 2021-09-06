package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}

