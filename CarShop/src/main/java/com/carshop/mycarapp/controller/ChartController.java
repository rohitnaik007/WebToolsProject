package com.carshop.mycarapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carshop.mycarapp.dao.CarDAO;
import com.carshop.mycarapp.dao.OrderDAO;
import com.carshop.mycarapp.exception.CarException;
import com.carshop.mycarapp.pojo.Car;
import com.carshop.mycarapp.pojo.OrderItems;

@Controller
public class ChartController {
	
	@Autowired
	@Qualifier("orderDao")
	OrderDAO orderDao;
	
	@Autowired
	@Qualifier("carDao")
	CarDAO carDao;
	
	@RequestMapping(value = "/getchart",method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) throws Exception {
		List<List<Map<Object, Object>>> canvasjsDataList = getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "order-chart";
	}

	public List<List<Map<Object, Object>>> getCanvasjsChartData() throws Exception {

		 Map<Object,Object> map = null;
		 List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		 List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		List <OrderItems> orderItems = orderDao.list();
		 Set<String> ar = new HashSet<String>();
//		for	(OrderItems or : orderItems)
//		{
//			ar.add(carDao.get(String.valueOf(or.getCarID())).getBrand().toString());
//		}
		
//		for (Iterator<String> it = ar.iterator(); it.hasNext(); ) {
//	        String f = it.next();
//	        map = new HashMap<Object,Object>(); map.put("label",f); 
//			map.put("y", 1);
     		map = new HashMap<Object,Object>(); map.put("label", "BMW"); map.put("y", 30);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "Mitsubishi"); map.put("y", 25);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "Audi"); map.put("y", 5);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "Mercedes"); map.put("y", 20);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "Volkswagon"); map.put("y", 10);dataPoints1.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "Mini"); map.put("y", 10);dataPoints1.add(map);

			dataPoints1.add(map);			
			list.add(dataPoints1);
		//}
		return list;
	}
	
}
