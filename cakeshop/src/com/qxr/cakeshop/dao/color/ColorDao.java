package com.qxr.cakeshop.dao.color;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Color;

public interface ColorDao {
	public List<Color> getColor() throws SQLException;
}
