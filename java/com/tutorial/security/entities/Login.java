package com.tutorial.security.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Login implements Serializable {

	
	@NotEmpty
	@Column(nullable=false , length=45)
	private String email;
	
	@Id
	@NotEmpty
	@Column(nullable=false , length=64)
	private String series;
	
	@NotEmpty
	@Column(nullable=false , length=64)
	private String token;
	
	@NotEmpty
	@Column(nullable=false , length=64)
	private String last_used;

	public Login() {}
	
	public Login(String email, String series, String token, String last_used) {
		super();
		this.email = email;
		this.series = series;
		this.token = token;
		this.last_used = last_used;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLast_used() {
		return last_used;
	}

	public void setLast_used(String last_used) {
		this.last_used = last_used;
	}

	@Override
	public String toString() {
		return "Login [email=" + email + ", series=" + series + ", token=" + token + ", last_used=" + last_used + "]";
	}
	
	
	
	
	
}
