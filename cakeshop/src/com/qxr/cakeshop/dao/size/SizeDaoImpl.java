package com.qxr.cakeshop.dao.size;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qxr.cakeshop.entity.Sc;
import com.qxr.cakeshop.entity.Size;

@Repository
public class SizeDaoImpl implements SizeDao{
	@Resource
	private SessionFactory session;
	public Session getSession() {
		return session.getCurrentSession();
	}
	public List<Size> getSizes() throws SQLException{
		// TODO Auto-generated method stub
		String hql = "from Size";
		Query query = getSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Size> sizes = query.list();	
		for(Size s:sizes) {
			System.out.println(s.getSize());
		}
		return sizes;
	}
	@Override
	public List<Sc> findScByCakeId(int cakeId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "from Sc sc where sc.cakeId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, cakeId);
		@SuppressWarnings("unchecked")
		List<Sc> Scs = query.list();
		return Scs;
	}
	@Override
	public void updatePrice(int price,int cakeId,int sizeId) throws SQLException{
		// TODO Auto-generated method stub
		String hql = "update Sc sc set sc.price=? where sc.cakeId=? and sc.sizeId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, price);
		query.setParameter(1, cakeId);
		query.setParameter(2, sizeId);
		query.executeUpdate();
		getSession().flush();
	}
	@Override
	public void addPrice(Sc sc) throws SQLException{
		// TODO Auto-generated method stub
		getSession().save(sc);
		getSession().flush();
	}
}
