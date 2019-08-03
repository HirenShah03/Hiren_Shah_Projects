package com.me.finalproj.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.finalproj.exception.UserException;
import com.me.finalproj.pojo.User;

public class UserDao extends DAO{
	
	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			User user = new User(u.getEmailId(),u.getUserName(),u.getPassword());
			user.setRole("user");
			user.setStatus(1); /////////to be changed
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userName = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);		
			System.out.println("username"+username+"password"+password);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	public boolean getUserName(String username) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userName = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			if(user!=null)
			return true;
			else
				return false;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}

}
