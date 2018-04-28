<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>C-SHOP</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="css/slick.css" />
	<link type="text/css" rel="stylesheet" href="css/slick-theme.css" />

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet" href="css/nouislider.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
<script>
	function ajaxEvent() {
		
		var xmlHttp;
		try // Firefox, Opera 8.0+, Safari
		{
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try // Internet Explorer
			{
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				//	alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				//document.getElementById("searchDiv").innerHTML = xmlHttp.responseText;
				alert( xmlHttp.responseText+" Results Found");
			}
		}
		
		var queryString = document.getElementById("rselection").value;

		xmlHttp.open("GET","http://localhost:8080/mycarapp/ajaxservice.htm?rselection="+queryString, true);
		xmlHttp.send();
	}
</script>

</head>

<body>
	<!-- HEADER -->
	
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	    
    
	
	<header>

		<!-- header -->
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="#">
							<img src="./img/logo.png" alt="">
						</a>
					</div>
					<!-- /Logo -->

					<!-- Search -->
					<div class="header-search">
						<form method="post" action="${contextPath}/searchCarNow">
							<input class="input search-input" type="text" placeholder="Find a car" name="rselection" id="rselection" onkeyup="ajaxEvent()" >
							<button class="search-btn" id="searchDiv"><i class="fa fa-search"></i></button>							
													
						</form>
					</div>
					<!-- /Search -->
				</div>
				<div class="pull-right">
					<ul class="header-btns">
						<!-- Account -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								
								<strong class="text-uppercase">My Account <i class="fa fa-caret-down"></i></strong>
							</div>
							<c:if test="${user==null}">
							<a href="${contextPath}/login" class="text-uppercase">Login</a> / <a href="${contextPath}/registerPage" class="text-uppercase">Register</a>
								</c:if>	
							<c:if test="${user!=null}">
							<a class="text-uppercase">${user.username}</a> / <a href="${contextPath}/logout" class="text-uppercase">Log out</a>
								</c:if>								
							<ul class="custom-menu">
								<li><a href="${contextPath}/accountDetails"><i class="fa fa-user-o"></i> My Account</a></li>							
								<li><a href="${contextPath}/shoppingCart"><i class="fa fa-check"></i> My Cart</a></li>
								<c:if test="${user==null}">
								<li><a href="${contextPath}/login"><i class="fa fa-unlock-alt"></i> Login</a></li>
								</c:if>
									<c:if test="${user==null}">
								<li><a href="${contextPath}/registerPage"><i class="fa fa-user-plus"></i> Create An Account</a></li>
									</c:if>
							</ul>
						</li>
						<!-- /Account -->

						<!-- Mobile nav toggle-->
						<li class="nav-toggle">
							<button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
						</li>
						<!-- / Mobile nav toggle -->
					</ul>
				</div>
			</div>
			<!-- header -->
		</div>
		<!-- container -->
	</header>
	<!-- /HEADER -->

	<!-- NAVIGATION -->
	<div id="navigation">
		<!-- container -->
		<div class="container">
			<div id="responsive-nav">
				
				<!-- menu nav -->
				<div class="menu-nav">
					<span class="menu-header">Menu <i class="fa fa-bars"></i></span>
					<ul class="menu-list">
						<li><a href="${contextPath}/">Home</a></li>
						<li><a href="${contextPath}/allCars">All Cars</a></li>						
						<li><a href="${contextPath}/searchCar">Search Cars</a></li>
						<li><a href="${contextPath}/shoppingCart">Shopping Cart</a></li>
						<c:if test="${role=='ADMIN'}"><li><a href="${contextPath}/adminhome">Admin Panel</a></li></c:if>
				</ul>
				</div>
				<!-- menu nav -->
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /NAVIGATION -->

	<!-- HOME -->
	

</body>
</html>