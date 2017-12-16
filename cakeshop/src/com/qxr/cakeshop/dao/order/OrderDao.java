package com.qxr.cakeshop.dao.order;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Orders;

public interface OrderDao {
	public void addOrder(Orders order) throws SQLException;
	public List<Orders> findOrderByUserId(int userId) throws SQLException;
	public boolean isDeleteOrders(int orderId) throws SQLException;
}
