package com.qxr.cakeshop.service.cake;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qxr.cakeshop.dao.cake.CakeDao;
import com.qxr.cakeshop.entity.Cake;

@Service
@Transactional
public class CakeServiceImpl implements CakeService {
	@Resource
	private CakeDao cakeDao;
	public void saveCake(Cake c) throws SQLException{
		// TODO Auto-generated method stub
		cakeDao.saveCake(c);
	}
	public List<Cake> getCakes() throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.getCakes();
	}
	public List<Cake> findCakesByPrice(int priceMin, int priceMax) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPrice(priceMin, priceMax);
	}
	public List<Cake> findCakesByColor(String color) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByColor(color);
	}
	public List<Cake> findCakesByPurpose(String purpose) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurpose(purpose);
	}
	public List<Cake> findCakesByFloor(int floor) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByFloor(floor);
	}
	public List<Cake> findCakesBySize(int size) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesBySize(size);
	}
	public List<Cake> findCakesByDiscounts(double discountsMax,double discountsMin) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByDiscounts(discountsMax,discountsMin);
	}
	public List<Cake> findCakesByTypeId(int typeId) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByTypeId(typeId);
	}
	public List<Cake> findCakesByFlavourId(int flavourId) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByFlavourId(flavourId);
	}
	@Override
	public List<Cake> findCakesByName(String name) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByName(name);
	}
	@Override
	public List<Cake> finfCakesByPurposeAndPrice(String purpose, int priceMin, int priceMax) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurposeAndPrice(purpose, priceMin, priceMax);
	}
	@Override
	public List<Cake> findCakesByPurposeAndColor(String purpose, String color) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurposeAndColor(purpose, color);
	}
	@Override
	public List<Cake> findCakesByPurposeAndFloor(String purpose, int floor) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurposeAndFloor(purpose, floor);
	}
	@Override
	public List<Cake> findCakesByPurposeAndDiscounts(String purpose,double discountsMax,double discountsMin) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurposeAndDiscounts(purpose,discountsMax,discountsMin);
	}
	@Override
	public List<Cake> findCakesByPurposeAndTypeId(String purpose, int typeId) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurposeAndTypeId(purpose, typeId);
	}
	@Override
	public List<Cake> findCakesByPurposeAndSize(String purpose, int size) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurposeAndSize(purpose, size);
	}
	@Override
	public List<Cake> findCakesByPurposeAndFlavourId(String purpose, int flavourId) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakesByPurposeAndFlavourId(purpose, flavourId);
	}
	@Override
	public Cake findCakeById(int id) throws SQLException{
		// TODO Auto-generated method stub
		return cakeDao.findCakeById(id);
	}
	@Override
	public void updateCake(Cake cake) throws SQLException{
		// TODO Auto-generated method stub
		cakeDao.updateCake(cake);
	}

	public boolean isDeleteCake(int cakeId) throws SQLException{
		return cakeDao.isDeleteCake(cakeId);
		
	}
	public int getPages() throws SQLException{
		return cakeDao.getPages();
	}
}
