package com.qxr.cakeshop.dao.cart;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Cart;
@Repository
public class CartDaoImpl implements CartDao {
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	
	@Override
	public void insertCart(int userId, int cakeId, int count,int sizeId) throws SQLException{
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		String hql = "select sc.price from Sc sc where sc.cakeId=? and sc.sizeId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cakeId);
		query.setParameter(1, sizeId);
		List<Integer> price = query.list();
		cart.setSizeId(sizeId);
		cart.setCakeId(cakeId);
		cart.setCount(count);
		cart.setUserId(userId);
		cart.setPrice(price.get(0).intValue());
		getSession().save(cart);
		getSession().flush();
	}

	@Override
	public List<Cart> findCartByUserId(int userId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "from Cart c where c.userId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, userId);
		@SuppressWarnings("unchecked")
		List<Cart> carts = query.list();
		return carts;
	}
	public int findPrice(int cakeId,int sizeId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "select sc.price from Sc sc where sc.cakeId=? and sc.sizeId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cakeId);
		query.setParameter(1, sizeId);
		int price = (int)query.uniqueResult();
		return price;
	}

	@Override
	public void deleteCart(int cartId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "delete from Cart where id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cartId);
		query.executeUpdate();
	}

	@Override
	public void addCount(int cartId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "update Cart c set c.count=c.count+1 where id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cartId);
		query.executeUpdate();
	}
	public void deleteCount(int cartId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "update Cart c set c.count=c.count-1 where id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cartId);
		query.executeUpdate();
	}
	public Cart findCartById(int cartId) throws SQLException{
		Cart cart = (Cart)getSession().get(Cart.class, cartId);
		return cart;
	}
	
}
