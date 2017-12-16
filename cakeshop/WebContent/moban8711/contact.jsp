<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Orders</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<style type="text/css">
	th{
		font-family:"微软雅黑";
		color:	#FFFAFA;
	}
</style>
<script>
        function deleteNews(obj){
           		if(confirm('您确认删除吗')){
               		 $.ajax({
                  			 url:$(obj).attr('href'),
                  			 type:"DELETE",
                  			success:function(data){
                       		if(data =="ok"){
                           		//alert('删除成功');
                           	 obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
                      	  }else{alert('删除失败');}
                   		 }
              	 });
           	 }
       	 }
</script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->	
<!-- cart -->
<script src="${pageContext.request.contextPath}/js/simpleCart.min.js"> </script>
	

<!-- cart -->
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
	<!--contact-->
	<div class="contact">
		<div class="container">
			<h2>订单</h2>
			<div class="map">
			<form action="${pageContext.request.contextPath}/order/deleteOrders">	
			<center>
				<table border="3" >
					<tr style="background:#5D4B33;">
					    <th style="width:60px; height:20px; text-align:center"></th>
						<th style="width:120px; height:20px; text-align:center">蛋糕名称</th>
						<th style="width:120px; height:20px; text-align:center">蛋糕尺寸</th>
						<th style="width:120px; height:20px; text-align:center">购买数量</th>
						<th style="width:120px; height:20px; text-align:center">购买时间</th>
						<th style="width:120px; height:20px; text-align:center">送达时间</th>
						<th style="width:120px; height:20px; text-align:center">总价</th>
					</tr>
					<c:forEach var="order" items="${orders }">
						<tr>
							<td style="text-align:center"><input type="checkbox" name="orderId" value="${order.id }"></td>
							<td style="text-align:center">${order.cake.name }</td>
							<td style="text-align:center">${order.size.size }寸</td>
							<td style="text-align:center">${order.count }个</td>
							<td style="text-align:center">${order.ordertime }</td>
							<td style="text-align:center">${order.ordertime1 }</td>
							<td style="text-align:center">${order.count*order.price }元</td>
						</tr>
					</c:forEach>
				</table>
					<input type="submit" value="删除选中订单">
				</center>
				
			</form>
			</div>
			<div class="contact-infom">
				<h4>Miscellaneous information :</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sheets containing Lorem Ipsum passages, 
					sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.It was popularised in the 1960s with the release of Letraset
					and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			</div>
			<div class="address">
				<div class="col-md-4 address-grids">
					<h4>Address :</h4>
					<ul>
						<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<p>	Eiusmod Tempor inc<br>
							St Dolore Place,<br>
							Kingsport 56777
						</p>
					</ul>
				</div>
				<div class="col-md-4 address-grids">
					<h4>Contact no :</h4>
					<p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>+2 800 544 6035</p>
					<p><span class="glyphicon glyphicon-print" aria-hidden="true"></span>+2 100 889 9466</p>
				</div>
				<div class="col-md-4 address-grids">
					<h4>Email :</h4>
					<p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span><a href="mailto:example@mail.com">mail@example.com</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>		
			<div class="contact-form">
				<h4>Contact form</h4>
				<form>
					<input type="text" value="Name" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Name';}" required="">
					<input type="text" value="Email" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="text" value="Telephone" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Telephone';}" required="">
					<textarea type="text"  onfocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea>
					<button class="btn1">Submit</button>
				</form>
			</div>	
		</div>
	</div>
	<!--//contact-->
	<!--footer-->
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
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.17sucai.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		</div>
	</div>
</body>
</html>