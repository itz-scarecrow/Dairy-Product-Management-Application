package com.example.demo.newProj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.newProj.model.Cart;

public interface CartRepositary extends MongoRepository<Cart, String> {
	
	@Query("{userId: ?0}")
	List<Cart> findByUserId(String userid);
}
