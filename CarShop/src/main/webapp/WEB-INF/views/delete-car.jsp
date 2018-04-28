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
<title>All Cars</title>
</head>
<body>
  <jsp:include page="header.jsp" />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	 <div class="container">
	 <br/>
    <div class="well well-sm">
        <strong>All Cars</strong>
    </div>
    	<c:forEach var="car" items="${cars}">
         <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="${car.imageSrc}" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                       ${car.brand} ${car.modelNo}</h4>
                    <p class="group inner list-group-item-text">
                        ${car.description}</p>
                         <p class="group inner list-group-item-text">
                       Year: ${car.makeYear}</p>
                         <p class="group inner list-group-item-text">
                       Colors: ${car.colorsAvailable}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $${car.price}</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="${contextPath}/DeleteSelectedCar?id=${car.carID}">Delete Car</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         </c:forEach>
    </div>
</div>
		
						
					
	
	
  <jsp:include page="footer.jsp" />
</body>
</html>