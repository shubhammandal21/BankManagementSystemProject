package com.org.bankmgmtSystem.service;

import com.org.bankmgmtSystem.dto.LoginDto;
import com.org.bankmgmtSystem.dto.UserDto;
import com.org.bankmgmtSystem.reponse.LoginResponse;


public interface UserService {

	String addUser(UserDto userDto);

	LoginResponse loginUser(LoginDto loginDto);	
    
	UserDto editUserDetails(UserDto userDto);


}
