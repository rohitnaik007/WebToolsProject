<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <jsp:include page="header.jsp" />
  
  	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <div id="home">
		<!-- container -->
		<div class="container">
			<!-- home wrap -->
		
				<!-- home slick -->
				<br/>
				<div id="responsive-nav">
				<!-- category nav -->
				<div class="category-nav">
					<span class="category-header">ADMIN ACTIONS <i class="fa fa-list"></i></span>
					<ul class="category-list">						
						<li><a href="${contextPath}/addnewcar">ADD NEW CAR</a></li>		
						<li><a href="${contextPath}/DeleteCar">DELETE CAR</a></li>				
						<li><a href="${contextPath}/getchart">VIEW ORDER CHART</a></li>
						<li><a href="#">VIEW USERS</a></li>
						<li><a href="#">ORDERS</a></li>
<!-- 						<li><a href="#"></a></li> -->
					</ul>
				</div>
					<!-- banner -->				
<!-- 						<img src="./img/banner01.jpg" height="500" width="867" alt=""> -->
				
				<!-- /home slick -->
			</div>
			<!-- /home wrap -->
		
		<!-- /container -->
</div>
	<!-- /HOME -->

	 
	 <!-- section -->
	  <div id="home">
		<!-- container -->
		<div class="container">
			<!-- home wrap -->
			<div class="home-wrap">
				<!-- home slick -->
				
	<img src="./img/banner10.jpg" alt="">

     
   

</div></div></div></div>
</div>
	 
	 
	 
	 
	 
	 
	 
	 	</div>
   <jsp:include page="footer.jsp" />
</body>
</html>
