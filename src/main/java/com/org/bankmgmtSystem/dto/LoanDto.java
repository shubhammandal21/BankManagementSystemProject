package com.org.bankmgmtSystem.dto;

public class LoanDto {

    private int loanId;
    private double loanAmt;
    private String loanType;
    private int duration;
    private double monthlyEMI;
    private int userid;

    public LoanDto(int loanId, double loanAmt, String loanType, int duration, double monthlyEMI, int userid) {
        this.loanId = loanId;
        this.loanAmt = loanAmt;
        this.loanType = loanType;
        this.duration = duration;
        this.monthlyEMI = monthlyEMI;
        this.userid = userid;
    }

    public LoanDto() {

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
        return "LoanDto [loanId=" + loanId + ", loanAmt=" + loanAmt + ", loanType=" + loanType + ", duration="
                + duration + ", monthlyEMI=" + monthlyEMI + ", userid=" + userid + "]";
    }
}
