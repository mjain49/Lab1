package cg;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo6 {

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
		

		System.out.println("Enter your Account Id for deleting the Account");
		int id2=sc.nextInt();
		updateSt=con.prepareStatement("delete from Account where aid=?");
		updateSt.setInt(1, id2);
		int i=updateSt.executeUpdate();//if deleted then i=1
		if(i==1)
		{
		System.out.println("Deleted Successfully");
		}
		else
		{	
		System.out.println("Invalid Account Id");
		con.close();
		}	
		
		
		
		
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
