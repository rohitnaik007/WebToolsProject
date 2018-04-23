package com.carshop.mycarapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")

public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userID", unique=true, nullable = false)
	private long userID;
	

	@Column(name = "userName")
	private String username;

	@Column(name = "password")
	private String password;	

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personID")
    private Person person;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleID")
    private Role role;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public Role getRoleID() {
		return role;
	}

	public void setRoleID(Role roleID) {
		this.role = roleID;
	}

	

	

	
}