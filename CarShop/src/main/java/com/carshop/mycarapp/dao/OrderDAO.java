package com.carshop.mycarapp.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.carshop.mycarapp.exception.CarException;
import com.carshop.mycarapp.pojo.Car;
import com.carshop.mycarapp.pojo.Order;
import com.carshop.mycarapp.pojo.OrderItems;


public class OrderDAO extends DAO{

	public Order addOrder(Order order)
			throws CarException {
		try {
			begin();
			System.out.println("inside car DAO");
			getSession().save(order);
			commit();
			return order;

		} catch (HibernateException e) {
			rollback();
			throw new CarException("Exception while creating Car: " + e.getMessage());
		}
	}

	public OrderItems addOrderItem(OrderItems orderItems)
			throws CarException {
		try {
			begin();
			System.out.println("inside orderItems DAO");
			getSession().save(orderItems);
			commit();
			return orderItems;

		} catch (HibernateException e) {
			rollback();
			throw new CarException("Exception while creating Car: " + e.getMessage());
		}
	}
	
	public List<OrderItems> list() throws CarException{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from OrderItems");
            List<OrderItems> car = q.list();
            commit();
            return car;
        } catch (HibernateException e) {
            rollback();
            throw new CarException("Car not found", e);
        }
    	
    }
	
}
