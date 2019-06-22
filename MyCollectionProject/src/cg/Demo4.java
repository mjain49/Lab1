package cg;
import java.util.*;

public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<String,Double>m=new HashMap<String,Double>();
		//Map<String,Double>m=new TreeMap<String,Double>(); //based on the keys values are sorted
		
		m.put("Ram",5000.00);
		m.put("Sham",7000.00);
		m.put("Abdul",9000.00);
		m.put("Ganesh",4000.00);
		// m.put(null,5000.00);
		
		System.out.println(m);
		System.out.println(m.size());

		Set<String> keysSet=m.keySet();
		System.out.println(keysSet);
	
		for(String k: keysSet)
		{
			Double val=m.get(k);
			System.out.println(k+" has balance of Rs. "+val);
		}
		
		System.out.println("----------------");
		Double bal=m.get("Sham");
		System.out.println("Before:-"+bal);
		bal=bal-3000;//Autounboxing
		m.put("Sham",bal);//Autoboxing
		bal=m.get("Sham");
		System.out.println("After:-"+bal);
		System.out.println("----------------");
		

		Collection<Double> vals=m.values();
		System.out.println(vals);
	
		List<Double> vallist=new ArrayList<Double>(vals);
		Collections.sort(vallist);
		System.out.println("----------------");
		for(double d: vallist)
		{
			System.out.println(d);
		}
		System.out.println("----------------");
	}
	
	

}

