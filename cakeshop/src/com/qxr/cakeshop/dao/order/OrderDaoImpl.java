package com.qxr.cakeshop.dao.order;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Flavour;
import com.qxr.cakeshop.entity.Orders;
@Repository
public class OrderDaoImpl implements OrderDao{
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	public void addOrder(Orders order) throws SQLException{
		getSession().save(order);
		getSession().flush();
	}
	public List<Orders> findOrderByUserId(int userId) throws SQLException{
		String hql = "from Orders o where o.userId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userId);
		@SuppressWarnings("unchecked")
		List<Orders> orders = query.list();	
		return orders;
	}
	public boolean isDeleteOrders(int orderId) throws SQLException{
		String hql = "delete from Orders o where o.id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, orderId);
		int i = query.executeUpdate();
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
}
