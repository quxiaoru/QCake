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
/*对应用户表
 * User ： Cart 1：n 双向
 * */
@Entity
@Table(name="user")
public class User {

	  private int id;
	  private String username;
	  private String password;
	  private String address;
	  
	  private Set<Cart> cartSet = new HashSet<Cart>();
	  @Id
	  @GeneratedValue(generator="my")
	  @GenericGenerator(name="my",strategy="increment")
	  public int getId() {
		  return id;
	  }
	  public void setId(int id) {
		  this.id = id;
	  }
	 // @Column(name="username")
	  public String getUsername() {
		  return username;
	  }
	  public void setUsername(String username) {
		  this.username = username;
	  }
	  public String getPassword() {
		  return password;
	  }
	  public void setPassword(String password) {
		  this.password = password;
	  }
	  @OneToMany( targetEntity=Cart.class, 
		        cascade=CascadeType.ALL)
	  public Set<Cart> getCartSet() {
		  return cartSet;
	  }
	  public void setCartSet(Set<Cart> cartSet) {
		  this.cartSet = cartSet;
	  }
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
