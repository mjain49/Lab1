package com.cg.service;

import javax.naming.InsufficientResourcesException;

import com.cg.bean.Account;
import com.cg.exception.InsufficientFundException;

public class AccountService  implements Gst,Transaction{ //Alternate to multiple inheritance

	@Override
	public double withdraw(Account ob, double amount) throws InsufficientFundException {
		// TODO Auto-generated method stub
		double new_balance=ob.getBalance()-amount;
		if(new_balance<1000.00) {
			new_balance=ob.getBalance();
			throw new InsufficientFundException("Insufficient Fund,Cannot Process Request",new_balance);
			
			// throw new RuntimeException("InSufficient Balance:Cannot Process Withdrawl");
     		//	System.out.println("Insufficient Balance");
				}
				ob.setBalance(new_balance);
				return new_balance;
	}

	@Override
	public double deposit(Account ob, double amount) {
		// TODO Auto-generated method stub
		double new_balance=ob.getBalance()+amount;
		ob.setBalance(new_balance);
		return new_balance;
	}

	@Override
	public String transferMoney(Account from, Account to, double amount) {// INCOMPLETE
		// TODO Auto-generated method stub
		double new_balance=from.getBalance()-amount;
		if(new_balance<1000.00) {
			//new_balance=from.getBalance();
			System.out.println("Insufficient Balance");
			//from.setBalance(new_balance);
			return "Amount cannot be transfered insufficient balance";
		}
		from.setBalance(new_balance);
		double b2=to.getBalance()+amount;
		to.setBalance(b2);
		String ans="From Account: "+from.getAid()+" Balance: "+from.getBalance()+"\n"+"To Account: "+to.getAid()+" Balance "+to.getBalance();
		return ans;
	}

	@Override
	public double calculateTax(double PCT, double amount) {
		// TODO Auto-generated method stub
		return amount*Gst.PCT_5;
	}

}