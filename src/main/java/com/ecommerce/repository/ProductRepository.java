package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {}

