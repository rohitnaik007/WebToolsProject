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
<div class="section">
		<!-- container -->
		<div class="container">
		<div class="col-md-4 col-sm-6">
						<div class="span3 well">
      <legend>${nouser}</legend>
    <form accept-charset="UTF-8" action="${contextPath}/login" method="post">		
        <input class="span3"  name="username" placeholder="Username" type="text"><br/><br/>
        <input class="span3"  name="password" placeholder="Password" type="password"> <br/><br/>
        <button class="btn btn-warning" type="submit">Login</button>
    </form>
</div>
</div></div>
</div>
  <jsp:include page="footer.jsp" />
</body>
</html>