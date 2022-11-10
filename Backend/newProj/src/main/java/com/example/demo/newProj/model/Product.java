package com.example.demo.newProj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Products")
public class Product {
	@Id
	private String id;
	@Field(name="imageValue")
	private String imageValue;
	@Field(name="imageUrl")
	private String imageUrl;
	@Field(name="productNmae")
	private String productName;
	@Field(name="brandName")
	private String brandName;
	@Field(name="price")
	private float price;
	@Field(name="saleStatus")
	private String saleStatus;
	@Field(name="saleValue")
	private float saleValue;
	@Field(name="discountedPrice")
	private float discountedPrice;
	@Field(name="rating")
	private String rating;
	@Field(name="productStatus")
	private String productStatus;
	@Field(name="description")
	private String description;
	@Field(name="category")
	private String category;
	public Product() {
		
	}
	
	public Product(String imageValue, String imageUrl, String productName, String brandName, float price,
			String saleStatus, float saleValue, float discountedPrice, String rating, String productStatus,
			String description, String category) {
		super();
		this.imageValue = imageValue;
		this.imageUrl = imageUrl;
		this.productName = productName;
		this.brandName = brandName;
		this.price = price;
		this.saleStatus = saleStatus;
		this.saleValue = saleValue;
		this.discountedPrice = discountedPrice;
		this.rating = rating;
		this.productStatus = productStatus;
		this.description = description;
		this.category = category;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImageValue() {
		return imageValue;
	}
	public void setImageValue(String imageValue) {
		this.imageValue = imageValue;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}
	public float getSaleValue() {
		return saleValue;
	}
	public void setSaleValue(float saleValue) {
		this.saleValue = saleValue;
	}
	public float getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
