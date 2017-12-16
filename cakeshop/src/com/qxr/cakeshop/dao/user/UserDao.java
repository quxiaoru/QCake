package com.qxr.cakeshop.dao.user;

import java.sql.SQLException;

import com.qxr.cakeshop.entity.User;

public interface UserDao{
	//判断用户名与密码是否匹配
	public User isLogin(String username,String password) throws SQLException;
	//注册
	public User addUser(String username,String password,String address) throws SQLException;
}
