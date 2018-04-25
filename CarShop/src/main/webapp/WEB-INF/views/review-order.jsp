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
<title>Review Order</title>
</head>
<body>
  <jsp:include page="header.jsp" />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 <form accept-charset="UTF-8" action="${contextPath}/placeOrder" method="post" class="clearfix">		
	 <div class="container">
	 <br/>
	 
	 <div class="row">
			
					<div class="col-md-6">
						<div class="billing-details">							
							<div class="section-title">
								<h3 class="title">Billing Details</h3>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="first-name" placeholder="First Name">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="last-name" placeholder="Last Name">
							</div>
							<div class="form-group">
								<input class="input" type="email" name="email" placeholder="Email">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="address" placeholder="Address">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="phone" placeholder="Phone">
							</div>	
						</div>
					</div>

					<div class="col-md-6">
						<div class="shiping-methods">
							<div class="section-title">
								<h4 class="title">Shipping Methods</h4>
							</div>
							<div class="input-checkbox">
								<input type="radio" name="shipping" id="shipping-1" checked>
								<label for="shipping-1">Free Shipment to Address</label>
								<div class="caption">
									<p>Will Ship the car/cars to address specified in seven days.
										<p>
								</div>
							</div>
							<div class="input-checkbox">
								<input type="radio" name="shipping" id="shipping-2">
								<label for="shipping-2">Store Pickup</label>
								<div class="caption">
									<p>Pickup the car/cars from our store at 360 Huntington Ave, Boston - 02115, Massachussets, USA.
										<p>
								</div>
							</div>
						</div>

						<div class="payments-methods">
							<div class="section-title">
								<h4 class="title">Payments Information</h4>
							</div>
							<div class="form-group">
								<div class="input-checkbox">
								<input type="radio" name="visa" id="visa" checked>
								<label for="shipping-1">Visa</label>
								
								<div class="input-checkbox">
								<input type="radio" name="mastercard" id="mastercard" checked>
								<label for="shipping-1">MasterCard</label>
								
							</div>
							</div>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="cvv" placeholder="CVV">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="nameoncard" placeholder="Name On Card">
							</div>
							<div class="form-group">
								<input class="input" type="text" name="month" placeholder="Month/Year of Expiry">
							</div>
						</div>
					</div>
				</form>
			</div>
			<!-- /row -->
	 
    <div class="well well-sm">
        <strong>Order Review</strong>
    </div>
    						<div class="col-md-12">
						<div class="order-summary clearfix">
							
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
										<td class="qty text-center"><strong>${cart.quantity}</strong></td>
										<td class="total text-center"><strong class="primary-color">$ ${cart.amount}</strong></td>
										<td class="text-right"><a href="${contextPath}/removeFromCart?id=${cart.id}"><button class="main-btn icon-btn"><i class="fa fa-close"></i></button></a></td>
									</tr>	
									 </c:forEach>								
								</tbody>
								<tfoot>
									<tr>
										<th class="empty" colspan="3"></th>
										<th>TOTAL</th>
										<th colspan="2" class="total">$ ${totalAmount}</th>
									</tr>
								</tfoot>
							</table>
							<div class="pull-right">
							<c:if test="${totalAmount != 0}">							
							  <button class="primary-btn" type="submit">Place Order</button>
								</c:if>
							</div>
							
						</div>

					</div>
</div>
</form>
		
			<br/>		
					
	
	
  <jsp:include page="footer.jsp" />
</body>
</html>