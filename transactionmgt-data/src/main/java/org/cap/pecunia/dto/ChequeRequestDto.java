package org.cap.pecunia.dto;

import java.util.Date;

public class ChequeRequestDto {
	private String transAccountId;
	private String accountNumber;
	private double transAmount;
	private String transType;
	private Integer chequeNum; 
	private Date chequeIssueDate;
	public String getTransAccountId() {
		return transAccountId;
	}
	public void setTransAccountId(String transAccountId) {
		this.transAccountId = transAccountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Integer getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(Integer chequeNum) {
		this.chequeNum = chequeNum;
	}
	public Date getChequeIssueDate() {
		return chequeIssueDate;
	}
	public void setChequeIssueDate(Date chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}
	
	
	

}
