package com.dto;
import java.io.Serializable;

public class CustomerDTO implements Serializable{
	private int accno;
	private String cname;
	private double balance;
	public String phone;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int string) {
		this.accno = string;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public void (int int1) {
		// TODO Auto-generated method stub
		
//	}
	@Override
	public String toString() {
		return "CustomerDTO [accno=" + accno + ", cname=" + cname
				+ ", balance=" + balance + ", phone=" + phone + "]";
	}
	
	

}
