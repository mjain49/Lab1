package cg;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args)throws SQLException {
		
		try
		{
		
		//Load Driver
		DriverManager.registerDriver(new  oracle.jdbc.driver.OracleDriver());
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connecyted");
		con.setAutoCommit(false);//tells that do not commit after every dml statement
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Account Id");
		int id=sc.nextInt();
		System.out.println("Enter Mobile Number");
		long mb=sc.nextLong();
		System.out.println("Enter Account Holder Name");
		String ah=sc.next();
		System.out.println("Enter Initial Balance");
		double bal=sc.nextDouble();
		//Dynamic Query
		String sqlQuery="insert into Account values(?,?,?,?)";
		
		PreparedStatement st=con.prepareStatement(sqlQuery);
		st.setInt(1,id);
		st.setLong(2,mb);
		st.setString(3,ah);//no need to put single '' for String and Date in the insert query
		st.setDouble(4,bal);
		
		int insertRec=st.executeUpdate();
		System.out.println(+insertRec+" Record Inserted ");
		
		con.commit();
		con.close();
	}
	catch(SQLException e){
		System.out.println(e.getMessage()+" "+e.getErrorCode()+" "+e.getSQLState());
		e.printStackTrace();
	}
}
}
