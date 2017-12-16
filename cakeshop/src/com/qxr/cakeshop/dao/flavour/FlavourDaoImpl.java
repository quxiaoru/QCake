package com.qxr.cakeshop.dao.flavour;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Flavour;

@Repository
public class FlavourDaoImpl implements FlavourDao{
	
	@Resource
	private SessionFactory session;
	
	public Session getSession() {
		return session.getCurrentSession();
	}
	public void saveFlavour(Flavour flavour) throws SQLException{
		System.out.println(flavour.getFlavourName());
		session.getCurrentSession().save(flavour);
		session.getCurrentSession().flush();
	}
	@Override
	public List<Flavour> getFlavour() throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("2222222");
		String hql = "from Flavour";
		Query query = getSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Flavour> list = query.list();	
		System.out.println("11111111111111111");
		for(Flavour f:list) {
			System.out.println(f.getFlavourName());
		}
		return  list;
	}
}
