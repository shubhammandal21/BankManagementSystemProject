package com.org.bankmgmtSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="loan")
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="loan_id", length = 45)
    private int loanId;

    @Column(name="loan_amt", length = 245)
    private double loanAmt;

    @Column(name="loan_type", length = 45)
    private String loanType;

    @Column(name="duration", length = 45)
    private int duration;

    @Column(name="monthly_emi", length = 45)
    private double monthlyEMI;

    @Column(name="userid", length = 45)
    private int userid;

    public Loan(int loanId, double loanAmt, String loanType, int duration, double monthlyEMI, int userid) {
        this.loanId = loanId;
        this.loanAmt = loanAmt;
        this.loanType = loanType;
        this.duration = duration;
        this.monthlyEMI = monthlyEMI;
        this.userid = userid;
    }

    public Loan() {

    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(double loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getMonthlyEMI() {
        return monthlyEMI;
    }

    public void setMonthlyEMI(double monthlyEMI) {
        this.monthlyEMI = monthlyEMI;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Loan [loanId=" + loanId + ", loanAmt=" + loanAmt + ", loanType=" + loanType + ", duration=" + duration
                + ", monthlyEMI=" + monthlyEMI + ", userid=" + userid + "]";
    }
}
