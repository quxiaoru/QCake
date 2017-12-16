package com.qxr.cakeshop.service.cart;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Cart;

public interface CartService {
	public void insertCart(int userId,int cakeId,int count,int sizeId) throws SQLException;
	public List<Cart> findCartByUserId(int userId) throws SQLException;
	public Cart findCartById(int cartId) throws SQLException;
	public int findPrice(int cakeId,int sizeId) throws SQLException;
	public void deleteCart(int cartId) throws SQLException;
	public void addCount(int cartId) throws SQLException;
	public void deleteCount(int cartId) throws SQLException;
}
