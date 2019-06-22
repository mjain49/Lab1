package com.cg.pl;
import com.cg.bean.*;
public class MyWallet {
	
	 public static void main(String[] args) {
		// Account ob=new Account();
		 
		 
		 Account ob1=new SavingAccount(101,2222222,"Raja",25000.00);
		 //ob1.setInterest();
		 System.out.println(ob1);
		 double b1=ob1.withdraw(24500.00);
		 System.out.println(b1);
		 
		 SavingAccount s1=(SavingAccount) ob1;
		 s1.setInterest();
		 System.out.println(ob1);
		 
		 SavingAccount ob2=new SavingAccount(101,2222222,"Manijiri",55000.00);
		 printAcc(ob2);
		 System.out.println((ob2 instanceof SavingAccount));
		 System.out.println((ob2 instanceof Account));
		 System.out.println((ob2 instanceof Object));
	 }
     public static void printAcc(Account a)
     {
    	 System.out.println(a);
     }
}
