package com.qxr.cakeshop.controller.order;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qxr.cakeshop.entity.Cart;
import com.qxr.cakeshop.entity.Orders;
import com.qxr.cakeshop.entity.User;
import com.qxr.cakeshop.service.cart.CartService;
import com.qxr.cakeshop.service.order.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource
	private OrderService orderService;
	@Resource
	private CartService cartService;	
	@RequestMapping("addOrder")
	public String addOrder(@RequestParam("cartId") int cartId) throws SQLException {
		orderService.addOrder(cartId);
		cartService.deleteCart(cartId);
		return "redirect:../cart/getCarts";
	}
	
	@RequestMapping("getOrders")
	public String getOrders(HttpServletRequest request,Model model) throws SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			model.addAttribute("hint","ÇëµÇÂ¼»ò×¢²á£¡");
			return "moban8711/account";
		}else {
			User user = (User)session.getAttribute("user");
			List<Orders> orders = orderService.findOrderByUserId(user.getId());
			model.addAttribute("orders",orders);
			}			
		return "moban8711/contact";
	}
	@RequestMapping("deleteOrders")
	public String deleteOrders(@RequestParam("orderId") int[] orderId,Model model) throws SQLException {
		for(int id:orderId) {
			orderService.isDeleteOrders(id);
		}		
		return "moban8711/contact";
	}
}
