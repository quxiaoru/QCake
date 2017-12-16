package com.qxr.cakeshop.service.flavour;

import java.sql.SQLException;
import java.util.List;

import com.qxr.cakeshop.entity.Flavour;

public interface FlavourService {
	public void saveFlavour(String name) throws SQLException;
	public List<Flavour> getFlavour() throws SQLException;
}
