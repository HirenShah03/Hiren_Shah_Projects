package com.me.finalproj.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
@PrimaryKeyJoinColumn(name = "id")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private long id;
	
	public User(String emailid,String username,String password) {
		this.emailId=emailid;
		this.userName=username;
		this.password=password;
	}
	public User() {
		
	}
	@Column(name = "emailid")
	private String emailId;
	
	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name="status")
	private int status;
	
	@Column(name = "role")
	private String role;
	
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
}
