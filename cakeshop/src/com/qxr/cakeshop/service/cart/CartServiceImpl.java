package com.qxr.cakeshop.service.cart;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.cart.CartDao;
import com.qxr.cakeshop.entity.Cart;

@Service
public class CartServiceImpl implements CartService {
	@Resource
	private CartDao cartDao;
	@Override
	public void insertCart(int userId, int cakeId, int count, int sizeId) throws SQLException{
		// TODO Auto-generated method stub
		cartDao.insertCart(userId, cakeId, count, sizeId);
	}
	@Override
	public List<Cart> findCartByUserId(int userId) throws SQLException{
		// TODO Auto-generated method stub
		
		return cartDao.findCartByUserId(userId);
	}
	@Override
	public int findPrice(int cakeId, int sizeId) throws SQLException{
		// TODO Auto-generated method stub
		return cartDao.findPrice(cakeId, sizeId);
	}
	@Override
	public void deleteCart(int cartId) throws SQLException{
		// TODO Auto-generated method stub
		cartDao.deleteCart(cartId);
	}
	public void addCount(int cartId) throws SQLException{
		cartDao.addCount(cartId);
	}
	public void deleteCount(int cartId) throws SQLException{
		cartDao.deleteCount(cartId);
	}
	public Cart findCartById(int cartId) throws SQLException{
		return cartDao.findCartById(cartId);
	}
}
