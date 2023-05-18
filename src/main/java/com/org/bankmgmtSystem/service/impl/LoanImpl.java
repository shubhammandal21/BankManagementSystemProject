package com.org.bankmgmtSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bankmgmtSystem.dto.LoanDto;
import com.org.bankmgmtSystem.entity.Loan;
import com.org.bankmgmtSystem.repo.LoanRepo;
import com.org.bankmgmtSystem.service.LoanService;

@Service
public class LoanImpl implements LoanService {

	
	@Autowired
	private LoanRepo loanRepo;
	
	
	@Override
	public String applyLoan(LoanDto loanDto) {
		 Loan loan = new Loan(

	               loanDto.getLoanId(),
	               loanDto.getLoanAmt(),
	               loanDto.getLoanType(),
	               loanDto.getDuration(),
	               loanDto.getMonthlyEMI(),
	               loanDto.getUserid()
	               );
	       

	        loanRepo.save(loan);

	        return "Application Submited successfully!";
	}

}
