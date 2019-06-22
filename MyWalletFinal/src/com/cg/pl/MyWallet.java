package com.cg.pl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.bean.*;
import com.cg.exception.InsufficientFundException;
import com.cg.service.AccountService;
import com.cg.service.Gst;
import com.cg.service.Validator;
public class MyWallet {

	public static void main(String[] args) throws InsufficientFundException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		AccountService ser=new AccountService();
		
		
		while(true)
		 {
		 String choice="";
		 System.out.println("Menu");
		 System.out.println("========");
		 System.out.println("1.Create New Account");
		 System.out.println("2.Find Account");
		 System.out.println("3.Delete Existing Account");
		 System.out.println("4.WithDraw");
		 System.out.println("5.Deposit");
		 System.out.println("6.Display");
		 System.out.println("7.Exit");
		 System.out.println("Enter Your Choice");
		 choice=br.readLine();
		 
		 
		 switch(choice)
		 	{
		 	case "1"://Create New Account
		 			int id=0;
		 			long mb=0L;
		 			String ah="";
		 			double bal=0.0;
		 			
		 		//Accepting and validating input for Account Number
		 		System.out.println("Enter Account Number");
	 			  while(true)
	 			  {
	 				  String s_id=br.readLine();
	 				  boolean ch1=Validator.validatedata(s_id, Validator.aidpattern);
	 				  if(ch1==true)
	 				  {
	 					  try 
	 					  {
	 						id=Integer.parseInt(s_id); 
	 						break;
	 					  }
	 					  catch(NumberFormatException e)
	 					  {
	 						  System.out.println("Account Number Must Be Numeric. Re Enter");
	 					  }
	 				  }
	 				  else
	 				  {
	 					  System.out.println("Re Enter Account Number in 3 digits");
	 				  }
	 			  }// end of account number while
	 			  
	 			//Accept Mpobile Number
	 				System.out.println("Enter Mobile Number");
					  while(true)
					  {
						  String s_mb=br.readLine();
						  boolean ch1=Validator.validatedata(s_mb, Validator.mobilepattern);
						  if(ch1==true)
						  {
							  try 
							  {
								mb=Long.parseLong(s_mb); 
								break;
							  }
							  catch(NumberFormatException e)
							  {
								  System.out.println("Mobile Number Must Be Numeric and 0f 10 number. Re Enter");
							  }
						  }
						  else
						  {
							  System.out.println("Re Enter Mobile Number in 10 digits");
						  }
					  }// end of mobile number while
					  
					  //Accepting And Validating Account Holder 
					  System.out.println("Enter Account Holder Name");
					  while(true)
					  {
						  String s_ah=br.readLine();
						  boolean ch1=Validator.validatedata(s_ah, Validator.namepattern);
						  if(ch1==true)
						  {
							  try 
							  {
								ah=s_ah;
								break;
							  }
							  catch(NumberFormatException e)
							  {
								  System.out.println("Wrong Name Re Enter");
							  }
						  }
						  else
						  {
							  System.out.println("Re Enter Holder Name");
						  }
					  }
					  
					  System.out.println("Enter Initial Balance");
					  while(true)
					  {
						  String s_bal=br.readLine();
						  
						  try {
							  bal=Double.parseDouble(s_bal);
						  }
						  catch(NumberFormatException e)
						  {
							  System.out.println("Balance Must Be Numeric");
						  }
						  
						  
						  if(bal<1000)
							  System.out.println("Invalid Balance, ReEnter");
						  else
						  {
							  break;
						  }
					  }
					  Account ob=new Account(id,mb,ah,bal);
					  ser.addAccount(ob);
					  break;
		 		
		 	case "2" : //find Existing Account
		 				System.out.println("Enter Mobile Number");
		 				mb=Long.parseLong(br.readLine());
		 				ob=ser.findAccount(mb);
		 				ser.printStatement(ob);
		 				
		 		break;
		 	case "3" : //delete
		 				System.out.println("Enter Mobile Number");
		 			   mb=br.read();
		 			   ser.deleteAccount(ser.findAccount(mb));
		 	
		 		break;
		 	case "4" :// withdraw
		 			System.out.println("Enter Mobile Number");
		 			mb=Long.parseLong(br.readLine());
		 			System.out.println("Enter the Amount");
		 			bal=Double.parseDouble(br.readLine());
		 			ser.withdraw(ser.findAccount(mb),bal);
		 			ser.printStatement(ser.findAccount(mb));
		 			
 				
		 		break;
		 	case "5" :// Deposit
		 		 System.out.println("Enter Mobile Number of Depositer");
	 			 long dmb=Long.parseLong(br.readLine());
	 			 System.out.println("Enter Mobile Number of Repositer");
	 			 long rmb=Long.parseLong(br.readLine());
	 			 if(dmb<1000000000) {
	 				 System.out.println("Transaction Failed");
	 			 }
	 			 else
	 			 System.out.println("Enter the Amount");
	 			 bal=Double.parseDouble(br.readLine());
	 			 ser.transferMoney(ser.findAccount(dmb),ser.findAccount(rmb),bal);
		 		break;
		 		
		 	case "6": //details Printing
		 				System.out.println("============Details==========");
		 				Map<Long, Account> col=ser.getAllAccounts();
				 		Collection<Account> acclist=col.values();
				 		 for(Account o: acclist)
				 		 {
				 			 ser.printStatement(o);
				 		 }
		 				ser.getAllAccounts();
		 				break;
		 		
		 	case "7"://exit
		 				System.out.println("Exiting account");
		 			 System.exit(0);
		 			 break;
		 	
		 	}
		 
		 }
		
		
		
		
		
		
		
		
		/*Account ob1=new SavingAccount(101,22222222,"Raja",25000.00);
		// ob1.setInterest(); 
		System.out.println(ob1);
		double b1=ob1.withdraw(24500);
		
		
		System.out.println(b1);
		SavingAccount s1=(SavingAccount)ob1;
		s1.setInterest();
		System.out.println(ob1);*/
//		SavingAccount ob2=new SavingAccount(105,22262222,"Mj",50000.00);
//		AccountService service=new AccountService();
//		
//		service.printStatement(ob2); //calling default method of Transaction 
//		double b1=0.0;
//		
//		try
//		{
//			b1=service.withdraw(ob2, 550000.00);
//			System.out.println("After Withdrawl"+b1);
//		}
//		
//		catch(Exception e){
//			
//			System.err.println(e.getMessage());
//			System.err.println(e);
//		}
		
		
		
		//double b1=service.withdraw(ob2, 55000.00);
		/* System.out.println("After Withdraw balance is: "+b1);
		double tax=service.calculateTax(Gst.PCT_5, b1);
		System.out.println("Gst: "+tax);

		SavingAccount ob3=new SavingAccount(106,22262722,"Ram",55000.00);
		System.out.println(service.transferMoney(ob2, ob3, 10000));
		
		*/
		
		
		//System.out.println(ob2 instanceof SavingAccount);

		//System.out.println(ob2 instanceof Account);
		//System.out.println(ob2 instanceof Object);
		//System.out.println(ob2 instanceof String);//ERROR
		
		//Account ob3=new Account();// ABSTRACT CLASS CANNOT BE INSTANTIZED
		
	}

	private static Reader InputStreamReader(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}

}