package com.qxr.cakeshop.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cake")
public class Cake {
	//@Repository
	
	private int id;                
	private String name;              
	private String  infor;               
	private int typeId;            
	private int flavourId;   
	private String color; 
	private int  floor; 
	private String img1; 
	private String img2;
	private String img3;
	private double discounts;
	private int floorPrice;
	private String purpose;
	private Flavour flavour; 
	private Type type;
//	private Set<Cart> carts = new HashSet<Cart>();
	@Id
	@GeneratedValue(generator="my")
	@GenericGenerator(name="my",strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfor() {
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getFlavourId() {
		return flavourId;
	}
	public void setFlavourId(int flavourId) {
		this.flavourId = flavourId;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	@ManyToOne
	@JoinColumn(name="flavourId",insertable = false, updatable = false)
	public Flavour getFlavour() {
		return flavour;
	}
	public void setFlavour(Flavour flavour) {
		this.flavour = flavour;
	}
	@ManyToOne
	@JoinColumn(name="typeId",insertable = false, updatable = false)
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getDiscounts() {
		return discounts;
	}
	public void setDiscounts(double discounts) {
		this.discounts = discounts;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getFloorPrice() {
		return floorPrice;
	}
	public void setFloorPrice(int floorPrice) {
		this.floorPrice = floorPrice;
	}
//	@OneToMany(targetEntity=Cart.class, 
//	        cascade=CascadeType.ALL)
//	public Set<Cart> getCarts() {
//		return carts;
//	}
//	public void setCarts(Set<Cart> carts) {
//		this.carts = carts;
//	}
}
