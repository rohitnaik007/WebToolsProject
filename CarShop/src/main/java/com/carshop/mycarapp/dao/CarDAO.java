package com.carshop.mycarapp.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.carshop.mycarapp.exception.CarException;
import com.carshop.mycarapp.pojo.Car;


public class CarDAO extends DAO{

	public Car addcar(Car u)
			throws CarException {
		try {
			begin();
			System.out.println("inside car DAO");
			//Car car = new Car();
			//Email email = new Email(u.getEmail().getEmailAddress());
			Car car = new Car(u.getBrand(),u.getColorsAvailable(),u.getDescription(),u.getImageSrc(),u.getMakeYear(),u.getModelNo(),u.getPrice());

			//Car.setFirstName(u.getFirstName());
			//Car.setLastName(u.getLastName());
			//Car.setEmail(email);
			//email.setCar(Car);
			getSession().save(car);
			commit();
			return car;

		} catch (HibernateException e) {
			rollback();
			throw new CarException("Exception while creating Car: " + e.getMessage());
		}
	}

	public void delete(Car car) throws CarException {
		try {
			begin();
			getSession().delete(car);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new CarException("Could not delete Car ", e);
		}
	}

	
	 public List<Car> list() throws CarException{
	    	
	    	try {
	            begin();
	            Query q = getSession().createQuery("from Car");
	            List<Car> car = q.list();
	            commit();
	            return car;
	        } catch (HibernateException e) {
	            rollback();
	            throw new CarException("Car not found", e);
	        }
	    	
	    }
	
	
}
