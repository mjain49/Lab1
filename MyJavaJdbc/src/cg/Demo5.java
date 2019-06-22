package cg;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args)throws SQLException {
		
		Connection con=null;
		PreparedStatement updateSt=null;
		PreparedStatement selectSt=null;
		try
		{
		
		//Load Driver
		//DriverManager.registerDriver(new  oracle.jdbc.driver.OracleDriver());
		//commenting Driver because java 8 automatically loads the driver.
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected");
		con.setAutoCommit(false);//tells that do not commit after every dml statement
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Account Id");
		int id=sc.nextInt();
		selectSt=con.prepareStatement("select * from Account where aid=?");
		selectSt.setInt(1, id);
		ResultSet rs1=selectSt.executeQuery();
		double bal1=0.0;
		long mb1=0L;
		String ah1="";
		
		if(rs1!=null)
		{
			if(rs1.next())
			{
				mb1=rs1.getLong("mobileno");
				ah1=rs1.getString(3);
				System.out.println(ah1);
				bal1=rs1.getDouble(4);
				System.out.println("Your Balance is "+bal1);
			}
			else
			{
				System.out.println("Record not found for your AccounId= "+id);
			}
		}
		else
		{
			System.out.println("Null");
		}
		
		
		//Another Account Details Printing using Account Id
		System.out.println("Enter Another Account Id");
		int id1=sc.nextInt();
		selectSt.setInt(1, id1);
		
		
		ResultSet rs2=selectSt.executeQuery();
		double bal2=0.0;
		long mb2=0L;
		String ah2="";
		if(rs2!=null)
		{
			if(rs2.next())
			{
				mb2=rs2.getLong("mobileno");
				ah2=rs2.getString(3);
				System.out.println(ah2);
				bal2=rs2.getDouble(4);
				System.out.println("Your Balance is "+bal2);
			}
			else
			{
				System.out.println("Record not found for your AccounId= "+id1);
			}
		}
		//For Balance Transfer from first account to Another
		
		System.out.println("Enter the Amount To be transferred");
		double amount=sc.nextDouble();
		
		updateSt=con.prepareStatement("update Account Set mobileno=?,accountholder=?,balance=? where aid=?");
		updateSt.setLong(1,mb1);//the key is based on the data entry not the stored database 1 because we are taking mobile no first
		updateSt.setString(2,ah1);
		updateSt.setDouble(3, bal1-amount);
		updateSt.setInt(4,id);
		int i1=updateSt.executeUpdate();
		System.out.println("Account updated "+i1);
		
		updateSt=con.prepareStatement("update Account Set mobileno=?,accountholder=?,balance=? where aid=?");
		updateSt.setLong(1,mb2);//the key is based on the data entry not the stored database 1 because we are taking mobile no first
		updateSt.setString(2,ah2);
		updateSt.setDouble(3,bal2+amount);
		updateSt.setInt(4, id1);
		i1+=updateSt.executeUpdate();
		System.out.println("Account updated "+i1);
		
		System.out.println("Rs. "+amount+" transfered from:- "+id+" to "+id1);
//		System.out.println("===========================");
//		System.out.println("Updated Balance:");
//		rs1.previous();
//		rs2.previous(); for printing the balance again but we have to make it scrollable
//		System.out.println("Account "+id+ "has balance= "+rs1.getDouble(3));
//		System.out.println("Account "+id1+ "has balance= "+rs2.getDouble(3));
//		System.out.println("===========================");
		con.commit();
		
		
		
	}
	catch(SQLException e){
		con.rollback();
		System.out.println(e.getMessage()+" "+e.getErrorCode()+" "+e.getSQLState());
		e.printStackTrace();
	}
	finally
	{
		System.out.println("Transaction Successful Thank You \n Closing Connection");
		if(con!=null)
		con.close();
	}
}
}
