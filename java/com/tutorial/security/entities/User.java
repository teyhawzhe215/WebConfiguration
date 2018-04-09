package com.tutorial.security.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User implements Serializable {
	
	@Id
	@NotEmpty
	@Column(nullable=false , length=45)
	private String email;
	@NotEmpty
	@Column(nullable=false , length=45)
	private String name;

	@NotEmpty
	private String sex;
	
	@NotEmpty
	@Column(nullable=false , length=45)
	private String tel;
	
	@NotEmpty
	@Column(nullable=false , length=45)
	private String address;
	
	
	public User() {}

	public User(String email) {
		super();
		this.email = email;
	}

	public User(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}

	public User(String email, String name, String sex) {
		super();
		this.email = email;
		this.name = name;
		this.sex = sex;
	}


	public User(String email, String name, String sex,String tel) {
		super();
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
	}

	
	
	public User(String email, String name, String sex, String tel, String address) {
		super();
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}




	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	 

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", sex=" + sex  + ", tel=" + tel
				+ ", address=" + address + ", password=" + password + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String password;
	
}
