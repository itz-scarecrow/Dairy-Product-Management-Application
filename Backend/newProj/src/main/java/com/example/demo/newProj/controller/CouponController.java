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

import com.example.demo.newProj.model.Coupon;
import com.example.demo.newProj.repository.CouponRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/api")
public class CouponController {
	@Autowired 
	private CouponRepository couponRepo;
	@PostMapping("/coupon/add")
	public ResponseEntity<Coupon> addNewCoupon(@RequestBody Coupon coupon){
		Coupon res= couponRepo.save(new Coupon(coupon.getCode(),coupon.getDiscount()));
		System.out.println(res.getId());
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@GetMapping("/coupon/{code}")
	public ResponseEntity<List<Coupon>> getCouponByName(@PathVariable String code){
		List<Coupon>res=couponRepo.getByCode(code);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@GetMapping("/coupon/get")
	public ResponseEntity<List<Coupon>> getCouponByName(){
		List<Coupon>res=couponRepo.findAll();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@PutMapping("/coupon/edit/{id}")
	public ResponseEntity<Coupon> editCoupon(@PathVariable String id, @RequestBody Coupon coupon){
		Optional<Coupon> ans=couponRepo.findById(id);
		if(ans.isPresent()) {
			Coupon temp=ans.get();
			temp.setCode(coupon.getCode());
			temp.setDiscount(coupon.getDiscount());
			Coupon res=couponRepo.save(temp);
			return  new ResponseEntity<>(res,HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/coupon/delete/{id}")
	public ResponseEntity<Coupon> deleteCoupon(@PathVariable String id){
		couponRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
