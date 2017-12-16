package com.qxr.cakeshop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Orders {

	private int id;
	private int count;
	private int cakeId;
	private int sizeId;
	private int userId;
	private int price;
	private Cake cake;
	private Size size;
	private String ordertime;
	private String ordertime1;
    @Id
    @GeneratedValue(generator="my")
	@GenericGenerator(name="my",strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCakeId() {
		return cakeId;
	}
	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@ManyToOne()
	@JoinColumn(name="cakeId",insertable = false, updatable = false)
	public Cake getCake() {
		return cake;
	}
	public void setCake(Cake cake) {
		this.cake = cake;
	}
	@ManyToOne()
	@JoinColumn(name="sizeId",insertable = false, updatable = false)
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public String getOrdertime1() {
		return ordertime1;
	}
	public void setOrdertime1(String ordertime1) {
		this.ordertime1 = ordertime1;
	}
	
}
