package com.org.bankmgmtSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bankmgmtSystem.dto.LoginDto;
import com.org.bankmgmtSystem.dto.UserDto;
import com.org.bankmgmtSystem.repo.UserRepo;
import com.org.bankmgmtSystem.reponse.LoginResponse;
import com.org.bankmgmtSystem.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/save")
	public String saveUser(@RequestBody UserDto userDto) {
		
		String id= userService.addUser(userDto);
		return id;
	}
	
	
	@PostMapping(path="/login")
	public ResponseEntity<?>loginUser(@RequestBody LoginDto loginDto){
		LoginResponse loginResponse = userService.loginUser(loginDto);
		return ResponseEntity.ok(loginResponse);
	}
	
	@PutMapping(path="/edit")
	public ResponseEntity<?> editUserDetails(@RequestBody UserDto userDto) {
	    UserDto updatedUserDto = userService.editUserDetails(userDto);
	    if (updatedUserDto != null) {
	        return ResponseEntity.ok("User details updated successfully");
	    } else {
	        return ResponseEntity.badRequest().build();
	    }
	}
	

}
