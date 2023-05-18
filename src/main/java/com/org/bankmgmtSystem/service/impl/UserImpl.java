package com.org.bankmgmtSystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.bankmgmtSystem.dto.LoginDto;
import com.org.bankmgmtSystem.dto.UserDto;
import com.org.bankmgmtSystem.entity.User;
import com.org.bankmgmtSystem.repo.UserRepo;
import com.org.bankmgmtSystem.reponse.LoginResponse;
import com.org.bankmgmtSystem.service.UserService;

@Service
public class UserImpl implements UserService {
    
    @Autowired
    private UserRepo userRepo; 
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
            userDto.getUserid(),
            userDto.getUsername(),
            userDto.getEmail(),
            this.passwordEncoder.encode(userDto.getPassword()),
            userDto.getAddress(),
            userDto.getCountry(),
            userDto.getAge(),
            userDto.getPanNumber(),
            userDto.getAccountType()

            
        );

        userRepo.save(user);

        return user.getUsername();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }

    @Override
    public UserDto editUserDetails(UserDto userDto) {
        User existingUser = userRepo.findById(userDto.getUserid()).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(userDto.getUsername());
            existingUser.setEmail(userDto.getEmail());
            existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
            existingUser.setAddress(userDto.getAddress());
            existingUser.setCountry(userDto.getCountry());
            existingUser.setAge(userDto.getAge());
            existingUser.setPanNumber(userDto.getPanNumber());
            existingUser.setAccountType(userDto.getAccountType());

            User updatedUser = userRepo.save(existingUser);
            return convertToDto(updatedUser);
        } else {
            throw new IllegalArgumentException("User not found with userid: " + userDto.getUserid());
        }
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserid(user.getUserid());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(passwordEncoder.encode(user.getPassword()));
        userDto.setAddress(user.getAddress());
        userDto.setCountry(user.getCountry());
        userDto.setAge(user.getAge());
        userDto.setPanNumber(user.getPanNumber());
        userDto.setAccountType(user.getAccountType());
        return userDto;
    }





}
