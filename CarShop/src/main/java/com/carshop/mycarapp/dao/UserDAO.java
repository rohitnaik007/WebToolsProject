package com.carshop.mycarapp.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.carshop.mycarapp.exception.UserException;
import com.carshop.mycarapp.pojo.User;
import com.carshop.mycarapp.pojo.UserRole;


public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			User user = (User) q.list().get(0);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	public User get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userID= :userID");
			q.setInteger("userID", userId);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}

	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");
			Date d = new Date();	
			u.setUsercreationDate(d.toString());					
			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUsername(), e);
		}
	}
	
	public User getByEmailID(String emailId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where email= :emailId");
			q.setString("emailId", emailId);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get email " + emailId, e);
		}
	}

	public void registerUserRole(UserRole ur)
			throws UserException {
		try {
			begin();							
			getSession().save(ur);
			commit();	
			} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
}