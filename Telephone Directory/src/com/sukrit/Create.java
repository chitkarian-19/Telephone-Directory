package com.sukrit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.UserDB_Create;
import com.google.gson.Gson;


/**
 * Servlet implementation class Create
 */
@WebServlet("/create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDB_Create user = new UserDB_Create();
		String phone=new String(request.getParameter("phone_number"));
		String name=new String(request.getParameter("user_name"));
		String address = new String(request.getParameter("address"));
		try {
			int resp=user.createUser(phone,name, address);
			if(resp!=0){
				//response.sendRedirect("index.jsp");
				/*request.setAttribute("name", "Sukrit User");
				 
		        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		 
		        requestDispatcher.forward(request, response);*/

				Map<String,Object> map = new LinkedHashMap<String,Object>();
				map.put("name", name);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				//
				response.getWriter().write(new Gson().toJson(map));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//Error 
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("error", e.toString());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//
			response.getWriter().write(new Gson().toJson(map));
			//e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
