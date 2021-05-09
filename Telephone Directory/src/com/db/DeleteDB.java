package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDB {
     
	public int deleteUser(String name,String phone) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telephone","root","");
	   PreparedStatement pst = con.prepareStatement("delete from user_table where name = ? AND phone_number = ?");
	   pst.setString(1, name);
	   pst.setString(2, phone);
	  int res1 = pst.executeUpdate();
	 
	   pst = con.prepareStatement("delete from telephone_book  where phone_number = ?");
	   pst.setString(1, phone);
	  int res2 = pst.executeUpdate();
	  
	  
	  pst.close();
	  con.close();//close the connection also
	    if(res1!=0&&res2!=0)
	    	return 1;
	    return 0;
	
	}
	
}
