package com.example.demo.newProj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.newProj.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String>{
	
}
