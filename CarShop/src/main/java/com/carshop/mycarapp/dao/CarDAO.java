package com.carshop.mycarapp.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

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
	public void deleteCarById(String car) throws Exception {
		try {
			begin();
			 Car c = (Car )getSession().createCriteria(Car.class).add(Restrictions.eq("carID", Long.parseLong(car))).uniqueResult();
			 getSession().delete(c);

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

	public Car get(String parameter) throws Exception {
		// TODO Auto-generated method stub
		try {
			
            begin();
            Query q = getSession().createQuery("from Car C WHERE C.carID = "+ parameter);
            List<Car> car = q.list();
            commit();
            return car.get(0);
        } catch (HibernateException e) {
            rollback();
            throw new CarException("Car not found", e);
        }
	}
	
	
	
	public List<Car> searchCar(String parameter) throws Exception {
		// TODO Auto-generated method stub
		try {
			
            begin();
            Query q = getSession().createQuery("from Car C WHERE C.brand LIKE :parameter OR C.modelNo LIKE :parameter OR C.description LIKE :parameter");
            q.setString("parameter","%"+ parameter+"%");
            List<Car> car = q.list();
            commit();
            return car;
        } catch (HibernateException e) {
            rollback();
            throw new CarException("Car not found", e);
        }
	}

	public ArrayList<Car> getCarFromModel(String searchQuery) throws CarException {
try {
			begin();
            Query q = getSession().createQuery("from Car C WHERE C.modelNo LIKE :parameter");
            q.setString("parameter", "%"+searchQuery+"%");
            List<Car> car = q.list();
            commit();
            return (ArrayList<Car>) car;
        } catch (HibernateException e) {
            rollback();
            throw new CarException("Car not found", e);
        }
	}

	public ArrayList<Car> getCarFromBrand(String searchQuery) throws CarException {

try {
			begin();
            Query q = getSession().createQuery("from Car C WHERE C.brand LIKE :parameter");
            q.setString("parameter", "%"+searchQuery+"%");
            List<Car> car = q.list();
            commit();
            return (ArrayList<Car>) car;
        } catch (HibernateException e) {
            rollback();
            throw new CarException("Car not found", e);
        }
	
	}

	public ArrayList<Car> getCarFromPrice(String searchQuery) throws CarException {

try {
			begin();
            Query q = getSession().createQuery("from Car C WHERE C.price LIKE :parameter");
            q.setString("parameter", "%"+searchQuery+"%");
            List<Car> car = q.list();
            commit();
            return (ArrayList<Car>) car;
        } catch (HibernateException e) {
            rollback();
            throw new CarException("Car not found", e);
        }
		}
	
	
}
