package com.qxr.cakeshop.service.user;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.user.UserDao;
import com.qxr.cakeshop.entity.User;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	@Override
	public User isLogin(String username,String password) throws SQLException{
		// TODO Auto-generated method stub
		if(userDao.isLogin(username,password) == null) {
			return null;
		}else {
			return userDao.isLogin(username,password);
		}
	}
	@Override
	public User addUser(String username, String password, String address) throws SQLException{
		// TODO Auto-generated method stub
		User user = userDao.addUser(username, password, address);
		return user;
	}

}
