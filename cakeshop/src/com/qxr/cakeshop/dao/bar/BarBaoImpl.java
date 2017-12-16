package com.qxr.cakeshop.dao.bar;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Bar;
@Repository
public class BarBaoImpl implements BarDao{
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	@Override
	public List<Bar> getBar() throws SQLException{
		// TODO Auto-generated method stub
		String hql = "from Bar";
		Query query = getSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Bar> bars = query.list();	
		for(Bar b:bars) {
			System.out.println(b.getBarName());
		}
		return bars;
	}
	
}
