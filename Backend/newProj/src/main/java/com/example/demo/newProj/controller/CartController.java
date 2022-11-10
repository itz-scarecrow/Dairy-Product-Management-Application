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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.newProj.model.Cart;
import com.example.demo.newProj.repository.CartRepositary;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/api")
public class CartController {
	@Autowired
	private CartRepositary cartRepo;
	@PostMapping("/cart/add")
	public ResponseEntity<Cart> postNewData(@RequestBody Cart cart){
		Cart data=new Cart(cart.getUserId(),cart.getImageUrl(),cart.getQuantity(),cart.getPrice(),cart.getCategory(),cart.getBrandName(),cart.getProductname());
		Cart ans=cartRepo.save(data);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	@GetMapping("/cart/get/{userid}")
	public ResponseEntity<List<Cart>> getCartData(@PathVariable String userid){
		List<Cart> arr=cartRepo.findByUserId(userid);
		return new ResponseEntity<>(arr,HttpStatus.OK);
	}
	@PostMapping("/chngQuantity/{id}")
	public ResponseEntity<Cart> changeQuantity(@PathVariable String id,@RequestBody int quantity){
		Optional<Cart> data=cartRepo.findById(id);
		System.out.println(id);
		if(data.isPresent()) {
			Cart chg=data.get();
			chg.setQuantity(quantity);
			Cart ans=cartRepo.save(chg);
			return new  ResponseEntity<>(ans,HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Cart> deleteCartData(@PathVariable String id){
		cartRepo.deleteById(id);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
}
