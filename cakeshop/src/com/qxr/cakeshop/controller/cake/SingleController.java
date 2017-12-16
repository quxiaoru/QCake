package com.qxr.cakeshop.controller.cake;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qxr.cakeshop.entity.Bar;
import com.qxr.cakeshop.entity.Cake;
import com.qxr.cakeshop.entity.Color;
import com.qxr.cakeshop.entity.Flavour;
import com.qxr.cakeshop.entity.Sc;
import com.qxr.cakeshop.entity.Size;
import com.qxr.cakeshop.entity.Type;
import com.qxr.cakeshop.service.bar.BarService;
import com.qxr.cakeshop.service.cake.CakeService;
import com.qxr.cakeshop.service.cart.CartService;
import com.qxr.cakeshop.service.color.ColorService;
import com.qxr.cakeshop.service.flavour.FlavourService;
import com.qxr.cakeshop.service.size.SizeService;
import com.qxr.cakeshop.service.type.TypeService;

@Controller
@RequestMapping("/single")
public class SingleController {
	@Resource
	private CakeService cakeService;
	@Resource
	private CartService cartService;
	@Resource
	private BarService barService; 
	@Resource
	private TypeService typeService;
	@Resource
	private FlavourService flavourService;
	@Resource
	private ColorService colorService;
	@Resource
	private SizeService sizeService;
	
	@RequestMapping("/theCake")
	public String getTheCake(@RequestParam("theCake") int id,Model model,HttpServletRequest request) throws SQLException {
		Cake theCake = cakeService.findCakeById(id);
		int theCakePrice = theCake.getFloorPrice();
		model.addAttribute("theCakePrice", theCakePrice);
		List<Cake> theCakes = cakeService.findCakesByColor(theCake.getColor());
		List<Sc> sc = sizeService.findScByCakeId(id);
		HttpSession session = request.getSession();
		session.setAttribute("sc", sc);
		session.setAttribute("theCake", theCake);
		session.setAttribute("theCakes", theCakes);
		model.addAttribute("theCake", theCake);
		model.addAttribute("theCakes", theCakes);
		return "moban8711/single";
	}
	@RequestMapping("/theCakePrice")
	public String getTheCakePrice(@RequestParam("theCakeId") int cakeId,@RequestParam("theSizeId") int sizeId,Model model) throws SQLException {
		int theCakePrice = cartService.findPrice(cakeId, sizeId);
		model.addAttribute("theCakePrice", theCakePrice);
		return "moban8711/single";
	}
	@RequestMapping("/adminTheCake")
	public String getAdminTheCake(@RequestParam("theCakeId") int id,HttpServletRequest request) throws SQLException {
		Cake theCake = cakeService.findCakeById(id);
		List<Bar> bars = barService.getBar();
		List<Type> types = typeService.getParentType();
		List<Flavour> flavours = flavourService.getFlavour();
		List<Color> colors = colorService.getColor();
		List<Sc> scs = sizeService.findScByCakeId(id);
		HttpSession session = request.getSession();
		session.setAttribute("theCake", theCake);
		session.setAttribute("scs", scs);
		session.setAttribute("colors", colors);
		session.setAttribute("flavours", flavours);
		session.setAttribute("types", types);
		session.setAttribute("bars", bars);
		return "admin/single";
	}
	@RequestMapping("/addCake")
	public String getAddCake(HttpServletRequest request) throws SQLException {
		List<Bar> bars = barService.getBar();
		List<Type> types = typeService.getParentType();
		List<Flavour> flavours = flavourService.getFlavour();
		List<Color> colors = colorService.getColor();
		List<Size> scs = sizeService.getSizes();
		HttpSession session = request.getSession();
		session.setAttribute("scs", scs);
		session.setAttribute("colors", colors);
		session.setAttribute("flavours", flavours);
		session.setAttribute("types", types);
		session.setAttribute("bars", bars);
		return "admin/addsingle";
	}
}
