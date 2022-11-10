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

import com.example.demo.newProj.model.Product;
import com.example.demo.newProj.repository.productRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/api")
public class ProductController {
 @Autowired
 private productRepository ProductRepo;
 
 @PostMapping("/products/add")
 public ResponseEntity<Product> addNewItems( @RequestBody Product item){
	 Product res=ProductRepo.save(new Product(item.getImageValue(),item.getImageUrl(),item.getProductName(),item.getBrandName(),item.getPrice(),item.getSaleStatus(),item.getSaleValue(),item.getDiscountedPrice(),item.getRating(),item.getProductStatus(),item.getDescription(),item.getCategory()));
	 return new ResponseEntity<> (res,HttpStatus.CREATED);
 }
 @GetMapping("/products/get")
 public ResponseEntity<List<Product>> getAllItems(){
	 List<Product> res=ProductRepo.findAll();
	 return new ResponseEntity<> (res,HttpStatus.ACCEPTED);
 }
 @PutMapping("/products/update/{id}")
 public ResponseEntity<Product> editItem(@PathVariable String id,@RequestBody Product item){
	 Optional<Product> res=ProductRepo.findById(id);
	 if(res.isPresent()) {
	 	Product newProd=res.get();
	 	newProd.setImageValue(item.getImageValue());
		newProd.setImageUrl(item.getImageUrl());
		newProd.setProductName(item.getProductName());
		newProd.setBrandName(item.getBrandName());
		newProd.setPrice(item.getPrice());
		newProd.setSaleStatus(item.getSaleStatus());
		newProd.setSaleValue(item.getSaleValue());
		newProd.setDiscountedPrice(item.getDiscountedPrice());
		newProd.setRating(item.getRating());
		newProd.setProductStatus(item.getProductStatus());
		newProd.setDescription(item.getDescription());
		newProd.setCategory(item.getCategory());
		System.out.println(newProd);
		Product ans=ProductRepo.save(newProd);
		return new ResponseEntity<> (ans,HttpStatus.OK); 
	 }
	 else {
		 return new ResponseEntity<> (HttpStatus.NOT_FOUND); 
	 }
 	}
 @DeleteMapping("/products/delete/{id}")
 public ResponseEntity<String> deleteItem(@PathVariable String id){
	 ProductRepo.deleteById(id);
	 return new ResponseEntity<> (HttpStatus.OK);
 }
 @GetMapping("/products/latest")
 public ResponseEntity<List<Product>> getLatestProducts(){
	 List<Product> res=ProductRepo.findByProductStatus("Latest");
	 return new ResponseEntity<> (res,HttpStatus.OK);
 }
 @GetMapping("/product/{id}")
 public ResponseEntity<Product> getById(@PathVariable String id){
	 System.out.println(id);
	 Optional<Product> ans=ProductRepo.findById(id);
	 if(ans.isPresent()) {
		 Product res=ans.get();
		 System.out.println(res.getBrandName());
		 return new ResponseEntity<>(res,HttpStatus.OK);
	 }
	 else {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
 }
 @GetMapping("/product/bySaleStatus")
 public ResponseEntity<List<Product>> getBySaleStatus(){
	 List<Product> res=ProductRepo.findBySale("On Sale");
	 System.out.println(res);
	 return new ResponseEntity<>(res,HttpStatus.OK);
 }
}
