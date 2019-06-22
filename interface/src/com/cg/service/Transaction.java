package com.cg.service;
import com.cg.bean.Account;

public interface Transaction {
	public double withdraw(Account ob,double amount);
	public double deposite(Account ob,double amount);
    public double transferMoney(Account from,Account to,double amount);
    
    public default void printStatement(Account ob)
    {
    	System.out.println("                ");
    	System.out.println("Statement for Account No"+ob.getAid());
    	System.out.println("Account Holder"+ob.getAccountholder());
    	System.out.println("balance is= "+ob.getBalance());
    	System.out.println("                ");
    }
}
