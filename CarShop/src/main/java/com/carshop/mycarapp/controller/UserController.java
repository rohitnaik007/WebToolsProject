package com.carshop.mycarapp.controller;

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
import com.carshop.mycarapp.dao.RoleDAO;
import com.carshop.mycarapp.dao.UserDAO;
import com.carshop.mycarapp.exception.UserException;
import com.carshop.mycarapp.pojo.User;
import com.carshop.mycarapp.pojo.UserRole;
import com.carshop.mycarapp.validator.CarValidator;
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
	@Qualifier("carValidator")
	CarValidator carValidator;

	@Autowired
	@Qualifier("carDao")
	CarDAO carDao;

	@Autowired
	@Qualifier("roleDao")
	RoleDAO roleDao;

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

			User u = userDao.get(request.getParameter("username"), encrypt(request.getParameter("password"), 12));

			if (u == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}
			String role = roleDao.getRoleNameByUserId(u.getUserID());
			session.setAttribute("role", role);
			session.setAttribute("user", u);
			System.out.println(role);

			return "home";

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	protected String logoutUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			session.invalidate();

			return "home";

		} catch (Exception e) {
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
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("user") User user,
			BindingResult result) throws Exception {

		validator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("register-user", "user", user);
		}

		try {
			if (!userDao.checkIfUserExists(user)) {
				System.out.print("registerNewUser");

				user.setPassword(encrypt(request.getParameter("password"), 12));
				User u = userDao.register(user);

				UserRole ur = new UserRole();
				ur.setRole(roleDao.get("CUSTOMER"));
				ur.setUser(u);
				userDao.registerUserRole(ur);

				request.getSession().setAttribute("user", u);

				return new ModelAndView("user-added-success", "user", u);
			} else {
				return new ModelAndView("user-already-exists");
			}

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	public static String decrypt(String enc, int offset) {
		return encrypt(enc, 26 - offset);
	}

	public static String encrypt(String enc, int offset) {
		offset = offset % 26 + 26;
		StringBuilder encoded = new StringBuilder();
		for (char i : enc.toCharArray()) {
			if (Character.isLetter(i)) {
				if (Character.isUpperCase(i)) {
					encoded.append((char) ('A' + (i - 'A' + offset) % 26));
				} else {
					encoded.append((char) ('a' + (i - 'a' + offset) % 26));
				}
			} else {
				encoded.append(i);
			}
		}
		return encoded.toString();
	}
}
