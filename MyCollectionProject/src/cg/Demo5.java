package cg;
import java.util.* ;
import com.cg.bean.*;


public class Demo5 {
 public static void main(String[] args) {
	 Map<Integer,Account> accmap=new TreeMap<Integer,Account>();
	 Account ob1=new Account(101,986724701,"Ram",25000.00);
	 accmap.put(ob1.getMobile(),ob1);
	 Account ob2=new Account(102,986724702,"Sham",55000.00);
	 accmap.put(ob2.getMobile(),ob2);
	 Account ob3=new Account(103,986724703,"Abdul",15000.00);
	 accmap.put(ob3.getMobile(),ob3);
	 Account ob4=new Account(104,986724704,"Ganesh",45000.00);
	 accmap.put(ob4.getMobile(),ob4);
	 
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
	
	
	 
}
}
