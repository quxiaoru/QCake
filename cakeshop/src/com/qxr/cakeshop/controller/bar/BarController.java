package com.qxr.cakeshop.controller.bar;

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
import com.qxr.cakeshop.service.bar.BarService;
@Controller
@RequestMapping("bar")
public class BarController {
	@Resource
	private BarService barService; 
	@RequestMapping("getBar")
	public String getBar(HttpServletRequest request)  {
		
		try {
			List<Bar> bars;
			bars = barService.getBar();
			HttpSession session = request.getSession();
			session.setAttribute("bars", bars);
			return "redirect:../flavour/getFlavour";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "404.jsp";
		}
		
		
	}
	@RequestMapping("index")
	public String getBar1(Model model,HttpServletRequest request) {
		System.out.println("Bar");
		List<Bar> bars;
		try {
			bars = barService.getBar();
			HttpSession session = request.getSession();
			session.setAttribute("bars", bars);
			@SuppressWarnings("unchecked")
			List<Cake> cakes = (List<Cake>) session.getAttribute("cakes");
			model.addAttribute("cakes", cakes);
			model.addAttribute("bars", bars);
			return "moban8711/index";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "404.jsp";
		}
	
	}
}
