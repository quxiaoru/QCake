package com.qxr.cakeshop.controller.cake;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qxr.cakeshop.entity.Cake;
import com.qxr.cakeshop.service.cake.CakeService;
import com.qxr.cakeshop.service.size.SizeService;

@Controller
@RequestMapping("/cake")
public class CakeController {
	@Resource
	private CakeService cakeService;
	@Resource
	private SizeService sizeService;
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addCake(@RequestParam(value="cakeFlavour") int flavourId,
			@RequestParam(value="cakeName") String cakeName,
			@RequestParam(value="infor") String infor,
			@RequestParam(value="cakePurpose") String cakePurpose,
			@RequestParam(value="cakeType") int typeId,
			@RequestParam(value="cakeColor") String cakeColor,
			@RequestParam(value="cakeFloor") int cakeFloor,
			@RequestParam(value="cakeFloorPrice") int cakeFloorPrice,
			@RequestParam(value="cakeDiscount") double cakeDiscount,
			@RequestParam(value="img") MultipartFile []file,
			HttpServletRequest request) throws SQLException {
		Cake cake = new Cake();
		cake.setColor(cakeColor);
		cake.setDiscounts(cakeDiscount);
		cake.setFlavourId(flavourId);
		cake.setFloor(cakeFloor);
		cake.setFloorPrice(cakeFloorPrice);
		cake.setInfor(infor);
		cake.setName(cakeName);
		cake.setPurpose(cakePurpose);
		cake.setTypeId(typeId);
		String rootPath=request.getServletContext().getRealPath("/");
		System.out.println(rootPath);
		cake.setImg1(file[0].getOriginalFilename());
		cake.setImg2(file[1].getOriginalFilename());
		cake.setImg3(file[2].getOriginalFilename());		
		try {
			for(MultipartFile temp:file) {
				FileCopyUtils.copy(temp.getBytes(), 
						new File(rootPath+"/images",temp.getOriginalFilename()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		cakeService.saveCake(cake);
		HttpSession session = request.getSession();
		session.setAttribute("sizes", sizeService.getSizes());
		session.setAttribute("theCake", cake);
		return "admin/addPrice";
	}
	//得到全部的蛋糕
	@RequestMapping("/get")
	public String getCake(HttpServletRequest request) throws SQLException {		
		List<Cake> cakes = cakeService.getCakes();
		HttpSession session = request.getSession();
		System.out.println(cakes.get(0).getId());
		session.setAttribute("cakes", cakes);
		return "redirect:../bar/getBar";
	}
	//根据蛋糕的类型
		@RequestMapping("/findCakesByTypeId")
		public String findCakesByTypeId(@RequestParam(value="typeId") int typeId,Model model,HttpServletRequest request) throws SQLException {
			HttpSession session = request.getSession();
			session.setAttribute("typeId",typeId);
			List<Cake> cakes = cakeService.findCakesByTypeId(typeId);
			session.setAttribute("cakes", cakes);
			return "redirect:../bar/getBar";
		}
	//根据蛋糕的用途
	@RequestMapping("/purpose")
	public String findCakesByPurpose(@RequestParam(value="purpose",defaultValue="all") String purpose,Model model,HttpServletRequest request) throws SQLException {
		System.out.println(purpose);
		HttpSession session = request.getSession();
		session.setAttribute("purpose",purpose);
		List<Cake> cakes = cakeService.findCakesByPurpose(purpose);
		session.setAttribute("cakes", cakes);
		return "redirect:../bar/getBar";
	}
	//蛋糕的颜色
	@RequestMapping("/color")
	public String findCakesByColor(@RequestParam(value="color",defaultValue="all") String color,Model model,HttpServletRequest request) throws SQLException {
		System.out.println(color);		
		HttpSession session = request.getSession();
		if(session.getAttribute("purpose") != null && !session.getAttribute("purpose").equals("all")){
				String purpose = (String) session.getAttribute("purpose");
				List<Cake> cakes = cakeService.findCakesByPurposeAndColor(purpose, color);
				session.setAttribute("cakes", cakes);					
		}else{
			List<Cake> cakes = cakeService.findCakesByColor(color);
			session.setAttribute("cakes", cakes);
		}
		return "redirect:../bar/getBar";
	}
	//蛋糕的层数
	@RequestMapping("/floor")
	public String findCakesByFloor(@RequestParam(value="floor",defaultValue="0") int floor,Model model,HttpServletRequest request) throws SQLException {
		System.out.println(floor);		
		HttpSession session = request.getSession();
		if(session.getAttribute("purpose") != null && !session.getAttribute("purpose").equals("all")){
				String purpose = (String) session.getAttribute("purpose");
				List<Cake> cakes = cakeService.findCakesByPurposeAndFloor(purpose, floor);
				session.setAttribute("cakes", cakes);					
		}else{
			List<Cake> cakes = cakeService.findCakesByFloor(floor);
			session.setAttribute("cakes", cakes);
		}
		return "redirect:../bar/getBar";
	}
//	public String findCakesBySize(@RequestParam(value="floor",defaultValue="0") int floor,Model model) {
//		System.out.println(floor);		
//		List<Cake> cakes = cakeService.findCakesByFloor(floor);
//		model.addAttribute("cakes", cakes);
//		return "moban8711/products";
//	}
	@RequestMapping("/discounts")
	public String findCakesByDiscounts(@RequestParam(value="discountsMax") double discountsMax,@RequestParam(value="discountsMin") double discountsMin,Model model,HttpServletRequest request) throws SQLException {
		System.out.println(discountsMax);
		System.out.println(discountsMin);
		HttpSession session = request.getSession();
		if(session.getAttribute("purpose") != null && !session.getAttribute("purpose").equals("all")){
				String purpose = (String) session.getAttribute("purpose");
				List<Cake> cakes = cakeService.findCakesByPurposeAndDiscounts(purpose, discountsMax, discountsMin);
				session.setAttribute("cakes", cakes);					
		}else{
			System.out.println(discountsMax);
			List<Cake> cakes = cakeService.findCakesByDiscounts(discountsMax, discountsMin);
			session.setAttribute("cakes", cakes);
		}
		return "redirect:../bar/getBar";
	}
	
	//获取价格区间内的蛋糕
	@RequestMapping(value="/price",method=RequestMethod.GET)
	public String findCakesByPrice(@RequestParam(value="priceMin",defaultValue="0") int priceMin,@RequestParam(value="priceMax",defaultValue="1000") int priceMax,Model model,HttpServletRequest request) throws SQLException {
		System.out.println(priceMin);	
		System.out.println(priceMax);
		System.out.println("获取价格区间内的蛋糕");
		HttpSession session = request.getSession();
		if(session.getAttribute("purpose") != null && !session.getAttribute("purpose").equals("all")){
				String purpose = (String) session.getAttribute("purpose");
				List<Cake> cakes = cakeService.finfCakesByPurposeAndPrice(purpose, priceMin, priceMax);
				session.setAttribute("cakes", cakes);
				
		}else{
			System.out.println("获取价格区间内的蛋糕");
			List<Cake> cakes = cakeService.findCakesByPrice(priceMin, priceMax);
			session.setAttribute("cakes", cakes);
		}
		return "redirect:../bar/getBar";
	}
	//蛋糕的首页
	@RequestMapping("/index")
		public String findCakeByColor(HttpServletRequest request) throws SQLException {
			List<Cake> cakes = cakeService.getCakes();
			HttpSession session = request.getSession();
			session.setAttribute("cakes", cakes);
			return "redirect:../bar/index";
		}
	//蛋糕的名字
	@RequestMapping(value="/name",method=RequestMethod.GET)
	public String findCakesName(@RequestParam(value="name",defaultValue="all") String name,Model model,HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		System.out.println(name);	
		List<Cake> cakes = cakeService.findCakesByName(name);
		session.setAttribute("cakes", cakes);
		return "redirect:../bar/getBar";
	}
	//蛋糕的分页
	@RequestMapping(value="cakePage")
	public String cakePage(@RequestParam(value="pageIndex",defaultValue="1") int pageIndex,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//设置页码数量
		int pageCount =2;
		session.setAttribute("pageCount", pageCount);
		//设置当前页码
		session.setAttribute("pageIndex", pageIndex);
		return "moban8711/products";
	}
	//蛋糕的口味
	@RequestMapping("/flavour")
	public String findCakesByFlavourId(@RequestParam(value="flavourId",defaultValue="0") int flavourId,Model model,HttpServletRequest request) throws SQLException {
		System.out.println(flavourId);		
		HttpSession session = request.getSession();
		if(session.getAttribute("purpose") != null && !session.getAttribute("purpose").equals("all")){
				String purpose = (String) session.getAttribute("purpose");
				List<Cake> cakes = cakeService.findCakesByPurposeAndFlavourId(purpose, flavourId);
				session.setAttribute("cakes", cakes);					
		}else{
			List<Cake> cakes = cakeService.findCakesByFloor(flavourId);
			session.setAttribute("cakes", cakes);
		}
		return "redirect:../bar/getBar";
	}
	//更新蛋糕
	@RequestMapping(value="/updateCake",method=RequestMethod.POST)
	public String updateCake(@RequestParam(value="cakeFlavour") int flavourId,
			@RequestParam(value="cakeName") String cakeName,
			@RequestParam(value="infor") String infor,
			@RequestParam(value="cakePurpose") String cakePurpose,
			@RequestParam(value="cakeType") int typeId,
			@RequestParam(value="cakeColor") String cakeColor,
			@RequestParam(value="cakeFloor") int cakeFloor,
			@RequestParam(value="cakeDiscount") double cakeDiscount,
			@RequestParam(value="cakeFloorPrice") int cakeFloorPrice,
			HttpServletRequest request) throws SQLException {	
		HttpSession session = request.getSession();
		Cake cake = (Cake)session.getAttribute("theCake");
		cake.setColor(cakeColor);
		cake.setDiscounts(cakeDiscount);
		cake.setFlavourId(flavourId);
		cake.setFloor(cakeFloor);
		cake.setTypeId(typeId);
		cake.setName(cakeName);
		cake.setInfor(infor);
		cake.setPurpose(cakePurpose);
		cake.setFloorPrice(cakeFloorPrice);
		cakeService.updateCake(cake);
		session.setAttribute("theCake", cake);		
		return "admin/single";
	}
		//删除蛋糕
		@RequestMapping("/deleteCakes")
		public String deleteCakes(@RequestParam("deleteCakeId") int[] theCakeIds,HttpServletRequest request) throws SQLException {
			for(int theCakeId:theCakeIds) {
				int id = theCakeId;
				cakeService.isDeleteCake(id);
			}			
			List<Cake> cakes = cakeService.getCakes();
			HttpSession session = request.getSession();
			System.out.println(cakes.get(0).getId());
			session.setAttribute("cakes", cakes);
			return "admin/adminProducts";
		}		
}
