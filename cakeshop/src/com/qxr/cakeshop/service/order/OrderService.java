package com.qxr.cakeshop.service.order;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Orders;

public interface OrderService {
	public void addOrder(int cartId) throws SQLException;
	public List<Orders> findOrderByUserId(int userId) throws SQLException;
	public boolean isDeleteOrders(int orderId) throws SQLException;
}
