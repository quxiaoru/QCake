package com.qxr.cakeshop.controller.size;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qxr.cakeshop.entity.Cake;
import com.qxr.cakeshop.entity.Sc;
import com.qxr.cakeshop.entity.Size;
import com.qxr.cakeshop.service.cake.CakeService;
import com.qxr.cakeshop.service.size.SizeService;

@Controller
@RequestMapping("/size")
public class SizeController {
	@Resource
	private SizeService sizeService;
	@Resource
	private CakeService cakeService;
	@RequestMapping("/getSize")
	public String getSize(HttpServletRequest request) throws SQLException {
		List<Size> sizes = sizeService.getSizes();
		HttpSession session = request.getSession();
		session.setAttribute("sizes", sizes);
		return "redirect:../color/getColor";
	} 
	@RequestMapping(value="/updatePrice",method=RequestMethod.POST)
	public String updatePrice(@RequestParam("price") int price,
			@RequestParam("sizeId") int sizeId,
			@RequestParam("cakeId") int cakeId,
			HttpServletRequest request) throws SQLException {
		Sc sc = new Sc();
		sc.setCakeId(cakeId);
		sc.setSizeId(sizeId);
		sc.setPrice(price);
		sizeService.updatePrice(price, cakeId, sizeId);
		return "admin/single";
	} 
	@RequestMapping(value="/addPrice",method=RequestMethod.POST)
	public String addPrice(@RequestParam("price") int price,
			@RequestParam("sizeId") int sizeId,
			@RequestParam("cakeId") int cakeId,
			HttpServletRequest request) throws SQLException {
		Sc sc = new Sc();
		sc.setCakeId(cakeId);
		sc.setSizeId(sizeId);
		sc.setPrice(price);
		sizeService.addPrice(sc);
		return "admin/addPrice";
	} 
}
