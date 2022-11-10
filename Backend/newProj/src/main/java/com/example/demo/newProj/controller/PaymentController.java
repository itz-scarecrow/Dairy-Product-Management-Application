package com.example.demo.newProj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.newProj.model.Payment;
import com.example.demo.newProj.repository.PaymentRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/api")
public class PaymentController {
	@Autowired
	private PaymentRepository paymentrepo;
	
	@PostMapping("/payment/add")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment res)
	{
		Payment ans = paymentrepo.save(new Payment(res.getUserid(), res.getPaymentid(), res.getUsername(),res.getPaymentmode(), res.getPaymentstatus(), res.getTotalPrice()));
		return new ResponseEntity<>(ans, HttpStatus.OK);
	}
	@GetMapping("/payment/get")
	public ResponseEntity<List<Payment>> getPayment()
	{
		List<Payment> ans = paymentrepo.findAll();
		return new ResponseEntity<>(ans, HttpStatus.OK);
	}
}
