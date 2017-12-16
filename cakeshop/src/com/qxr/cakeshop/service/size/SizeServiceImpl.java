package com.qxr.cakeshop.service.size;

import com.qxr.cakeshop.dao.size.SizeDao;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.qxr.cakeshop.entity.Sc;
import com.qxr.cakeshop.entity.Size;
@Service
public class SizeServiceImpl implements SizeService {

	@Resource
	private SizeDao sizeDao;
	@Override
	public List<Size> getSizes() throws SQLException{
		// TODO Auto-generated method stub
		return sizeDao.getSizes();
	}
	@Override
	public List<Sc> findScByCakeId(int cakeId) throws SQLException{
		// TODO Auto-generated method stub
		
		return sizeDao.findScByCakeId(cakeId);
	}
	@Override
	public void updatePrice(int price,int cakeId,int sizeId) throws SQLException{
		// TODO Auto-generated method stub
		sizeDao.updatePrice(price, cakeId, sizeId);
	}
	public void addPrice(Sc sc) throws SQLException{
		sizeDao.addPrice(sc);
	}
}
