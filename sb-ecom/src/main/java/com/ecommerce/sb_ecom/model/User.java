package com.ecommerce.sb_ecom.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int userId;
	
	@NotBlank
	@Size(max=20)
	private String userName;
	
	@NotBlank
	@Size(max=50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max=100)
	
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	

	public User(int userId, @NotBlank @Size(max = 20) String userName, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 100) String password, Set<Role> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles= new HashSet<>();

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	
	
}
