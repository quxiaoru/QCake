package com.qxr.cakeshop.dao.user;

import java.sql.SQLException;

import com.qxr.cakeshop.entity.User;

public interface UserDao{
	//�ж��û����������Ƿ�ƥ��
	public User isLogin(String username,String password) throws SQLException;
	//ע��
	public User addUser(String username,String password,String address) throws SQLException;
}
