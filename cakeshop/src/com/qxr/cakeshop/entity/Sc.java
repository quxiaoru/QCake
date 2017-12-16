package com.qxr.cakeshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sc")
public class Sc {
	private int scId;
	private int price;
	private int sizeId;
	private int cakeId;
	private Size size;

	@Id
    @GeneratedValue(generator="my")
	@GenericGenerator(name="my",strategy="increment")
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getCakeId() {
		return cakeId;
	}
	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@ManyToOne
	@JoinColumn(name="sizeId",insertable = false, updatable = false)
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
}
