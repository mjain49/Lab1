package com.cg.bean;

public class SavingAccount extends Account{
	private double interest;
	private final double MIN_BALANCE=1000.00;
	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}
	public SavingAccount(int aid, int mobile, String accountholder, double balance) {
		super(aid, mobile, accountholder, balance);
		// TODO Auto-generated constructor stub
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest() {
		this.interest =super.getBalance()*0.04;
	}
	@Override
	public String toString() {
		return super.toString()+"SavingAccount [interest=" + interest + "]";
	}
	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		double new_balance=super.getBalance()-amount;
		if(new_balance<MIN_BALANCE)
		{
			new_balance=super.getBalance();
			System.out.println("Insufficient balance");
		}
		super.setBalance(new_balance);
		return new_balance;
	}
}
