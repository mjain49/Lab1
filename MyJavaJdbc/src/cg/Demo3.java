package cg;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {

	public static void main(String[] args)throws SQLException {
		// Load the Driver
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		
		Connection con=DriverManager.getConnection(url,user,pass); //to established  the Connection 
		System.out.println("Connected");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);// used to pass sql queries
		//By using Result Set Changes are insensitive means changes are not reflected
		ResultSet rs=st.executeQuery("select aid,mobileno,accountholder,balance from account");
		rs.afterLast();// moves the cursor after last record
		// rs.absolute(2);
		// rs.beforeFirst();
		
		while(rs.previous()) {
			int a_id=rs.getInt("aid");//in double quotes supply column name
			if(a_id==101)
			{
				rs.updateString("accountholder","Raja Sharma");
				rs.updateDouble(4,70000.00);
				rs.updateRow();
			}
			long mobile=rs.getLong("mobileno");
			String ah=rs.getString(3);
			double bal=rs.getDouble(4);
			System.out.println("Account id:-"+a_id+", Mobile:-"+mobile+", Name:-"+ah+", Balance:-"+bal);
			System.out.println("================================================================");
	}
	con.close();
}
}
