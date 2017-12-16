package com.qxr.cakeshop.dao.size;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Sc;
import com.qxr.cakeshop.entity.Size;

public interface SizeDao {
	public List<Size> getSizes() throws SQLException;
	public List<Sc> findScByCakeId(int cakeId) throws SQLException;
	public void updatePrice(int price,int cakeId,int sizeId) throws SQLException;
	public void addPrice(Sc sc) throws SQLException;
}
