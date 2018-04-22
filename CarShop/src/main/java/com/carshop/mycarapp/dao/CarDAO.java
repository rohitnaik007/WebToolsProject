package com.carshop.mycarapp.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.carshop.mycarapp.exception.CarException;
import com.carshop.mycarapp.pojo.Car;


public class CarDAO extends DAO{

	public Car register(Car u)
			throws CarException {
		try {
			begin();
			System.out.println("inside DAO");
Car car = new Car();
			//Email email = new Email(u.getEmail().getEmailAddress());
			//Car Car = new Car(u.getCarname(), u.getPassword());

			//Car.setFirstName(u.getFirstName());
			//Car.setLastName(u.getLastName());
			//Car.setEmail(email);
			//email.setCar(Car);
			//getSession().save(Car);
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
	
	
	
	
}
