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

	<h2>Search Cars</h2>

	<div width="100%">
	
		
		<c:if test="${not empty error}">
		<div class="error">${error}</div>
		</c:if>
		<form name='searchForm' method="post" action="searchCar">
			<p>
				Keyword: <input type="text" name="keyword" /><br /> <br />
			</p>
			<input TYPE="radio" name="rselection" value="0" />Search By Brand<br />
			<br /> <input TYPE="radio" name="rselection" value="1" />Search By
			Model<br /> <br /> <input TYPE="radio" name="rselection" value="2" />Search
			By Price<br /> <br /> <input type="submit" value="Search Car"
				style="background-color: #87CEFA;" "/>
		</form>
	</div>

	
  <jsp:include page="footer.jsp" />
</body>
</html>