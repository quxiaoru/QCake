package com.qxr.cakeshop.dao.type;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Type;
@Repository
public class TypeDaoImpl implements TypeDao{
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Type> getParentType() throws SQLException{
		// TODO Auto-generated method stub
		List<Type> types  = null;
		String hql = "from Type";
		Query query = getSession().createQuery(hql);
		types = query.list();
		return types;
	}

}
