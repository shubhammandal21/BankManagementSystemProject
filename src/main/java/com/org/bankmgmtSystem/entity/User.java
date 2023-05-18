package com.org.bankmgmtSystem.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="user_id", length = 45)
	private int userid;
 
    @Column(name="user_name", length = 255)
    private String username;
 
    @Column(name="email", length = 255)
    private String email;
 
    @Column(name="password", length = 255)
    private String password;
    
    @Column(name="address", length = 255)
    private String address;
    
    @Column(name="country", length = 255)
    private String country;
    
    @Column(name="age")
    private int age;
    
    @Column(name="pan_number", length = 10)
    private String panNumber;
    
    @Column(name="account_type", length = 50)
    private String accountType;

	public User(int userid, String username, String email, String password, String address, String country, int age, String panNumber, String accountType) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.country = country;
		this.age = age;
		this.panNumber = panNumber;
		this.accountType = accountType;
	}

	public User() {
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", country=" + country + ", age=" + age + ", panNumber=" + panNumber
				+ ", accountType=" + accountType + "]";
	}
	
	// Generate a unique user ID using UUID
    private String generateUserId() {
        return UUID.randomUUID().toString();
    }
	
}
