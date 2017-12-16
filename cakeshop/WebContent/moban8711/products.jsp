<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->	
<!-- cart -->
<script src="${pageContext.request.contextPath}/js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- the jScrollPane script -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jscrollpane.min.js"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- //the jScrollPane script -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mousewheel.js"></script>
<!-- the mousewheel plugin -->		
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<h1 class="navbar-brand"><a  href="index.html">QCake</a></h1>
				</div>
				<!--navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<c:forEach var="bar" items="${bars }">
							<c:if  test="${bar.id == 1}">
							  <li><a href="${pageContext.request.contextPath}/cake/index" class="active">${bar.barName}</a></li>
							</c:if>
						</c:forEach>
						<c:forEach var="bar" items="${bars }">
							<c:if  test="${bar.id != 1}">
							  <li><a href="${pageContext.request.contextPath}/cake/purpose?purpose=${bar.barName}" class="active">${bar.barName}</a></li>
							</c:if>
						</c:forEach>
							 <li><a href="${pageContext.request.contextPath}/cake/get" class="active">所有产品</a></li>
					</ul> 							
					<!--/.navbar-collapse-->
				</div>
				<!--//navbar-header-->
			</nav>
			<div class="header-info">
				<div class="header-right search-box">
					<a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>				
					<div class="search">
						<form class="navbar-form" action="${pageContext.request.contextPath}/cake/name" method="get">
							<input type="text" class="form-control" name="name">
							<button type="submit" class="btn btn-default" aria-label="Left Align">
								Search
							</button>
						</form>
					</div>	
				</div>
				<div class="header-right login">
					<a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
					<div id="loginBox">                
						<form id="loginForm" action="${pageContext.request.contextPath}/user/isLogin">
							<fieldset id="body">
								<fieldset>
									<label for="email">用户名</label>
									<input type="text" name="username" id="email" value="${user.username }">
								</fieldset>
								<fieldset>
									<label for="password">密码</label>
									<input type="password" name="password" id="password" value="${user.password }">
								</fieldset>
								<input type="submit" id="login" value="Sign in">
								<label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
							</fieldset>
							<p>新用户 ? <a class="sign" href="${pageContext.request.contextPath}/moban8711/account.jsp">注册</a> <span><a href="#">忘记密码?</a><a href="${pageContext.request.contextPath}/user/exit">退出登录</a></span></p>
						</form>
					</div>
				</div>
				<div class="header-right cart">
					<a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
					<div class="cart-box">
						<p><a href="${pageContext.request.contextPath}/cart/getCarts">查看购物车</a></p>
						<p><a href="${pageContext.request.contextPath}/order/getOrders">查看订单</a></p>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//header-->
	<!--products-->
	<div class="products">	 
		<div class="container">
			<h2>Our Products</h2>			
			<div class="col-md-9 product-model-sec">
			<c:forEach var="cake" items="${cakes }" begin="${(pageIndex-1)*9}"  end="${pageIndex*9-1 }">
				<div class="product-grid">
					<a href="${pageContext.request.contextPath}/single/theCake?theCake=${cake.id }">				
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="${pageContext.request.contextPath}/images/${cake.img1 }" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">							
									<button>详情</button>
								</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${cake.name }</h4>								
							<span class="item_price">现价：${cake.floorPrice *cake.discounts/10}</span>
							<div class="ofr">
								<p class="pric1"><del>原价：${cake.floorPrice}</del></p>
								<p class="disc">${cake.discounts}折</p>
							</div>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				</c:forEach>
				 
			</div>	
			
			<div class="col-md-3 rsidebar span_1_of_left">
				<section  class="sky-form">
					<div class="product_right">
						<h4 class="m_2"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>分类</h4>
						<div class="tab1">
							<ul class="place">								
								<li class="sort">蛋糕类型</li>
								<li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span></li>								
							</ul>
							<div class="clearfix"> </div>
							<div class="single-bottom">
								<c:forEach var="parentType" items="${parentTypes}">
									<a href="${pageContext.request.contextPath}/cake/findCakesByTypeId?typeId=${parentType.id }"><p>${parentType.typeName }</p></a>
								</c:forEach>				
						    </div>
					    </div>						  
					</div>
				</section>
				<section></section>
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>价格</h4>
					<form action="${pageContext.request.contextPath}/cake/price" method="get">
						<input type="text" name="priceMin" style="height:28px;width:78px;" placeholder="最低价"/>
						<font size="2">---</font>
						<input type="text" name="priceMax" style="height:28px;width:78px;" placeholder="最高价"/>
						<input type="submit" class="item_add items" value="确认">
					</form>				
				</section>
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>口味</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked="checked"><i></i>全部</label>			
						</div>
						<div class="col col-4">
							<c:forEach var="f" items="${ flavours}">
								<label class="checkbox"><a href="${pageContext.request.contextPath}/cake/flavour?flavourId=${f.id }"><input type="checkbox" name="checkbox"><i></i></a>${f.flavourName }</label>
							</c:forEach>
						</div>
					</div>
				</section>
				<section>
				</section>
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Color</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked="checked"><i></i>全部</label>
						</div>
						<div class="col col-4">
							<c:forEach var="c" items="${ colors}">
								<label class="checkbox"><a href="${pageContext.request.contextPath}/cake/color?color=${c.color }"><input type="checkbox" name="checkbox"><i></i></a>${c.color}</label>
							</c:forEach>
						</div>
					</div>
				</section>	
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//products-->
	<!--footer-->
	<center>
		<c:if test="${pageIndex>1 }">
					<a href ="${pageContext.request.contextPath}/cake/cakePage?pageIndex=1">首页</a> &nbsp;&nbsp;
					<a href ="${pageContext.request.contextPath}/cake/cakePage?pageIndex=${pageIndex-1 }">上一页</a>  &nbsp;&nbsp;
				</c:if>
				<c:if test="${pageIndex<pageCount }">
					<a href ="${pageContext.request.contextPath}/cake/cakePage?pageIndex=${pageIndex+1 }">下一页</a>  &nbsp;&nbsp;
					<a href ="${pageContext.request.contextPath}/cake/cakePage?pageIndex=${ pageCount}">尾页</a> 
				</c:if>
	<center>
	<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-2 footer-grid">
					<h4>company</h4>
					<ul>
						<li><a href="products.html">products</a></li>
						<li><a href="#">Work Here</a></li>
						<li><a href="#">Team</a></li>
						<li><a href="#">Happenings</a></li>
						<li><a href="#">Dealer Locator</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>service</h4>
					<ul>
						<li><a href="#">Support</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Warranty</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h4>order & returns</h4>
					<ul>
						<li><a href="#">Order Status</a></li>
						<li><a href="#">Shipping Policy</a></li>
						<li><a href="#">Return Policy</a></li>
						<li><a href="#">Digital Gift Card</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>legal</h4>
					<ul>
						<li><a href="#">Privacy</a></li>
						<li><a href="#">Terms and Conditions</a></li>
						<li><a href="#">Social Responsibility</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid icons">
					<h4>Connect with Us</h4>
					<ul>
						<li><a href="#"><img src="images/i1.png" alt=""/>Follow us on Facebook</a></li>
						<li><a href="#"><img src="images/i2.png" alt=""/>Follow us on Twitter</a></li>
						<li><a href="#"><img src="images/i3.png" alt=""/>Follow us on Google-plus</a></li>
						<li><a href="#"><img src="images/i4.png" alt=""/>Follow us on Pinterest</a></li>
					</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			</div>
	<!--//footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.17sucai.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		</div>
	</div>
</body>
</html>