package com.me.finalproj.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.finalproj.exception.CategoryException;
import com.me.finalproj.pojo.Category;

public class CategoryDao extends DAO{

	public Category get(String name) throws CategoryException {
        try {
            begin();
            Query q=getSession().createQuery("from Category where name= :name");
            q.setString("name",name);
            Category category=(Category)q.uniqueResult();
            commit();
            close();
            return category;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not obtain the named category " + name + " " + e.getMessage());
        }
    }

    public List<Category> list() throws CategoryException {
        try {
            begin();
            Query q = getSession().createQuery("from Category");
            List<Category> list = q.list();
            commit();
            close();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not list the categories", e);
        }
    }

    public Category create(String name) throws CategoryException {
        try {
            begin();
            Category cat = new Category();
            cat.setName(name);
            getSession().save(cat);
            commit();
            return cat;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new CategoryException("Exception while creating category: " + e.getMessage());
        }
    }
    public void update(Category category) throws CategoryException {
        try {
            begin();
            getSession().update(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not save the category", e);
        }
    }

}
