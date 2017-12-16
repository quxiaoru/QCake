package com.qxr.cakeshop.service.flavour;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qxr.cakeshop.dao.flavour.FlavourDao;
import com.qxr.cakeshop.entity.Flavour;
@Service
public  class FlavourServiceImpl implements FlavourService{

	@Resource
	private FlavourDao flavourDao;
	@Override
	public void saveFlavour(String name) throws SQLException{
		// TODO Auto-generated method stub
		Flavour flavour = new Flavour();
		flavour.setFlavourName(name);
		flavourDao.saveFlavour(flavour);
	}
	@Override
	public List<Flavour> getFlavour() throws SQLException{
		// TODO Auto-generated method stub
		
		return flavourDao.getFlavour();
	}

}
