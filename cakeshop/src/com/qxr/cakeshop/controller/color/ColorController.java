package com.qxr.cakeshop.controller.color;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qxr.cakeshop.entity.Color;
import com.qxr.cakeshop.service.color.ColorService;

@Controller 
@RequestMapping("/color")
public class ColorController {
	@Resource
	private ColorService colorService;
	
	@RequestMapping("/getColor")
	public String getColor(HttpServletRequest request) throws SQLException {
		List<Color> colors = colorService.getColor();
		HttpSession session = request.getSession();
		session.setAttribute("colors", colors);
		return "redirect:../type/parentType";
	}
}
