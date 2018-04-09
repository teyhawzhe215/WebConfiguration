package com.tutorial.security.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user_role")
public class UserRole {
	
	@Id
	@NotEmpty
	@Column(nullable=false , length=45)
	private String email;
	
	@NotEmpty
	@Column(nullable=false , length=45,name="role_name")
	private String roleName;
	
	public UserRole() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [email=" + email + ", roleName=" + roleName + "]";
	}
	
	
	
}
