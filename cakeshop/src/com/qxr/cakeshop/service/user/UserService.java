package com.qxr.cakeshop.service.user;

import java.sql.SQLException;

import com.qxr.cakeshop.entity.User;

public interface UserService {
	public User isLogin(String username,String password) throws SQLException;
	public User addUser(String username,String password,String address) throws SQLException;
}
