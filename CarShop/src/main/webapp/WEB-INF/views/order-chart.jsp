<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Register Success</title>
<script type="text/javascript">
window.onload = function() {
 
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: true,
	animationEnabled: true,
	title: {
		text: "Orders By Brand"
	},
	data: [{
		type: "pie",
		showInLegend: "true",
		legendText: "{label}",
		yValueFormatString: "#,###\"%\"",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}",
		dataPoints: dps[0]
	}]
});
 
var yValue;
var label;
 
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		label = "${dataPoint.label}";
		dps[parseInt("${loop.index}")].push({
			label : label,
			y : yValue,
		});		
	</c:forEach>	
</c:forEach> 
 
chart.render();
}
</script>
</head>
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
      <legend>All Orders Chart</legend>
   
    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
   
</div>
</div></div></div></div>
	</div>
  <jsp:include page="footer.jsp" />
</body>
</html>