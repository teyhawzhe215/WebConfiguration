package com.tutorial.security.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userandpass implements Serializable {

	@Id
	@Column(nullable=false , length=45)
	private String email;
	
	@Column(nullable=false , length=100)
	private String password;
	
	public Userandpass() {}

	public Userandpass(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Userandpass [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
