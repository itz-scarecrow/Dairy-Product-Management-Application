package com.example.demo.newProj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Orders")
public class Order {
	@Id
	private String id;
	@Field(name="orderId")
	private String orderId;
	@Field(name="userid")
	private String userid;
	@Field(name="username")
	private String username;
	@Field(name="orders")
	private Cart[] orders;
	@Field (name="totalprice")
	private float totalprice;
	@Field(name="paymentStatus")
	private String paymentStatus;
	@Field(name="orderStatus")
	private String orderStatus;
	@Field(name="date")
	private String date;
	@Field(name="dispatchdate")
	private String dispatchdate;
	@Field(name="deliverydate")
	private String deliverydate;
	@Field(name="delivery")
	private float delivery;
	@Field(name="discount")
	private float discount;
	public Order(String orderId, String userid, String username, Cart[] orders, float totalprice, String paymentStatus,
			String orderStatus, String date, String dispatchdate, String deliverydate, float delivery, float discount) {
		super();
		this.orderId = orderId;
		this.userid = userid;
		this.username = username;
		this.orders = orders;
		this.totalprice = totalprice;
		this.paymentStatus = paymentStatus;
		this.orderStatus = orderStatus;
		this.date = date;
		this.dispatchdate = dispatchdate;
		this.deliverydate = deliverydate;
		this.delivery = delivery;
		this.discount = discount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Cart[] getOrders() {
		return orders;
	}
	public void setOrders(Cart[] orders) {
		this.orders = orders;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDispatchdate() {
		return dispatchdate;
	}
	public void setDispatchdate(String dispatchdate) {
		this.dispatchdate = dispatchdate;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	public float getDelivery() {
		return delivery;
	}
	public void setDelivery(float delivery) {
		this.delivery = delivery;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	


}
