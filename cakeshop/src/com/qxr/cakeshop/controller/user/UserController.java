package com.qxr.cakeshop.controller.user;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qxr.cakeshop.entity.User;
import com.qxr.cakeshop.service.user.UserService;
@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("isLogin")
	public String isLogin(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest request,Model model) throws SQLException {
		User user = userService.isLogin(username, password);
		if(user == null) {
			model.addAttribute("hint","密码与用户名不匹配！");
			return "moban8711/account";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:../cake/index";
		}	
	}
	@RequestMapping("signUp")
	public String signUp(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("address") String address,HttpServletRequest request){
			try {
				userService.addUser(username, password, address);
				User user = userService.isLogin(username, password);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:../cake/index";
	}
	@RequestMapping("exit") 
	public String exit(HttpServletRequest request) {
			User user = null;
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:../cake/index";
	}	
}
