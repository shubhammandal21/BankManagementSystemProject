package com.org.bankmgmtSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bankmgmtSystem.dto.LoanDto;
import com.org.bankmgmtSystem.dto.UserDto;
import com.org.bankmgmtSystem.service.LoanService;
import com.org.bankmgmtSystem.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {

	
	@Autowired
	private LoanService loanService;
	
	
	@PostMapping("/apply")
	public ResponseEntity<?> applyLoan(@RequestBody LoanDto loanDto) {
	    String result = loanService.applyLoan(loanDto);
	    if (result.equals("User not found")) {
	        return ResponseEntity.badRequest().body("User not found");
	    } else {
	        return ResponseEntity.ok(result);
	    }
	}


	}

