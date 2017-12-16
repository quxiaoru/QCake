package com.qxr.cakeshop.dao.flavour;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Flavour;

public interface FlavourDao {
	public void saveFlavour(Flavour flavour) throws SQLException;
	public List<Flavour> getFlavour() throws SQLException;
}
