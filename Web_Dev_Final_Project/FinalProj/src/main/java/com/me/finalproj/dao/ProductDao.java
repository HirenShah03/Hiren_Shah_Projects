package com.me.finalproj.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.me.finalproj.exception.UserException;
import com.me.finalproj.pojo.Housing;
import com.me.finalproj.pojo.Product;

public class ProductDao extends DAO{
	public void addProduct(Product product) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");
			if(product.getUser().getRole().equalsIgnoreCase("admin"))
			{
				product.setStatus("approved");
			}
			else {
				product.setStatus("pending");
			}
			getSession().save(product);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public List<Product> getApproved() throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Product where status = :status");
			q.setString("status", "approved");
			List<Product> list = q.list();
			close();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not fetch products ");
		}
	}
	public List<Product> getSearched(String search) throws Exception {
		try {
			begin();
			Criteria  q = getSession().createCriteria(Product.class);
			q.add(Restrictions.like("title",search, MatchMode.ANYWHERE));
			q.add(Restrictions.eq("status", "approved"));
			List<Product> list = q.list();
			close();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not fetch housing ");
		}
	}
	public List<Product> getPending() throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Product where status = :status");
			q.setString("status", "pending");
			List<Product> list = q.list();
			close();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not fetch Products ");
		}
	}

	public boolean updateRequest(long id,String decision) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Product where id = :id");
			q.setLong("id", id);
			Product product = (Product) q.uniqueResult();
			if(product!=null){
				if(decision.equalsIgnoreCase("Accept"))
					product.setStatus("approved");
				else
					product.setStatus("rejected");

				getSession().update(product);
				commit();
				close();
				return true;
			}else{
				return false;
			}

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while updating product: " + e.getMessage());
		}
	
	}
	
	public List<Product> getFiltered(List filterlist) throws Exception {
		try {
			begin();
			Query query = getSession().createQuery("SELECT p FROM Product p JOIN p.categories c WHERE c.id in :filterlist and status = :status");
				query.setString("status", "approved");
				query.setParameter("filterlist", filterlist);
				List<Product> list = query.list();
			close();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not fetch Products ");
		}
	}

}
