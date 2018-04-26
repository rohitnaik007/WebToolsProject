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
<br/>	<div width="100%">
	<div class="section">
		<!-- container -->
		<div class="container">
		
		<c:if test="${not empty error}">
		<div class="error">${error}</div>
		</c:if>
		<div class="col-md-4 col-sm-6">
						<div class="span3 well">
		<form name='searchForm' method="post" action="searchCar">
		<h2>Search Cars</h2><br/>
			<p>
				Keyword: <input type="text" name="keyword" /><br /> <br />
			</p>
			<input TYPE="radio" name="rselection" value="0"  class="span3" checked/>Search By Brand<br />
			<br /> <input TYPE="radio" name="rselection" value="1"  class="span3" />Search By
			Model<br /> <br /> <input TYPE="radio" name="rselection" value="2"  class="span3" />Search
			By Price<br /> <br /> 
				   <button class="btn btn-warning" type="submit">Search Car</button>
		</form>
		</div>
	</div>
	</div>
		</div>
	</div>

	
  <jsp:include page="footer.jsp" />
</body>
</html>