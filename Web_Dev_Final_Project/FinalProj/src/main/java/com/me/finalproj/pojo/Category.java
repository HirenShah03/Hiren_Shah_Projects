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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="category")
public class Category {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryID", unique = true, nullable = false)
    private long categoryId;
	
	@Column(name="name", unique=true, nullable = false)
    private String name;
    
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (
       name="category_product_table",
       joinColumns = {@JoinColumn(name="categoryID", nullable = false, updatable = false)},
       inverseJoinColumns = {@JoinColumn(name="prod_id" )}
    )
	private Set<Product> products = new HashSet<Product>();

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
