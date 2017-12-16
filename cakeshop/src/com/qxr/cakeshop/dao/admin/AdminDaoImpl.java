package com.qxr.cakeshop.dao.admin;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	public boolean isLogin(String adminName,String adminPassword) throws SQLException{
		String hql = "from Admin a where a.adminname =? and a.password=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, adminName);
		query.setParameter(1, adminPassword);
		Admin admin = (Admin)query.uniqueResult();
		if(admin == null) {
			return false;
		}else {
			return true;
		}		
	}
}
