package com.example.tuneHub.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String username;
	String email;
	String password;
	String role;
	String gender;
	String address;
	boolean isPremium;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param username
	 * @param email
	 * @param password
	 * @param role
	 * @param gender
	 * @param address
	 * @param isPremium
	 */
	public Users(int id, String username, String email, String password, String role, String gender, String address,
			boolean isPremium) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.address = address;
		this.isPremium = isPremium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	@Override
	public String toString() {
		return "Users [address=" + address + ", email=" + email + ", gender=" + gender + ", id=" + id + ", isPremium="
				+ isPremium + ", password=" + password + ", role=" + role + ", username=" + username + "]";
	}
	

	

	

	
	

	

}
