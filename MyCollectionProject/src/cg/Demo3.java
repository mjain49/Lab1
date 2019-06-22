package cg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo3 {
	public static void main(String... args) {
		
		List<String> col=new ArrayList<String>(); //duplicates allowed and multiple null allowed
		col.add("Ram");
		col.add("Sham");
		col.add("Abdul");
		col.add(null); 
		col.add("Ganesh");
		col.add("Ram");
		System.out.println(col);
		System.out.println(col.size());
		
		System.out.println("------------------");
		for(String s:col) //Output Using Inhanced For Loop
		{
			System.out.println(s);
		}
		System.out.println("------------------");
		Iterator<String> it=col.iterator();
		while(it.hasNext()) //Output Using Iterator
		{
			String ss=it.next();
			System.out.println(ss);
		}
		
		
	}

}


