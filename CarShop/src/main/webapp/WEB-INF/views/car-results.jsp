<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register User</title>
</head>
<body>
  <jsp:include page="header.jsp" />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" /><div width="100%">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:choose>
			<c:when test="${fn:length(resultList) == 0}"><h2>No results were found for your search</h2></c:when>
			<c:when test="${fn:length(resultList) != 0}">
			<br/>
				<h3>Your search resulted in ${fn:length(resultList)} hits:</h3>
				<table class="table table-hover">
					
					<th>Brand</th>
					<th>ModelNo</th>
					<th>Description</th>
					<th>Price</th>
					<th>Make Year</th>
					
					<c:forEach items="${resultList}" var="item">
						<tr>
						
							<td>${item.brand}</td>							
							<td>${item.modelNo}</td>
							<td>${item.description}</td>
							<td>${item.price}</td>	
							<td>${item.makeYear}</td>						
						</tr>
					</c:forEach>
					<tr>

					</tr>
				</table>
			</c:when>
		</c:choose>
	</div>

	
  <jsp:include page="footer.jsp" />
</body>
</html>