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
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<h2>View Car Results</h2>

	<div width="100%">
	<h2>Searching Movies</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:choose>
			<c:when test="${fn:length(resultList) == 0}">No results were found for your search</c:when>
			<c:when test="${fn:length(resultList) != 0}">
				<h3>Your search resulted in ${fn:length(resultList)} hits:</h3>
				<table>
					<th>Image</th>
					<th>Brand</th>
					<th>ModelNo</th>
					<th>Description</th>
					<th>Price</th>
					
					<c:forEach items="${resultList}" var="item">
						<tr>
						<td>${item.imageSrc}</td>
							<td>${item.brand}</td>							
							<td>${item.modelNo}</td>
							<td>${item.description}</td>
							<td>${item.price}</td>							
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