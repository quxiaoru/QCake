package com.qxr.cakeshop.dao.cake;

import java.sql.SQLException;
import java.util.List;


import com.qxr.cakeshop.entity.Cake;

public interface CakeDao {
	public void saveCake(Cake c) throws SQLException;
	public void updateCake(Cake cake) throws SQLException;
	public List<Cake> getCakes() throws SQLException;
	public boolean isDeleteCake(int cakeId) throws SQLException;
	public Cake findCakeById(int id) throws SQLException;
	public List<Cake> findCakesByPrice(int priceMin,int priceMax) throws SQLException;
	public List<Cake> findCakesByColor(String color) throws SQLException;
	public List<Cake> findCakesByPurpose(String purpose) throws SQLException;
	public List<Cake> findCakesByFloor(int floor) throws SQLException;
	public List<Cake> findCakesBySize(int size) throws SQLException;
	public List<Cake> findCakesByDiscounts(double discountsMax,double discountsMin) throws SQLException;
	public List<Cake> findCakesByTypeId(int typeId) throws SQLException;
	public List<Cake> findCakesByFlavourId(int flavourId) throws SQLException;
	public List<Cake> findCakesByName(String name) throws SQLException;
	public List<Cake> findCakesByPurposeAndPrice(String purpose,int priceMin,int priceMax) throws SQLException;
	public List<Cake> findCakesByPurposeAndColor(String purpose,String color) throws SQLException;
	public List<Cake> findCakesByPurposeAndFloor(String purpose,int floor) throws SQLException;
	public List<Cake> findCakesByPurposeAndDiscounts(String purpose,double discountsMax,double discountsMin) throws SQLException;
	public List<Cake> findCakesByPurposeAndTypeId(String purpose,int typeId) throws SQLException;
	public List<Cake> findCakesByPurposeAndSize(String purpose,int size) throws SQLException;
	public List<Cake> findCakesByPurposeAndFlavourId(String purpose,int flavourId) throws SQLException;
	public int getPages() throws SQLException;
}
