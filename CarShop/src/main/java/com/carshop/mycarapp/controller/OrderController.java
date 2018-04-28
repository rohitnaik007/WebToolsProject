package com.carshop.mycarapp.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carshop.mycarapp.dao.OrderDAO;
import com.carshop.mycarapp.pojo.Order;
import com.carshop.mycarapp.pojo.OrderItems;
import com.carshop.mycarapp.pojo.ShoppingCart;
import com.carshop.mycarapp.pojo.User;

@Controller
@RequestMapping("/*")
public class OrderController {

	@Autowired
	@Qualifier("orderDao")
	OrderDAO orderDao;

	@RequestMapping(value = "/reviewOrder", method = RequestMethod.GET)
	public ModelAndView viewShoppingCart(HttpSession session) {

		User u = (User) session.getAttribute("user");

		if (u == null) {
			return new ModelAndView("login", "nouser", "Please login for proceeding to payment");
		} else {
			ModelAndView mav = new ModelAndView("review-order");
			mav.addObject("listCart", (List<ShoppingCart>) session.getAttribute("cart"));
			mav.addObject("totalAmount", getTotal((List<ShoppingCart>) session.getAttribute("cart")));
			return mav;
		}
	}

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	protected ModelAndView placeOrder(HttpServletRequest request, HttpSession session) throws Exception {
		try {
			User u = (User) session.getAttribute("user");

			Order o = new Order();
			List<ShoppingCart> list = (List<ShoppingCart>) session.getAttribute("cart");
			List<OrderItems> oItem = new ArrayList<>();
			Date d = new Date();
			o.setOrderplacedate(d.toString());
			o.setModeofdelivery(request.getParameter("shipping").toString());
			o.setShippingAddress(u.getAddress());
			o.setStatus("Open");
			o.setUser(u);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, 7); // add 7 days
			o.setDeliverydate(cal.getTime().toString());
			Order or = orderDao.addOrder(o);
			// o.setOrderItems(oItem);
			// o.set
			// orderDao.addOrder(o);

			for (ShoppingCart c : list) {
				OrderItems o1 = new OrderItems();
				o1.setCarID(c.getId());
				o1.setColor(c.getColor());
				o1.setPrice(c.getPrice());
				o1.setOrder(or);
				orderDao.addOrderItem(o1);
			}

			ModelAndView mav = new ModelAndView("view-invoice");
			mav.addObject("order", o);
			mav.addObject("totalAmount", getTotal((List<ShoppingCart>) session.getAttribute("cart")));
			session.removeAttribute("cart");
			// sendEmail(u.getEmail(), "Order Placed Successfully with Order #
			// "+or.getOrderID()+" and will be available on "+or.getDeliverydate());
			return mav;

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	int getTotal(List<ShoppingCart> list) {
		int total = 0;
		if (null != list && list.size() > 0) {
			for (ShoppingCart c : list) {

				total = total + c.getAmount();

			}
		}
		return total;
	}

}
