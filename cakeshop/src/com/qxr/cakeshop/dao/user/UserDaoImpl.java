package com.qxr.cakeshop.dao.user;


import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.User;
@Repository
public class UserDaoImpl implements UserDao{
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	public User isLogin(String username,String password) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "from User u where u.username =? and u.password=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		User user = (User)query.uniqueResult();
		return user;
	}
	@Override
	public User addUser(String username, String password, String address) throws SQLException{
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		getSession().save(user);
		getSession().flush();
		return user;
	}

}
