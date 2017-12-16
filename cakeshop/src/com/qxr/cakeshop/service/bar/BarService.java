package com.qxr.cakeshop.service.bar;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Bar;

public interface BarService {
	public List<Bar> getBar() throws SQLException;
}
