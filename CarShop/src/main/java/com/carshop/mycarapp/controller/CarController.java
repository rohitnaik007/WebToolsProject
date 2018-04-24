package com.carshop.mycarapp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.carshop.mycarapp.dao.CarDAO;
import com.carshop.mycarapp.exception.CarException;
import com.carshop.mycarapp.pojo.Car;
import com.carshop.mycarapp.validator.CarValidator;



@Controller
@RequestMapping("/*")
public class CarController {

//	@Autowired
//	@Qualifier("userDao")
//	UserDAO userDao;
//
//	@Autowired
//	@Qualifier("userValidator")
//	UserValidator validator;
	
	@Autowired
	@Qualifier("carValidator")
	CarValidator carValidator;
	
	@Autowired
	@Qualifier("carDao")
	CarDAO carDao;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(carValidator);
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
					// Search by actresscae
					//carList = (ArrayList<Car>) carDao.getMoviesFromActress(searchQuery);
				}
				return new ModelAndView("car-results", "resultList", carList);
			}
		}
		
		@RequestMapping(value = "/addnewcar", method = RequestMethod.GET)
		protected ModelAndView adminAddNewCar() throws Exception {
			System.out.print("add new car");

			return new ModelAndView("add-new-car", "car", new Car());

		}
		@RequestMapping(value = "/addnewcar", method = RequestMethod.POST)
		protected ModelAndView adminAddNewCar(HttpServletRequest request,  @ModelAttribute("car") Car car, BindingResult result) throws Exception {

			carValidator.validate(car, result);

			if (result.hasErrors()) {
				return new ModelAndView("add-new-car", "car", car);
			}

			try {

				System.out.print("registerNewcar");				
				Car c = carDao.addcar(car);				
			
				request.getSession().setAttribute("car", c);
				
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
		public ModelAndView addCategory(HttpServletRequest request) throws Exception {

			try {			
				
				List<Car> cars = carDao.list();
				return new ModelAndView("all-cars", "cars", cars);
				
			} catch (CarException e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "error while login");
			}
			
			
		}
		

}
