package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.model.Purchase;
import com.ecommerce.model.User;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.PurchaseRepository;
import com.ecommerce.repository.UserRepository;




@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	PurchaseRepository purchaserepository;
	//============Change Password========
	
	@PutMapping("{token}/resetpassword")
	public User changePassword(@RequestBody User user, @PathVariable long token) {
		Optional<User> usercheck = userrepository.findById(token);
		User tempuser = usercheck.get();
		tempuser.setPassword(user.getPassword());
		return  userrepository.save(tempuser);
	}
	
	
	//============User==============
	@GetMapping("{token}/allusers")
	public List<User> getAllUser(@PathVariable long token) throws Exception {
		Optional<User> usercheck = userrepository.findById(token);
		User tempuser = usercheck.get();
		if (tempuser.getUsername().equals("admin")) {
			List<User> userslist = (List<User>) userrepository.findAll();
			return userslist;
		}
		else {
			throw new Exception("Cannot get all users - Not admin");
			
		}
	}
	
	@PostMapping("add")
	public User addUser(@RequestBody User user) {
		double randomnum = Math.random();
		long apitoken = (long)(Math.floor(randomnum*Math.pow(10, 16)));
		Optional<User> usercheck= userrepository.findById(apitoken);
		while (usercheck.isPresent()){
			randomnum = Math.random();
			apitoken = (long)(Math.floor(randomnum*Math.pow(10, 16)));
			usercheck=userrepository.findById(apitoken);
			System.out.println(apitoken);
			System.out.println(usercheck);

		}
		user.setApitoken(apitoken);
		return userrepository.save(user);	
	}
	
	@GetMapping("{token}")
	public Optional<User> findUser(@PathVariable long token) {
		return userrepository.findById(token);
	}
	
	//===========Product=================
	
	@PostMapping("{token}/product/add")
	public Product addProduct(@RequestBody Product product, @PathVariable long token) throws Exception {
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		String username = user.getUsername();
		
		if (username.equals("admin")) {
			return productrepository.save(product);
		}
		else {
			throw new Exception("Cannot add product - Not Admin"); 
		}
		
		 
	}
	
	@GetMapping("{token}/product/all")
	public List<Product> getAllProduct(@PathVariable long token) throws Exception {
		
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		String username = user.getUsername();
		
		if (username.equals("admin")) {
			List<Product> product = (List<Product>) productrepository.findAll();
			return product;
		}
		else {
			throw new Exception("Only admin can read all product");
		}
		
	}
	//Update products
	@PutMapping("{token}/product/update/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable long token, @PathVariable int id) throws Exception {
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		String username = user.getUsername();
		
		if (username.equals("admin")) {
			
			Optional<Product> productfind = productrepository.findById(id);
			if (productfind.isPresent()){
				Product tempproduct = productfind.get();
				tempproduct.setBrand(product.getBrand());
				tempproduct.setCategory(product.getCategory());
				tempproduct.setColor(product.getColor());
				tempproduct.setCreateddate(product.getCreateddate());
				tempproduct.setDiscount(product.getDiscount());
				tempproduct.setPrice(product.getPrice());
				tempproduct.setSeason(product.getSeason());
				
				
				return productrepository.save(tempproduct);
			}
			else {
				throw new Exception("Cannot update product - Product does not exist");
			}
			
		}
		else {
			throw new Exception("Cannot update product - Not Admin");
		}
	}
	
	//Delete products
	@DeleteMapping("{token}/product/delete/{id}")
	public void deleteProduct(@PathVariable int id,@PathVariable long token) throws Exception {
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		String username = user.getUsername();
		
		if (username.equals("admin")) {
			productrepository.deleteById(id);
		}
		else {
			throw new Exception("Cannot delete product - Not Admin"); 
		}
		
	}
	
	//==========Purchase===========
	@GetMapping("{token}/purchase/{id}")
	public Purchase userBuyProduct(@PathVariable long token, @PathVariable int id) throws Exception {
		Optional<Product> productcheck = productrepository.findById(id);
		Optional<User> usercheck = userrepository.findById(token);
		
		if (productcheck != null && usercheck != null) {
			Product tempproduct = productcheck.get();
			User tempuser = usercheck.get();			
			Purchase temppurchase = new Purchase();
			temppurchase.setCategory(tempproduct.getCategory());
			temppurchase.setProduct(tempproduct);
			temppurchase.setPurchasedate(java.time.LocalDateTime.now());
			temppurchase.setUser(tempuser);
			return purchaserepository.save(temppurchase);
			
		}
		else {
			throw new Exception("Product or User does not exist!");
		}
	}

	@GetMapping("{token}/purchase/all/date/ascending")
	public List<Purchase> getPurchaseDateAscending(@PathVariable long token) throws Exception{
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		
		if (user.getUsername().equals("admin")) {
			return purchaserepository.findByOrderByPurchasedateAsc();
		}
		else {
			throw new Exception("Cannot get purchases - Not admin");
		}
	}
	
	
	@GetMapping("{token}/purchase/all/date/descending")
	public List<Purchase> getPurchaseDateDescending(@PathVariable long token) throws Exception{
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		
		if (user.getUsername().equals("admin")) {
			return purchaserepository.findByOrderByPurchasedateDesc();
		}
		else {
			throw new Exception("Cannot get purchases - Not admin");
		}
	}
	
	@GetMapping("{token}/purchase/all/category/ascending")
	public List<Purchase> getPurchaseCategoryAscending(@PathVariable long token) throws Exception{
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		
		if (user.getUsername().equals("admin")) {
			return purchaserepository.findByOrderByCategoryAsc();
		}
		else {
			throw new Exception("Cannot get purchases - Not admin");
		}
	}
	@GetMapping("{token}/purchase/all/category/descending")
	public List<Purchase> getPurchaseCategoryDescending(@PathVariable long token) throws Exception{
		Optional<User> admincheck = userrepository.findById(token);
		User user = admincheck.get();
		
		if (user.getUsername().equals("admin")) {
			return purchaserepository.findByOrderByCategoryDesc();
		}
		else {
			throw new Exception("Cannot get purchases - Not admin");
		}
	}
	
}

