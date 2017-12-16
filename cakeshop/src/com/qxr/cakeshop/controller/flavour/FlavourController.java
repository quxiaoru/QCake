package com.qxr.cakeshop.controller.flavour;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qxr.cakeshop.entity.Flavour;
import com.qxr.cakeshop.service.flavour.FlavourService;


@Controller
@RequestMapping("/flavour")
public class FlavourController {
	
	@Resource
	private FlavourService flavourService;
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addFlavour(@RequestParam("name") String name) throws SQLException {
		System.out.println(name);
		flavourService.saveFlavour(name);
		return "";
	}
	@RequestMapping(value="getFlavour")
	public String getFlavour(HttpServletRequest request) throws SQLException {
		List<Flavour> flavours =  flavourService.getFlavour();
		System.out.println("1");
		System.out.println(flavours.get(1).getFlavourName());
		HttpSession session = request.getSession();
		session.setAttribute("flavours", flavours);
		return "redirect:../size/getSize";
	}
}
