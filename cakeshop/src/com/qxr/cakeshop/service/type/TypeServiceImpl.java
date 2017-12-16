package com.qxr.cakeshop.service.type;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.type.TypeDao;
import com.qxr.cakeshop.entity.Type;
@Service
public class TypeServiceImpl implements TypeService{

	@Resource
	private TypeDao typeDao;
	@Override
	public List<Type> getParentType() throws SQLException{
		// TODO Auto-generated method stub
		return typeDao.getParentType();
	}

//	@Override
//	public List<Type> getSubType(int typeId) {
//		// TODO Auto-generated method stub
//		return typeDao.getSubType(typeId);
//	}

}
