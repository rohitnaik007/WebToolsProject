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
					// Search by Brand
					//carList = (ArrayList<Car>) carDao.getCarFromBrand(searchQuery);
				} else if (filter.equals("1")) {
					// Search by Model
					carList = (ArrayList<Car>) carDao.getMoviesFromModel(searchQuery);
				} else {
					// Search by Price
					//carList = (ArrayList<Car>) carDao.getMoviesFromPrice(searchQuery);
				}
				return new ModelAndView("car-results", "resultList", carList);
			}
		}
		
	
			@RequestMapping(value = "/searchCarNow", method = RequestMethod.POST)
			protected ModelAndView searchCarNow(HttpServletRequest request) throws Exception {
				String searchQuery = (String) request.getParameter("rselection");
				ArrayList<Car> carList=null;
				carList = (ArrayList<Car>) carDao.searchCar(searchQuery);
				return new ModelAndView("car-results", "resultList", carList);
				}
		

		

}
