package com.qxr.cakeshop.service.color;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Color;

public interface ColorService {
	public List<Color> getColor() throws SQLException;
}
