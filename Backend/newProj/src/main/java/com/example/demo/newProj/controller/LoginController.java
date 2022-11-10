package com.example.demo.newProj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.newProj.model.Login;
import com.example.demo.newProj.repository.LoginRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/api")
public class LoginController {
 @Autowired
 private LoginRepository loginRepo;
 
 	@PostMapping("/register")
 	public ResponseEntity<List<Login>> register(@RequestBody Login login)
 	{	
 		Login loginDetails = loginRepo.save(new Login(login.getUsername(), login.getEmail(), login.getPassword(), login.getRoles()));
 		List<Login> arr=new ArrayList<>();
 		arr.add(loginDetails);
 		return new ResponseEntity<> (arr,HttpStatus.CREATED);
 	}
 	@GetMapping("/verify/{email}/{roles}")
 	public ResponseEntity<List<Login>> verify(@PathVariable String email,@PathVariable String roles){
 		List<Login> arr= loginRepo.findByEmailAndRoles(email,roles);
 		return ResponseEntity.ok(arr);
 	}
 	@GetMapping("/get/{id}")
 	public ResponseEntity<Login> getById(@PathVariable String id){
 		Optional<Login> res=loginRepo.findById(id);
 		if(res.isPresent()) {
 			return new ResponseEntity<>(res.get(),HttpStatus.OK);
 		}
 		else {
 			return new ResponseEntity<>(res.get(),HttpStatus.NOT_FOUND);
 		}
 		
 	}
}
