package com.org.bankmgmtSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.bankmgmtSystem.controller.UserController;
import com.org.bankmgmtSystem.dto.UserDto;
import com.org.bankmgmtSystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testEditUserDetails() throws Exception {
        // Mock the userDto and updatedUserDto
        UserDto userDto = new UserDto();
        // Set userDto properties

        UserDto updatedUserDto = new UserDto();
        // Set updatedUserDto properties
        
        // Mock the UserService method
        when(userService.editUserDetails(userDto)).thenReturn(updatedUserDto);

        // Perform the test
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("User details updated successfully"));

        // Verify the UserService method was called
        verify(userService).editUserDetails(userDto);
    }
}
