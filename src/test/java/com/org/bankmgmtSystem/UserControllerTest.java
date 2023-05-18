package com.org.bankmgmtSystem;

import com.org.bankmgmtSystem.controller.UserController;
import com.org.bankmgmtSystem.dto.LoginDto;
import com.org.bankmgmtSystem.dto.UserDto;
import com.org.bankmgmtSystem.reponse.LoginResponse;
import com.org.bankmgmtSystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginUser() {
        // Mock loginDto
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("testuser@example.com");
        loginDto.setPassword("testpassword");

        // Mock loginResponse
        LoginResponse loginResponse = new LoginResponse("Login successful", true);

        // Mock the userService.loginUser() method
        when(userService.loginUser(loginDto)).thenReturn(loginResponse);

        // Call the loginUser() method in the UserController
        ResponseEntity<?> responseEntity = userController.loginUser(loginDto);

        // Verify that the userService.loginUser() method was called with the correct loginDto
        verify(userService, times(1)).loginUser(loginDto);

        // Verify the response status code and body
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(loginResponse, responseEntity.getBody());
    }

    @Test
    public void testEditUserDetails() {
        // Mock userDto
        UserDto userDto = new UserDto();
        userDto.setUserid(1);
        userDto.setUsername("Shubham Mandal");
        userDto.setEmail("shubham@example.com");
        userDto.setPassword("newpassword");
        userDto.setAddress("Hyderabad");
        userDto.setCountry("India");
        userDto.setAge(30);
        userDto.setPanNumber("ABCDE1234F");
        userDto.setAccountType("Savings");

        // Mock updatedUserDto
        UserDto updatedUserDto = new UserDto();
        updatedUserDto.setUserid(1);
        updatedUserDto.setUsername("Shubham Mandal");
        updatedUserDto.setEmail("shubham@example.com");
        updatedUserDto.setPassword("newpassword");
        updatedUserDto.setAddress("Hyderabad");
        updatedUserDto.setCountry("India");
        updatedUserDto.setAge(30);
        updatedUserDto.setPanNumber("ABCDE1234F");
        updatedUserDto.setAccountType("Savings");

        // Mock the userService.editUserDetails() method
        when(userService.editUserDetails(userDto)).thenReturn(updatedUserDto);

        // Call the editUserDetails() method in the UserController
        ResponseEntity<?> responseEntity = userController.editUserDetails(userDto);

        // Verify that the userService.editUserDetails() method was called with the correct userDto
        verify(userService, times(1)).editUserDetails(userDto);

        // Verify the response status code and body
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("User details updated successfully", responseEntity.getBody());
    }
    
    

}
