<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Order Place Success</title>
</head>
<body>
  <jsp:include page="header.jsp" />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<!-- container --><div class="section">
		
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
      <legend>Order Placed Successfully</legend>
   
      <table class="table">
			<tr>
				<td>Order No:</td>
				<td><p  class="span3">${order.orderID}</p>
					</td>
			</tr>
			
			<tr>
				<td>Your Address:</td>
				<td><p  class="span3">${order.shippingAddress}</p>
			</tr>


			<tr>
				<td>Order Place Date:</td>
				<td><p  class="span3">${order.orderplacedate}</p>
			</tr>
			
			<tr>
				<td>Mode of Delivery Chosen:</td>
				<td><p  class="span3">${order.modeofdelivery}</p>
			</tr>
			

			<tr>
				<td>Car will be available on:</td>
				<td><p  class="span3">${order.deliverydate}</p>
			</tr>
				<tr>
				<td>Total Amount:</td>
				<td><p  class="span3">${totalAmount}</p>
			</tr>
			<tr>
				<td><button class="primary-btn" onclick="window.print();" type="submit">Print Invoice</button></td>
				
			</tr>

		</table>
   
</div>
</div></div></div></div>
	</div>
  <jsp:include page="footer.jsp" />
</body>
</html>