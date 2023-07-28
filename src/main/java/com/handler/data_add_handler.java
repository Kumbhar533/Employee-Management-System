package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.bo_class_add;
import com.dao.dao_class;

/**
 * Servlet implementation class data_add_handler
 */
@WebServlet("/data_add_handler")
public class data_add_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public data_add_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id= Integer.parseInt(request.getParameter("id"));
		String name1=request.getParameter("name");
		String city1=request.getParameter("city");
		String dept1=request.getParameter("Dept");
		
		String join1=request.getParameter("date1");
		int salary= Integer.parseInt(request.getParameter("sal"));
		
		 bo_class_add ob=new  bo_class_add(id,name1,city1,dept1,join1,salary);
		 int status=dao_class.add(ob);
		 
		 if(status>0)
			{
				pw.print("data inserted");
				RequestDispatcher rd=request.getRequestDispatcher("data_fetch_handler");
				rd.forward(request, response);
			}
			else
			{
				pw.print("somthing went wrong");
				RequestDispatcher rd=request.getRequestDispatcher("add.html");
				rd.include(request, response);
				
			}
		 
		
		
	}

}
