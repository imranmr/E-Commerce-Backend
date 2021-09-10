package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
	public List<Purchase> findByOrderByPurchasedateAsc();
	public List<Purchase> findByOrderByPurchasedateDesc();
	public List<Purchase> findByOrderByCategoryAsc();
	public List<Purchase> findByOrderByCategoryDesc();
}

