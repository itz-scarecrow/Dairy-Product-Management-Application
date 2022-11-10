package com.example.demo.newProj.repository;


import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.newProj.model.Product;

public interface productRepository extends MongoRepository<Product, String> {
	@Query("{productStatus: ?0}")
	List<Product> findByProductStatus(String productStatus);
	@Query("{saleStatus: ?0}")
	List<Product> findBySale(String status);
}
