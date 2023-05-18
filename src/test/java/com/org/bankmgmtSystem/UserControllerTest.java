package com.org.bankmgmtSystem;

import com.org.bankmgmtSystem.controller.UserController;
import com.org.bankmgmtSystem.dto.LoginDto;
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
}
