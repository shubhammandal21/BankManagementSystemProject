package com.org.bankmgmtSystem;

import com.org.bankmgmtSystem.controller.UserController;
import com.org.bankmgmtSystem.controller.LoanController;
import com.org.bankmgmtSystem.dto.LoginDto;
import com.org.bankmgmtSystem.dto.UserDto;
import com.org.bankmgmtSystem.entity.User;
import com.org.bankmgmtSystem.entity.Loan;
import com.org.bankmgmtSystem.dto.LoanDto;

import com.org.bankmgmtSystem.reponse.LoginResponse;
import com.org.bankmgmtSystem.service.LoanService;
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
    
    @Mock
    private LoanService loanService;

    @InjectMocks
    private UserController userController;

    @InjectMocks
    private LoanController loanController;

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
    @Test
    public void testSaveUser() {
        // Mock userDto
        UserDto userDto = new UserDto();
        userDto.setUserid(1);
        userDto.setUsername("Shubham");
        userDto.setEmail("shubham@example.com");
        userDto.setPassword("password123");
        userDto.setAddress("Kolkata");
        userDto.setCountry("India");
        userDto.setAge(30);
        userDto.setPanNumber("ABCDE1234F");
        userDto.setAccountType("Savings");

        // Mock the userService.addUser() method
        when(userService.addUser(userDto)).thenReturn("1");

        // Call the saveUser() method in the UserController
        String response = userController.saveUser(userDto);

        // Verify that the userService.addUser() method was called with the correct userDto
        verify(userService, times(1)).addUser(userDto);

        // Verify the response
        assertEquals("1", response);
    }
    
    
    //User Entity Test Case
    
//    @Test
//    public void testUserEntity() {
//        // Create a user object using the constructor with arguments
//        User user1 = new User(1, "Shubham", "shubham@example.com", "password123", "Kolkata",
//                "India", 22, "ABCDE1234F", "Savings");
//
//        // Verify the values of the user object
//        assertEquals(1, user1.getUserid());
//        assertEquals("Shubham", user1.getUsername());
//        assertEquals("shubham@example.com", user1.getEmail());
//        assertEquals("password123", user1.getPassword());
//        assertEquals("Kolkata", user1.getAddress());
//        assertEquals("India", user1.getCountry());
//        assertEquals(22, user1.getAge());
//        assertEquals("ABCDE1234F", user1.getPanNumber());
//        assertEquals("Savings", user1.getAccountType());
//
//        // Create a user object using the default constructor and setter methods
//        User user2 = new User();
//        user2.setUserid(2);
//        user2.setUsername("shubham");
//        user2.setEmail("shubham@example.com");
//        user2.setPassword("password456");
//        user2.setAddress("Kolkata");
//        user2.setCountry("India");
//        user2.setAge(25);
//        user2.setPanNumber("FGHIJ5678K");
//        user2.setAccountType("Salary");
//
//        // Verify the values of the user object
//        assertEquals(2, user2.getUserid());
//        assertEquals("shubham", user2.getUsername());
//        assertEquals("shubham@example.com", user2.getEmail());
//        assertEquals("password456", user2.getPassword());
//        assertEquals("Kolkata", user2.getAddress());
//        assertEquals("India", user2.getCountry());
//        assertEquals(25, user2.getAge());
//        assertEquals("FGHIJ5678K", user2.getPanNumber());
//        assertEquals("Salary", user2.getAccountType());
//    }
    
    
    
    
    
    @Test
    public void testApplyLoan() {
        // Mock loanDto
        LoanDto loanDto = new LoanDto();
        loanDto.setLoanId(1);
        loanDto.setLoanAmt(10000.0);
        loanDto.setLoanType("Personal");
        loanDto.setDuration(12);
        loanDto.setMonthlyEMI(1000.0);
        loanDto.setUserid(1);

        // Mock result message
        String resultMessage = "Loan application submitted successfully";

        // Mock the loanService.applyLoan() method
        when(loanService.applyLoan(loanDto)).thenReturn(resultMessage);

        // Call the applyLoan() method in the LoanController
        ResponseEntity<?> responseEntity = loanController.applyLoan(loanDto);

        // Verify that the loanService.applyLoan() method was called with the correct loanDto
        verify(loanService, times(1)).applyLoan(loanDto);

        // Verify the response status code and body
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(resultMessage, responseEntity.getBody());
    } 
    
    //@Test
   // public void testLoginDtoConstructor() {
        // Create test data
     //   String email = "testuser@example.com";
     //   String password = "testpassword";

        // Create a LoginDto using the constructor
     //   LoginDto loginDto = new LoginDto(email, password);

        // Verify the values are set correctly
     //   assertEquals(email, loginDto.getEmail());
     //   assertEquals(password, loginDto.getPassword());
  //  }
    

   
    
    

}
