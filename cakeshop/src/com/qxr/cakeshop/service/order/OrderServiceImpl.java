package com.qxr.cakeshop.service.order;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.cart.CartDao;
import com.qxr.cakeshop.dao.order.OrderDao;
import com.qxr.cakeshop.entity.Cart;
import com.qxr.cakeshop.entity.Orders;
@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private CartDao cartDao;
	@Override
	public void addOrder(int cartId) throws SQLException{
		// TODO Auto-generated method stub
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = new Date();
		String today =  formatter.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		Date date1 = c.getTime();
		String tomorrow =  formatter.format(date1);
		Cart cart = cartDao.findCartById(cartId);
		Orders order = new Orders();
		order.setCakeId(cart.getCakeId());
		order.setCount(cart.getCount());
		order.setOrdertime(today);
		order.setOrdertime1(tomorrow);
		order.setPrice(cart.getPrice());
		order.setSizeId(cart.getSizeId());
		order.setUserId(cart.getUserId());
		orderDao.addOrder(order);
	}
	public List<Orders> findOrderByUserId(int userId)throws SQLException{
		return orderDao.findOrderByUserId(userId);
	}
	public boolean isDeleteOrders(int orderId) throws SQLException{
		return orderDao.isDeleteOrders(orderId);
	}

}
