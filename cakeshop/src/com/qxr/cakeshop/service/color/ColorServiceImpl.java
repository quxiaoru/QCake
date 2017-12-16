package com.qxr.cakeshop.service.color;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.color.ColorDao;
import com.qxr.cakeshop.entity.Color;
@Service
public class ColorServiceImpl implements ColorService {

	@Resource 
	private ColorDao colorDao;
	@Override
	public List<Color> getColor() throws SQLException{
		// TODO Auto-generated method stub
		return colorDao.getColor();
	}
}
