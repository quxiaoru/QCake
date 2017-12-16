package com.qxr.cakeshop.entity;




import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="size")
public class Size {
	private int id;
	private int size;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
