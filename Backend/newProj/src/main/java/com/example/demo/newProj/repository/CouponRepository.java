package com.example.demo.newProj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.newProj.model.Coupon;

public interface CouponRepository extends MongoRepository<Coupon, String> {
	@Query("{code: ?0}")
	List<Coupon> getByCode(String code);
}
