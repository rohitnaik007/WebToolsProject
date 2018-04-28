package com.carshop.mycarapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carshop.mycarapp.dao.CarDAO;
import com.carshop.mycarapp.pojo.Car;

@Controller
public class AjaxController {
	
	@Autowired
	@Qualifier("carDao")
	CarDAO carDao;
	
	@RequestMapping(value = "/ajaxservice.htm")
	@ResponseBody
	public String ajaxService(HttpServletRequest request) throws Exception
	{
		String searchQuery = (String) request.getParameter("rselection");
		ArrayList<Car> carList=null;
		carList = (ArrayList<Car>) carDao.searchCar(searchQuery);
		
		return String.valueOf(carList.size());
	}


}
