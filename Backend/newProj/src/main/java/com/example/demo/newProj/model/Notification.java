package com.example.demo.newProj.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Notifications")
public class Notification {
	@Id
	private String id;
	@Field(name="userid")
	private String userid;
	@Field(name="orderid")
	private String orderid;
	@Field(name="description")
	private String description;
	@Field(name="date")
	private String date;
	
	public Notification(String userid, String orderid, String description, String date) {
		super();
		this.userid = userid;
		this.orderid = orderid;
		this.description = description;
		this.date = date;
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
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
