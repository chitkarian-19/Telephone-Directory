package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.omg.CORBA.PUBLIC_MEMBER;
public class UserDB_Create {
	public int createUser(String phone ,String name,String address)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telephone","root","");
	   PreparedStatement pst = con.prepareStatement("Insert into user_table  values ("+"\'"+name+"\' , \'"+phone+"\')");
	  int res1 = pst.executeUpdate();
	 
	   pst = con.prepareStatement("Insert into telephone_book  values ("+"\'"+phone+"\' , \'"+address+"\')");
	  int res2 = pst.executeUpdate();
	  
	  
	  pst.close();
	  con.close();//close the connection also
	    if(res1!=0&&res2!=0)
	    	return 1;
	    return 0;
	 }
}
