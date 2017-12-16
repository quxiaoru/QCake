package com.qxr.cakeshop.dao.cake;


import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Cake;

@Repository
public class CakeDaoImpl implements CakeDao{
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	public void saveCake(Cake c) throws SQLException{
		// TODO Auto-generated method stub
    	getSession().save(c);
    	getSession().flush();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByColor(String color) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.color=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, color);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurpose(String purpose) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByFloor(int floor)  throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.floor=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, floor);
		cakes = query.list();
		return cakes;
	}
	@Override
	public List<Cake> findCakesBySize(int size) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByDiscounts(double discountsMax,double discountsMin) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.discounts between ? and ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, discountsMax);
		query.setParameter(1, discountsMin);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByTypeId(int typeId) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.typeId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, typeId);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByFlavourId(int flavourId) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.flavourId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, flavourId);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPrice(int priceMin, int priceMax) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		System.out.println(priceMin);	
		System.out.println(priceMax);
		String hql = "from Cake c where c.floorPrice between ? and ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, priceMin);
		query.setParameter(1, priceMax);		
		cakes = query.list();
		System.out.println(cakes.get(0).getName());
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> getCakes() throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake";
		Query query = getSession().createQuery(hql);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByName(String name) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println(name);
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.name like ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, "%"+name+"%");
		cakes = query.list();
		System.out.println(cakes.get(0).getName());
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurposeAndPrice(String purpose, int priceMin, int priceMax) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=? and c.floorPrice between ? and ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		query.setParameter(1, priceMin);
		query.setParameter(2, priceMax);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurposeAndColor(String purpose, String color) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=? and c.color=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		query.setParameter(1, color);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurposeAndFloor(String purpose, int floor) throws SQLException{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=? and c.floor=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		query.setParameter(1, floor);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurposeAndDiscounts(String purpose,double discountsMax,double discountsMin) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=? and c.discounts between ? and ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		query.setParameter(1, discountsMax);
		query.setParameter(2, discountsMin);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurposeAndTypeId(String purpose, int typeId) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=? and c.typeId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		query.setParameter(1, typeId);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurposeAndSize(String purpose, int size) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=? and c.size=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		query.setParameter(1, size);
		cakes = query.list();
		return cakes;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cake> findCakesByPurposeAndFlavourId(String purpose, int flavourId) throws SQLException{
		// TODO Auto-generated method stub
		List<Cake> cakes  = null;
		String hql = "from Cake c where c.purpose=? and c.flavourId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, purpose);
		query.setParameter(1, flavourId);
		cakes = query.list();
		return cakes;
	}
	@Override
	public Cake findCakeById(int id) throws SQLException{
		// TODO Auto-generated method stub
		Cake cake = getSession().load(Cake.class, id);
		return cake;
	}
	@Override
	public void updateCake(Cake cake) throws SQLException{
		// TODO Auto-generated method stub
		getSession().update(cake);
		getSession().flush();
	}
	@Override
	public boolean isDeleteCake(int cakeId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "delete from Cake c where c.id=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cakeId);
		if(query.executeUpdate()>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int getPages() throws SQLException{
		// TODO Auto-generated method stub
		String hql = "select count(id) from Cake";
		Query query = getSession().createQuery(hql);
		Long pages = (Long)query.uniqueResult();
		int i = pages.intValue();
		System.out.println(pages);
		return i;
	}
}
