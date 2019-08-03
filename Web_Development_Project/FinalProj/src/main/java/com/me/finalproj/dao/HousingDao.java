package com.me.finalproj.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.me.finalproj.exception.UserException;
import com.me.finalproj.pojo.Housing;

public class HousingDao extends DAO{

	public void addHousing(Housing housing) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");
			if(housing.getUser().getRole().equalsIgnoreCase("admin"))
			{
				housing.setStatus("approved");
			}
			else {
				housing.setStatus("pending");
			}
			getSession().save(housing);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	public List<Housing> getPending() throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Housing where status = :status");
			q.setString("status", "pending");
			List<Housing> list = q.list();
			close();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not fetch housing ");
		}
	}
	public List<Housing> getApproved() throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Housing where status = :status");
			q.setString("status", "approved");
			List<Housing> list = q.list();
			close();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not fetch housing ");
		}
	}

	public List<Housing> getSearched(String search) throws Exception {
		try {
			begin();
			Criteria  q = getSession().createCriteria(Housing.class);
			q.add(Restrictions.like("street",search, MatchMode.ANYWHERE));
			q.add(Restrictions.eq("status", "approved"));
			List<Housing> list = q.list();
			close();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not fetch housing ");
		}
	}

	public boolean updateRequest(long id,String decision) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Housing where id = :id");
			q.setLong("id", id);
			Housing housing = (Housing) q.uniqueResult();
			if(housing!=null){
				if(decision.equalsIgnoreCase("Accept"))
				housing.setStatus("approved");
				else
			    housing.setStatus("rejected");

				getSession().update(housing);
				commit();
				close();
				return true;
			}else{
				return false;
			}

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	
	}

}
