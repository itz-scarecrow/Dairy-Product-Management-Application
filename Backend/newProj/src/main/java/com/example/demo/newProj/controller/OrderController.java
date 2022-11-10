package com.example.demo.newProj.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.newProj.model.Order;
import com.example.demo.newProj.repository.OrderRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/api")
public class OrderController {
	@Autowired
 	private OrderRepository orderRepo;
	@PostMapping("/orders/post")
	public ResponseEntity<Order> addOrder(@RequestBody Order order ){
		System.out.println(order.getDelivery());
		System.out.println(order.getDiscount());
		System.out.println(order.getDate());
	Order ans=orderRepo.save(new Order(order.getOrderId(),order.getUserid(),order.getUsername(),order.getOrders(),order.getTotalprice(),order.getPaymentStatus(),order.getOrderStatus(),order.getDate(),order.getDispatchdate(),order.getDeliverydate(), order.getDelivery(),order.getDiscount()));
	return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	@GetMapping("/orders/get/{userid}")
	public ResponseEntity<List<Order>> getOrders(@PathVariable String userid){
		System.out.println(userid);
		List<Order> res=orderRepo.getOrdersByUserId(userid);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@DeleteMapping("/orders/delete/{id}")
	public ResponseEntity<Order> deleteOrders(@PathVariable String id){
		orderRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/orders/getAll")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> res=orderRepo.findAll();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@GetMapping("/orders/getData/{status}")
	public ResponseEntity<List<Order>> getDataByStatus(@PathVariable String status){
		List<Order> res=orderRepo.findByStatus(status);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@PutMapping("/orders/updateOrderStatus/{id}")
	public ResponseEntity<Order> updateStatus(@RequestBody Order order,@PathVariable String id){
		System.out.println(id);
		Optional<Order> res=orderRepo.findById(id);
		if(res.isPresent()) {
			Order ans=res.get();
			ans.setOrderStatus(order.getOrderStatus());
			ans.setDispatchdate(order.getDispatchdate());
			ans.setDeliverydate(order.getDeliverydate());
			Order temp=orderRepo.save(ans);
			return new ResponseEntity<> (temp,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
