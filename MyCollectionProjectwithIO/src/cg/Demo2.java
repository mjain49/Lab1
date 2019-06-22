package cg;

import java.util.*;

public class Demo2 {

	public static void main(String[] args) {
		// Generic Collection it will accept only String values
		// Set<String> col=new HashSet<String>(); //unordered, no duplicates allowed
		
		//Set<String> col=new LinkedHashSet<String>(); //maintains insertion order & no duplicates
		
		//Set<String> col=new TreeSet<String>(); //Tree/treehashmap set doesnot allow null value and gives the result is sorted 
		
		List<String> col=new ArrayList<String>(); //duplicates allowed and multiple null allowed
		col.add("Ram");
		col.add("Sham");
		col.add("Abdul");
		// col.add(55);// for Array List
		//col.add(55); //new Integer(55); //autoboxing
		//col.add(null); //throws null pointer exception for treeset and treehashMap
		col.add(null); 
		col.add("Ganesh");
		col.add("Ram");
		System.out.println(col);
		System.out.println(col.size());
		
		
	}

}
