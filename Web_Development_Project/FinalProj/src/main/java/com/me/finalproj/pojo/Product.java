package com.me.finalproj.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id", unique = true, nullable = false)
        private long id;
	
	@Column(name="title")
        private String title;

	@Column(name="status")
        private String status;

 	@Column(name="quotation")
        private int quotation;

	@Column(name="description")
        private String description;
	
	@Column(name="imagepath")
	private String imagepath;

	@ManyToOne
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Category> categories = new HashSet<Category>();

	@Transient
	private String[] categoryArray;
	
	
	public String[] getCategoryArray() {
		return categoryArray;
	}

	public void setCategoryArray(String[] categoryArray) {
		this.categoryArray = categoryArray;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public int getQuotation() {
		return quotation;
	}

	public void setQuotation(int quotation) {
		this.quotation = quotation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	

}
