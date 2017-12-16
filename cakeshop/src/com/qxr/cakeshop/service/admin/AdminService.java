package com.qxr.cakeshop.service.admin;

import java.sql.SQLException;

public interface AdminService {
	public boolean isLogin(String adminName,String adminPassword) throws SQLException;
}
