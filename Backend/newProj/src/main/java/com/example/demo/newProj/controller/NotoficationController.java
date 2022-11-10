package com.example.demo.newProj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.newProj.model.Notification;
import com.example.demo.newProj.repository.NotificationRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/api")
public class NotoficationController {
 @Autowired
 private NotificationRepository notiRepo;
 @PostMapping("/notification/add")
 public ResponseEntity<Notification> addNotification(@RequestBody Notification data){
	 Notification ans=notiRepo.save(new Notification(data.getUserid(),data.getOrderid(),data.getDescription(),data.getDate()));
	 return new ResponseEntity<>(ans,HttpStatus.OK);
 }
 @GetMapping("/notification/get/{userid}")
 public ResponseEntity<List<Notification>> getNotification(@PathVariable String userid){
	 List<Notification> ans=notiRepo.findByUserId(userid);
	 return new ResponseEntity<>(ans,HttpStatus.OK);
 }
 @DeleteMapping("/notification/delete/{id}")
 public ResponseEntity<Notification> deleteNotification(@PathVariable String id){
	 System.out.println(id);
	 notiRepo.deleteById(id);
	 return new ResponseEntity<>(HttpStatus.OK);
 }
}
