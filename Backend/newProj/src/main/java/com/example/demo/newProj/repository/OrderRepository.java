package com.example.demo.newProj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.newProj.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
	@Query("{userid: ?0}")
	List<Order> getOrdersByUserId(String userid);
	@Query("{orderStatus: ?0}")
	List<Order> findByStatus(String status);
}
