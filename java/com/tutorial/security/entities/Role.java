package com.tutorial.security.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Role implements Serializable {

	@Id
	@NotEmpty
	@Column(nullable=false , length=45)
	private String roleName;
	
	@NotEmpty
	@Column(nullable=false , length=45)
	private String roleMean;
	
	public Role() {
		
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	
	
	public Role(String roleName, String roleMean) {
		super();
		this.roleName = roleName;
		this.roleMean = roleMean;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleMean() {
		return roleMean;
	}

	public void setRoleMean(String roleMean) {
		this.roleMean = roleMean;
	}

	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", roleMean=" + roleMean + "]";
	}
	
	
	
}
