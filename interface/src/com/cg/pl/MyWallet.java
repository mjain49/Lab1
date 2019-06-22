package com.cg.pl;
import com.cg.bean.*;
import com.cg.service.AccountService;
import com.cg.service.Gst;
public class MyWallet {
	
	 public static void main(String[] args) {
		// Account ob=new Account();
		 AccountService service=new AccountService();
		 
		 SavingAccount ob2=new SavingAccount(105,2222222,"Manijiri",55000.00);
		 service.printStatement(ob2); //calling default method of transaction
		 double b1=service.withdraw(ob2, 5000.00);
		 System.out.println("After withdraw balance is"+b1);
		 
		 double tax=service.calculateTax(Gst.PCT_5, b1);
		 System.out.println("GST is "+tax);
		 }
}
