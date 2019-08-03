package com.me.finalproj.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="housing")
public class Housing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="housingID", unique = true, nullable = false)
        private long id;

	@Column(name="title")
        private String title;

	@Column(name="aptno")
	private String aptNo;

	@Column(name="street")
	private String street;
	
	@Column(name="zipcode")
	private int zipcode;
	
	@Column(name="imagepath")
	private String imagepath;
	
	@Column(name="quotation")
	private int quotation;

	@Column(name="contactinfo")
	private String contactinfo;
	
	
	@ManyToOne
	private User user;

	@Column(name="status")
	private String status;

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	public String getAptNo() {
		return aptNo;
	}


	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


	public String getContactinfo() {
		return contactinfo;
	}


	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public int getQuotation() {
		return quotation;
	}


	public void setQuotation(int quotation) {
		this.quotation = quotation;
	}

}
