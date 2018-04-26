package com.carshop.mycarapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.engine.jdbc.Size;

import com.carshop.mycarapp.exception.UserException;
import com.carshop.mycarapp.pojo.Role;
import com.carshop.mycarapp.pojo.UserRole;


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
	
//	public Role getRoleNameByUserId(long l) throws UserException {
//		try {
//			begin();
//			Role role = null;
//			Query q = getSession().createQuery("from Role where roleID = (select roleID  )");
//			 q.setParameter("userId", l);
//			 if(q.list().size()>0) {
//			 role = (Role)  q.list().get(0);}
//			commit();
//			return role;
//		} catch (HibernateException e) {
//			rollback();
//			throw new UserException("Could not get role " + l, e);
//		}
//	}
	
	public String getRoleNameByUserId(long l) throws UserException {
		try {
			begin();
			UserRole role = null;
			Query q = getSession().createQuery("from UserRole where userID = :userId )");
			 q.setParameter("userId", l);
			 if(q.list().size()>0) {
			 role = (UserRole)  q.list().get(0);}
			commit();
			return role.getRole().getRoleName();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get role " + l, e);
		}
	}
		
}