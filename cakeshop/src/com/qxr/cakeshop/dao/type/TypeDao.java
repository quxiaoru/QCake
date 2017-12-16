package com.qxr.cakeshop.dao.type;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Type;

public interface TypeDao {
	public List<Type> getParentType() throws SQLException;
}
