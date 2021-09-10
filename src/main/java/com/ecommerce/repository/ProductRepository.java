package com.ecommerce.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public List<Product> findProductBySeason(String season);
	public List<Product> findProductByBrand(String brand);
	public List<Product> findProductByCategory(String category);
	public List<Product> findProductByPrice(float price);
	public List<Product> findByOrderByPriceAsc();
	public List<Product> findByOrderByPriceDesc();
	public List<Product> findProductByColor(String color);
	public List<Product> findProductByCreateddate(Date createddate);
	public List<Product> findByOrderByCreateddateAsc();
	public List<Product> findByOrderByCreateddateDesc();
}

