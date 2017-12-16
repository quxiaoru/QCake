package com.qxr.cakeshop.controller.type;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qxr.cakeshop.entity.Bar;
import com.qxr.cakeshop.entity.Cake;
import com.qxr.cakeshop.entity.Color;
import com.qxr.cakeshop.entity.Flavour;
import com.qxr.cakeshop.entity.Size;
import com.qxr.cakeshop.entity.Type;
import com.qxr.cakeshop.service.type.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {
	@Resource
	private TypeService typeService;
	@SuppressWarnings("unchecked")
	@RequestMapping("/parentType")
	public String getParentType(HttpServletRequest request,Model model) throws SQLException {
		HttpSession session = request.getSession();
	
		List<Cake> cakes = (List<Cake>) session.getAttribute("cakes");
		List<Flavour> flavours = (List<Flavour>) session.getAttribute("flavours");
		List<Size> sizes = (List<Size>) session.getAttribute("sizes");
		List<Color> colors = (List<Color>) session.getAttribute("colors");
		List<Bar> bars = (List<Bar>) session.getAttribute("bars");
		List<Type> parentTypes = typeService.getParentType();
		session.setAttribute("parentTypes", parentTypes);
		return "redirect:../cake/cakePage";
		
	}
//	@RequestMapping("/subType")
//	public String getSubType(@RequestParam(value="typeId")int typeId,Model model){
//		System.out.println(typeId);
//		List<Type> subTypes = typeService.getSubType(typeId);
//		model.addAttribute("subTypes", subTypes);
//		return "moban8711/products";
//		
//	}
	
}
