package com.qxr.cakeshop.controller.admin;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qxr.cakeshop.entity.Type;
import com.qxr.cakeshop.entity.Admin;
import com.qxr.cakeshop.entity.Bar;
import com.qxr.cakeshop.entity.Cake;
import com.qxr.cakeshop.entity.Flavour;
import com.qxr.cakeshop.entity.Size;
import com.qxr.cakeshop.entity.Color;
import com.qxr.cakeshop.service.admin.AdminService;
import com.qxr.cakeshop.service.bar.BarService;
import com.qxr.cakeshop.service.cake.CakeService;
import com.qxr.cakeshop.service.color.ColorService;
import com.qxr.cakeshop.service.flavour.FlavourService;
import com.qxr.cakeshop.service.size.SizeService;
import com.qxr.cakeshop.service.type.TypeService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Resource
	private AdminService adminService;
	@Resource
	private CakeService cakeService;
	
	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public String adminLogin(@RequestParam(value="adminName") String adminName,@RequestParam(value="adminPassword") String adminPassword,Model model,HttpServletRequest request) throws SQLException {
		if(adminService.isLogin(adminName, adminPassword)) {
			List<Cake> cakes = cakeService.getCakes();
			HttpSession session = request.getSession();
			System.out.println(cakes.get(0).getId());
			session.setAttribute("cakes", cakes);
			return "admin/adminProducts";
		}else {
			model.addAttribute("hint", "用户名和密码不匹配！");
			return "admin/account";
		}
	}
	@RequestMapping(value="/getCakes")
	public String getCakes(HttpServletRequest request) {
			List<Cake> cakes;
			try {
				cakes = cakeService.getCakes();
				HttpSession session = request.getSession();
				session.setAttribute("cakes", cakes);
				return "admin/adminProducts";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return "404.jsp";
			}			
	}
	@RequestMapping(value="/exit")
	public String exit(HttpServletRequest request) {
				Admin admin = null;
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				return "admin/account";		
	}
}
