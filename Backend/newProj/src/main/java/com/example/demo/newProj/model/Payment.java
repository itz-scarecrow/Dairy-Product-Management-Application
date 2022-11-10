package com.example.demo.newProj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "payment")
public class Payment {
	@Id
	private String id;
	@Field
	private String userid;
	@Field
	private String paymentid;
	@Field
	private String username;
	@Field
	private String paymentmode;
	@Field
	private String paymentstatus;
	@Field
	private float totalPrice;
	public Payment(String userid, String paymentid, String username, String paymentmode, String paymentstatus, float totalPrice) {
		this.userid = userid;
		this.paymentid = paymentid;
		this.username = username;
		this.paymentmode = paymentmode;
		this.paymentstatus = paymentstatus;
		this.totalPrice = totalPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
}
