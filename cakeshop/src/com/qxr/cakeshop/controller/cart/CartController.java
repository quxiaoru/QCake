package com.qxr.cakeshop.controller.cart;

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

import com.qxr.cakeshop.entity.Cart;
import com.qxr.cakeshop.entity.User;
import com.qxr.cakeshop.service.cart.CartService;

@Controller
@RequestMapping("cart")
public class CartController {
	@Resource 
	private CartService cartService;
	@RequestMapping("getCarts")
	public String getCarts(HttpServletRequest request,Model model) throws SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			model.addAttribute("hint","ÇëµÇÂ¼»ò×¢²á£¡");
			return "moban8711/account";
		}else {
			User user = (User)session.getAttribute("user");
			List<Cart> carts = cartService.findCartByUserId(user.getId());
			if(carts == null) {
				model.addAttribute("nullCart","ÄúµÄ¹ºÎï³µÊÇ¿ÕµÄ£¬È¥Ñ¡ÔñÏ²»¶µÄÉÌÆ·°É£¡");
				System.out.println("nullcart");
				
			}
			model.addAttribute("carts",carts);
			}			
			return "moban8711/checkout";
	}		

	@RequestMapping(value="addCart",method=RequestMethod.POST)
	public String getCarts(@RequestParam("count") int count,@RequestParam("cakeId") int cakeId,@RequestParam("sizeId") int sizeId,Model model,HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			model.addAttribute("hint","ÇëµÇÂ¼»ò×¢²á£¡£¡");
			return "moban8711/account";
		}else{
			User user = (User)session.getAttribute("user");
			int	userId = user.getId();
			cartService.insertCart(userId, cakeId, count, sizeId);
			return "redirect:../cart/getCarts";
		}

	}
	@RequestMapping("deleteCart")
	public String deleteCarts(@RequestParam("cartId") int cartId,Model model,HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			model.addAttribute("hint","ÇëµÇÂ¼»ò×¢²á£¡£¡");
			return "moban8711/account";
		}else{
			cartService.deleteCart(cartId);
			return "redirect:../cart/getCarts";
		}

	}
	@RequestMapping("addCount")
	public String addCount(@RequestParam("cartId") int cartId,HttpServletRequest request) throws SQLException {
		cartService.addCount(cartId);
		return"redirect:../cart/getCarts";
	}
	@RequestMapping("deleteCount")
	public String deleteCount(@RequestParam("cartId") int cartId,@RequestParam("count") int count) throws SQLException {
		if(count<2) {
			return "moban8711/checkout";
		}else {
			cartService.deleteCount(cartId);
			return"redirect:../cart/getCarts";
		}		
	}
}
