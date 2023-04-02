package com.techpalle.dao;

import java.sql.*;

public class AdminDao 
{
	private static final String dburl="jdbc:mysql://localhost:3306/customer_management";
	private static final String dbusername="root";
	private static final String  dbpassword="admin";
	
	private static Connection con=null;
    private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	//fetch row whenever the username and pass present
	private static final String  validateQuery="select * from admin where username=? and password=?";
	
	public static boolean validateAdmin(String user,String pass)
	{
		boolean b=false;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			
			ps=con.prepareStatement(validateQuery);
			ps.setString(1, user);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			b=rs.next();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
		
	}
	

}
