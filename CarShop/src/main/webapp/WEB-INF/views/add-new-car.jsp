<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>

th, td {
    padding: 10px !important;
}
</style>
<title>Add New Car</title>
</head>
<body>
  <jsp:include page="header.jsp" />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	 
		<!-- container --><div class="section">
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
						<li><a href="#">VIEW CAR LIST</a></li>
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
				<div id="home-slick">
	
		<!-- container -->
<!-- 		<div class="container"> -->
		<div class="col-md-4 col-sm-6">
						<div class="span3 well">
      <legend>Add New Car</legend>
    <form:form accept-charset="UTF-8" action="${contextPath}/addnewcar" commandName="car"
		method="post">		
      <table>
			<tr>
				<td>Brand:</td>
				<td><form:input  class="span3"  path="brand" size="30" required="required" />
					<font color="red"><form:errors path="brand" /></font></td>
			</tr>

			<tr>
				<td>Model No:</td>
				<td><form:input  class="span3"  path="modelNo" size="30" required="required" />
					<font color="red"><form:errors path="modelNo" /></font></td>
			</tr>


			<tr>
				<td>Make Year:</td>
				<td><form:input  class="span3"  path="makeYear" size="30" required="required" />
					<font color="red"><form:errors path="makeYear" /></font></td>
			</tr>
			
			<tr>
				<td>Colors Available:</td>
				<td><form:input  class="span3"  path="colorsAvailable" size="30" required="required" />
					<font color="red"><form:errors path="colorsAvailable" /></font></td>
			</tr>
			

			<tr>
				<td>Price:</td>
				<td><form:password  class="span3"  path="price" size="30"
						required="required" /> <font color="red"><form:errors
							path="price" /></font></td>
			</tr>

			<tr>
				<td>Description:</td>
				<td><form:input  class="span3"  path="description" size="30"
						 required="required" /> <font color="red"><form:errors
							path="description" /></font></td>
			</tr>

			<tr>
			<td colspan="2"> <button class="btn btn-warning" type="submit">Add Car</button></td>
				
			</tr>
		</table>
    </form:form>
</div>
</div></div></div></div>
</div>
	
	
  <jsp:include page="footer.jsp" />
</body>
</html>