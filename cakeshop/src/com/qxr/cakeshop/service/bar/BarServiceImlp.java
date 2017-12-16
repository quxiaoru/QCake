package com.qxr.cakeshop.service.bar;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.bar.BarDao;
import com.qxr.cakeshop.entity.Bar;
@Service
public class BarServiceImlp implements BarService {
	@Resource 
	private BarDao barDao;
	@Override
	public List<Bar> getBar() throws SQLException{
		// TODO Auto-generated method stub
		return barDao.getBar();
	}

}
