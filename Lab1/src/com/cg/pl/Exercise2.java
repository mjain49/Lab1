package com.cg.pl;

import java.util.Scanner;
import java.io.IOException;
import java.lang.*;

public class Exercise2 {
	public static void main(String args[]) throws IOException
	{
		int a;
		int diff=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Number:-");
		a=sc.nextInt();
		diff=calcualteDifference(a);
		System.out.println("Final Answer= "+diff);
	}

	private static int calcualteDifference(int n) {
		int diff=0,sum1=0,sum2=0;
		for(int c=1;c<=n;c++)
		{
			sum1=sum1+(int)Math.pow(c,2);
			sum2=sum2+c;
		}
		sum2=(int)Math.pow(sum2,2);
		diff=sum1-sum2;
		return diff;
	}
}
