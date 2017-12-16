package com.qxr.cakeshop.service.type;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Type;

public interface TypeService {
	public List<Type> getParentType() throws SQLException;
//	public List<Type> getSubType(int typeId);
}
