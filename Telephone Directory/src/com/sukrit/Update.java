package com.sukrit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.UpdateDB;
import com.google.gson.Gson;
import com.model.User;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name=request.getParameter("user_name");
		String phone = request.getParameter("phone_number");
		String address = request.getParameter("address");
		String u_name = request.getParameter("u_user_name");
		String u_phone = request.getParameter("u_phone_number");
		String u_address = request.getParameter("u_address");
		
		UpdateDB user =new UpdateDB();
		try {
			int res = user.update(name, phone, address, u_name, u_phone, u_address);
			if(res!=0)
			{User myuser = new User(u_phone,name,u_address);
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("details", myuser);
			
            response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(map));}
			else{
			   System.out.println("No UserFound");	
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			//e.printStackTrace();
		}
		
		
		
		
		
	}

}
