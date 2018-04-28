package com.carshop.mycarapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carshop.mycarapp.dao.CarDAO;
import com.carshop.mycarapp.pojo.Car;
import com.carshop.mycarapp.pojo.ShoppingCart;

@Controller
@RequestMapping("/*")
public class ShoppingCartController {

	@Autowired
	@Qualifier("carDao")
	CarDAO carDao;

	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public ModelAndView viewShoppingCart(HttpSession session) {
		ModelAndView mav = new ModelAndView("shopping-cart");
		mav.addObject("listCart", (List<ShoppingCart>) session.getAttribute("cart"));
		mav.addObject("totalAmount", getTotal((List<ShoppingCart>) session.getAttribute("cart")));
		return mav;
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	protected ModelAndView addToCart(HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("car id" + request.getParameter("id"));

		boolean isPresent = false;
		ModelAndView mav = new ModelAndView("shopping-cart");
		Car car = carDao.get(request.getParameter("id"));
		ShoppingCart cart = new ShoppingCart();
		List<ShoppingCart> list = (List<ShoppingCart>) session.getAttribute("cart");
		if (list == null) {
			list = new ArrayList<ShoppingCart>();
		}
		if (car != null) {

			for (ShoppingCart c : list) {
				if (c.getId() == car.getCarID()) {
					c.setQuantity(c.getQuantity() + 1);
					c.setAmount(c.getQuantity() * c.getPrice());
					isPresent = true;
				}
			}
			if (!isPresent) {

				cart.setId(car.getCarID());
				cart.setName(car.getBrand() + " " + car.getModelNo());
				cart.setColor(car.getColorsAvailable());
				cart.setPrice(car.getPrice());
				cart.setImageSrc(car.getImageSrc());
				cart.setQuantity(1);
				cart.setAmount(cart.getQuantity() * cart.getPrice());
				list.add(cart);
			}

			session.setAttribute("cart", list);
			mav.addObject("totalAmount", getTotal(list));
		}
		mav.addObject("listCart", list);

		return mav;
	}

	@RequestMapping(value = "/removeFromCart", method = RequestMethod.GET)
	protected ModelAndView removeFromCart(HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("car id" + request.getParameter("id"));

		ModelAndView mav = new ModelAndView("shopping-cart");
		int id = Integer.parseInt((request.getParameter("id").trim()));

		List<ShoppingCart> list = (List<ShoppingCart>) session.getAttribute("cart");

		if (null != list && list.size() > 0) {
			ShoppingCart temp = null;
			for (ShoppingCart c : list) {
				if (c.getId() == id) {
					c.setQuantity(c.getQuantity() - 1);
					if (c.getQuantity() == 0) {
						temp = c;
					}

				}

			}
			list.remove(temp);

			session.setAttribute("cart", list);
			mav.addObject("totalAmount", getTotal(list));
		}
		mav.addObject("listCart", list);

		return mav;
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
