package com.qxr.cakeshop.dao.admin;

import java.sql.SQLException;

public interface AdminDao {
	public boolean isLogin (String adminName,String adminPassword) throws SQLException;
}
