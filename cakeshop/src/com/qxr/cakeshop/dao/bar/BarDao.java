package com.qxr.cakeshop.dao.bar;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Bar;

public interface BarDao {
	public List<Bar> getBar()throws SQLException;
}
