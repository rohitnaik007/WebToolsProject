package com.carshop.mycarapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carshop.mycarapp.dao.CarDAO;
import com.carshop.mycarapp.dao.UserDAO;
import com.carshop.mycarapp.pojo.Car;
import com.carshop.mycarapp.pojo.User;
import com.carshop.mycarapp.exception.UserException;
import com.carshop.mycarapp.validator.UserValidator;


@Controller
@RequestMapping("/*")
public class UserController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@Autowired
	@Qualifier("carDao")
	CarDAO carDao;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToUserHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected String goToUserLoginPage(HttpServletRequest request) throws Exception {
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		
		try {

			System.out.print("loginUser");

			User u = userDao.get(request.getParameter("username"), request.getParameter("password"));
			
			if(u == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}
			
			session.setAttribute("user", u);
			
			return "home";

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}

	}
	

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	protected ModelAndView registerUserPage() throws Exception {
		System.out.print("registerUser");

		return new ModelAndView("register-user", "user", new User());

	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {

		validator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("register-user", "user", user);
		}

		try {

			System.out.print("registerNewUser");

			User u = userDao.register(user);
			
			request.getSession().setAttribute("user", u);
			
			return new ModelAndView("user-added-success", "user", u);

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		
	}
	@RequestMapping(value = "/searchCar", method = RequestMethod.GET)
	public String searchCar() {
	return "car-search";
	}

		@RequestMapping(value = "/searchCar", method = RequestMethod.POST)
		protected ModelAndView searchCarResults(HttpServletRequest request) throws Exception {
			String filter = (String) request.getParameter("rselection");
			ArrayList<Car> carList=null;
			if (filter == "" || filter == null) {
				return new ModelAndView("car-search", "error", "Invalid search parameters");
			} else {
				String searchQuery = request.getParameter("keyword");
				if (filter.equals("0")) {
					// Search by title
					//carList = (ArrayList<Car>) carDao.getMoviesFromTitle(searchQuery);
				} else if (filter.equals("1")) {
					// Search by actor
					//carList = (ArrayList<Car>) carDao.getMoviesFromActor(searchQuery);
				} else {
					// Search by actress
					//carList = (ArrayList<Car>) carDao.getMoviesFromActress(searchQuery);
				}
				return new ModelAndView("car-results", "resultList", carList);
			}
		}
		

}
