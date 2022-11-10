package com.example.demo.newProj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Cart")
public class Cart {
	@Id
	private String id;
	@Field(name="userId")
	private String userId;
	@Field(name="iamgeUrl")
	private String imageUrl;
	@Field(name="quantity")
	private int quantity;
	@Field(name="price")
	private float price;
	@Field(name="category")
	private String category;
	@Field(name="brandname")
	private String brandName;
	@Field(name="productname")
	private String productname;
	public Cart() {
		
	}
	public Cart(String userId, String imageUrl, int quantity, float price, String category, String brandName,
			String productname) {
		super();
		this.userId = userId;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.brandName = brandName;
		this.productname = productname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
}
