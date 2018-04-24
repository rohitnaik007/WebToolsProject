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
    						<div class="col-md-12">
						<div class="order-summary clearfix">
							<div class="section-title">
								<h3 class="title">Cart Items</h3>
							</div>
							<table class="shopping-cart-table table">
								<thead>
									<tr>
										<th>Product</th>
										<th></th>
										<th class="text-center">Price</th>
										<th class="text-center">Quantity</th>
										<th class="text-center">Total</th>
										<th class="text-right"></th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="cart" items="${listCart}">
									<tr>
										<td class="thumb"><img src="${cart.imageSrc}" alt=""></td>
										<td class="details">
											<a href="#">${cart.name}</a>
											<ul>
												<li><span>Color: ${cart.name}</span></li>
											</ul>
										</td>
										<td class="price text-center"><strong>$ ${cart.price}</strong></td>
										<td class="qty text-center"><input class="input" type="number" value="${cart.quantity}"></td>
										<td class="total text-center"><strong class="primary-color">$ ${cart.price}</strong></td>
										<td class="text-right"><a href="${contextPath}/removeFromCart?id=${cart.id}"><button class="main-btn icon-btn"><i class="fa fa-close"></i></button></a></td>
									</tr>	
									 </c:forEach>								
								</tbody>
								<tfoot>
									<tr>
										<th class="empty" colspan="3"></th>
										<th>SUBTOTAL</th>
										<th colspan="2" class="sub-total">$97.50</th>
									</tr>
									<tr>
										<th class="empty" colspan="3"></th>
										<th>SHIPING</th>
										<td colspan="2">Free Shipping</td>
									</tr>
									<tr>
										<th class="empty" colspan="3"></th>
										<th>TOTAL</th>
										<th colspan="2" class="total">$97.50</th>
									</tr>
								</tfoot>
							</table>
							<div class="pull-right">
								<button class="primary-btn">Place Order</button>
							</div>
						</div>

					</div>
</div>
		
						
					
	
	
  <jsp:include page="footer.jsp" />
</body>
</html>