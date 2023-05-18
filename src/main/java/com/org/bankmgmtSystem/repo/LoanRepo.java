package com.org.bankmgmtSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bankmgmtSystem.entity.Loan;


@Repository
public interface LoanRepo extends JpaRepository<Loan,Integer>{

}
