package com.org.bankmgmtSystem.dto;

import jakarta.persistence.Column;

public class UserDto {
	
	private int userid;
    private String username;
    private String email;
    private String password;
    private String address;
    private String country;
    private int age;
    private String panNumber;
    private String accountType;

    public UserDto(int userid, String username, String email, String password, String address, String country, int age, String panNumber, String accountType) {
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

    public UserDto() {
		
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
		return "UserDto [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
                + ", address=" + address + ", country=" + country + ", age=" + age + ", panNumber=" + panNumber 
                + ", accountType=" + accountType + "]";
	}	
	
	
}
