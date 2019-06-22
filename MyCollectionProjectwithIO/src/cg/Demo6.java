package cg;
import java.util.* ;
import com.cg.bean.*;
import java.io.*;
import com.cg.service.*;

public class Demo6 {
 public static void main(String[] args) throws IOException {
	 Map<Long,Account> accmap=new TreeMap<Long,Account>();
	 
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 String choice="";
	 
	 while(true)
	 {
	
	 
	 System.out.println("Menu");
	 System.out.println("========");
	 System.out.println("1.Create New Account");
	 System.out.println("2.Print All Accounts");
	 System.out.println("3.Exit");
	 System.out.println("Enter Your Choice");
	 choice=br.readLine();
	 
	 switch(choice)
	 {
	 	case "1": int id=0;
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
								  System.out.println("Wrong. Re Enter");
							  }
						  }
						  else
						  {
							  System.out.println("Re Enter Holder Name");
						  }
					  }
					  
					  
					  //Accepting And Validating Balance
					  System.out.println("Enter Initial Balance");
					  String s_bal=br.readLine();
					  
					  bal=Double.parseDouble(s_bal);
					  
					  Account ob=new Account(id,mb,ah,bal);
					  accmap.put(ob.getMobile(), ob);
					  
		 	break;
	 	case "2":	//for Account details
	 		
			 		 Collection<Account> vc=accmap.values();
			 		 List<Account> acclist=new ArrayList<Account>(vc);
			 		 Collections.sort(acclist);
			 		 
			 		 for(Account o: acclist)
			 		 {
			 			 System.out.println(o);
			 			 //service.printStatement(0);
			 		 }	
	 		
	 		break;
	 	case "3":System.out.println("Exiting Program");
	 			System.exit(0);
	 			break;
	 	default:System.out.println("Invalid Choice");
	 }
	 }//End of Menu
	 
	 /*Account ob1=new Account(101,986724701,"Ram",25000.00);
	 accmap.put(ob1.getMobile(),ob1);
	 Account ob2=new Account(102,986724702,"Sham",55000.00);
	 accmap.put(ob2.getMobile(),ob2);
	 Account ob3=new Account(103,986724703,"Abdul",15000.00);
	 accmap.put(ob3.getMobile(),ob3);
	 Account ob4=new Account(104,986724704,"Ganesh",45000.00);
	 accmap.put(ob4.getMobile(),ob4);
	 */
	
	 /*
	 System.out.println(accmap);
	 System.out.println(accmap.keySet());
	 
	 System.out.println("--------SORT BY AID--------");
	 Collection<Account> vc=accmap.values();
	 List<Account> acclist=new ArrayList<Account>(vc);
	 Collections.sort(acclist);
	 
	 for(Account o: acclist)
	 {
		 System.out.println(o);
	 }
	 System.out.println("----------------");
	 
	 System.out.println("----------------SORT BY NAME--------------");
	 Comparator nc=new NameComparator();
	 Collections.sort(acclist,nc);
		 
	for(Account o: acclist)
	{
		System.out.println(o);
	}	
	
	System.out.println("----------------");
	System.out.println("----------------SORT BY BALANCE--------------");
	Comparator bc=new BalanceComparator();
	Collections.sort(acclist,bc);
		 
	for(Account o: acclist)
	{
		System.out.println(o);
	}
	
	*/
	 
}
}
