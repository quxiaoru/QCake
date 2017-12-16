package com.qxr.cakeshop.service.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.admin.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;
	@Override
	public boolean isLogin(String adminName, String adminPassword) throws  SQLException{
		return adminDao.isLogin(adminName, adminPassword) ;
	}

}
