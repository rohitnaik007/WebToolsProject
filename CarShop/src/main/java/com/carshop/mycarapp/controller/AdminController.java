package com.carshop.mycarapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carshop.mycarapp.dao.CarDAO;
import com.carshop.mycarapp.dao.RoleDAO;
import com.carshop.mycarapp.dao.UserDAO;
import com.carshop.mycarapp.exception.CarException;
import com.carshop.mycarapp.pojo.Car;
import com.carshop.mycarapp.validator.CarValidator;

@Controller
@RequestMapping("/*")
public class AdminController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("carValidator")
	CarValidator carValidator;

	@Autowired
	@Qualifier("carDao")
	CarDAO carDao;

	@Autowired
	@Qualifier("roleDao")
	RoleDAO roleDao;

	@RequestMapping(value = "/addnewcar", method = RequestMethod.GET)
	protected ModelAndView adminAddNewCar() throws Exception {
		System.out.print("add new car");

		return new ModelAndView("add-new-car", "car", new Car());

	}

	@RequestMapping(value = "/addnewcar", method = RequestMethod.POST)
	protected ModelAndView adminAddNewCar(HttpServletRequest request, @ModelAttribute("car") Car car,
			BindingResult result) throws Exception {

		carValidator.validate(car, result);

		if (result.hasErrors()) {
			return new ModelAndView("add-new-car", "car", car);
		}

		try {

			System.out.print("registerNewcar");
			Car c = carDao.addcar(car);
			return new ModelAndView("car-added-success", "car", c);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	protected String adminHome(HttpServletRequest request) throws Exception {
		return "adminhome";
	}

	@RequestMapping(value = "/allCars", method = RequestMethod.GET)
	public ModelAndView viewCars(HttpServletRequest request) throws Exception {

		try {

			List<Car> cars = carDao.list();
			return new ModelAndView("all-cars", "cars", cars);

		} catch (CarException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	@RequestMapping(value = "/DeleteCar", method = RequestMethod.GET)
	public ModelAndView deleteCars(HttpServletRequest request) throws Exception {

		try {

			List<Car> cars = carDao.list();
			return new ModelAndView("delete-car", "cars", cars);

		} catch (CarException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	@RequestMapping(value = "/DeleteSelectedCar", method = RequestMethod.GET)
	public ModelAndView deleteSeletedCars(HttpServletRequest request) throws Exception {

		try {
			carDao.deleteCarById(request.getParameter("id"));

			return new ModelAndView("car-deleted-successfully");

		} catch (CarException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

}
