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
      <legend>Register a New User</legend>
    <form:form accept-charset="UTF-8" action="${contextPath}/register" commandName="user"
		method="post">		
      <table>
			<tr>
				<td>First Name:</td>
				<td><form:input  class="span3"  path="firstName" size="30" required="required" />
					<font color="red"><form:errors path="firstName" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input  class="span3"  path="lastName" size="30" required="required" />
					<font color="red"><form:errors path="lastName" /></font></td>
			</tr>


			<tr>
				<td>User Name:</td>
				<td><form:input  class="span3"  path="username" size="30" required="required" />
					<font color="red"><form:errors path="username" /></font></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password  class="span3"  path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>

			<tr>
				<td>Email Id:</td>
				<td><form:input  class="span3"  path="email" size="30"
						type="email" required="required" /> <font color="red"><form:errors
							path="email" /></font></td>
			</tr>
	<tr>
				<td>Address:</td>
				<td><form:input  class="span3"  path="address" size="30"
						 required="required" /> <font color="red"><form:errors
							path="address" /></font></td>
			</tr>
	<tr>
				<td>Phone:</td>
				<td><form:input  class="span3"  path="phone" size="30"
						required="required" /> <font color="red"><form:errors
							path="phone" /></font></td>
			</tr>

			<tr>
			<td colspan="2"> <button class="btn btn-warning" type="submit">Register User</button></td>
				
			</tr>
		</table>
    </form:form>
</div>
</div></div>
</div>
	
	
  <jsp:include page="footer.jsp" />
</body>
</html>