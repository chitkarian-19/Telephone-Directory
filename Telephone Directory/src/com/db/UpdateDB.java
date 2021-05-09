package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDB {

	public int update(String name,String phone,String address,String u_name,String u_phone,String u_address) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telephone","root","");
	   PreparedStatement pst = con.prepareStatement("update user_table set name = ? , phone_number = ? where name = ? and phone_number = ?");
	   pst.setString(1, u_name);
	   pst.setString(2, u_phone);
	   pst.setString(3, name);
	   pst.setString(4, phone);
	  int res1 = pst.executeUpdate();
	 
	   pst = con.prepareStatement("update telephone_book set phone_number = ? , address = ? where phone_number = ? and address = ?");
	   pst.setString(1, u_phone);
	   pst.setString(2, u_address);
	   pst.setString(3, phone);
	   pst.setString(4, address);
	  int res2 = pst.executeUpdate();
	  
	  
	  pst.close();
	  con.close();//close the connection also
	    if(res1!=0&&res2!=0)
	    	return 1;
	    return 0;
	}

	
	
}
