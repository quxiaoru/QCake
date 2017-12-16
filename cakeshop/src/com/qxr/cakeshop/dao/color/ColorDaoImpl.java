package com.qxr.cakeshop.dao.color;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Color;
@Repository
public class ColorDaoImpl implements ColorDao {
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	@Override
	public List<Color> getColor() throws SQLException{
		// TODO Auto-generated method stub
		String hql = "from Color";
		Query query = getSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Color> colors = query.list();	
		for(Color c:colors) {
			System.out.println(c.getColor());
		}
		return colors;
	}

}
