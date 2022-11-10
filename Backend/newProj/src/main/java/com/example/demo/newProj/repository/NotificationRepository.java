package com.example.demo.newProj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.newProj.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
	@Query("{userid:?0}")
	List<Notification> findByUserId(String userid);
}
