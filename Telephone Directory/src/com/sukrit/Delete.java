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

import com.db.DeleteDB;
import com.google.gson.Gson;
import com.model.User;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		String name=new String(request.getParameter("user_name"));
		String phone=new String(request.getParameter("phone_number"));
		
		DeleteDB user = new DeleteDB();
		try {
			int resp = user.deleteUser(name, phone);
			if(resp!=0){
				Map<String,Object> map = new LinkedHashMap<String,Object>();
				User myuser = new User(phone,name,"");
				map.put("details", myuser);
				
                response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(new Gson().toJson(map));
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("error", e.toString());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//
			response.getWriter().write(new Gson().toJson(map));
			//e.printStackTrace();
		}
		
		
	}

}
