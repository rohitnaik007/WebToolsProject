package com.carshop.mycarapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.carshop.mycarapp.exception.UserException;
import com.carshop.mycarapp.pojo.Role;


public class RoleDAO extends DAO {

	public RoleDAO() {
	}

	public Role get(String rolename) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Role where roleName = :rolename");
			 q.setString("rolename", rolename);
			Role role = (Role)  q.list().get(0);
			commit();
			return role;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + rolename, e);
		}
	}
		
}