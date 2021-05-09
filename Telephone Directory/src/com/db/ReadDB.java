package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.model.User;

public class ReadDB {
	
	public LinkedList<User> sendData() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	LinkedList list = new LinkedList<User>();
	 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telephone","root","");
	   Statement stmt = con.createStatement();
	  ResultSet rst = stmt.executeQuery("Select * from user_table NATURAL JOIN telephone_book");
	  while(rst.next()){
		  String phone_number = new String(rst.getString(1));
		  String name=new String(rst.getString(2));
		  String address = new String(rst.getString(3));
		  User user = new User(phone_number,name,address);
		  list.add(user);
	  }
	  stmt.close();
	  con.close();//close the connection also
	  return list;
	}
}
