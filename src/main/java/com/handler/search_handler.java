package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.bo_class_add;
import com.dao.dao_class;

/**
 * Servlet implementation class search_handler
 */
@WebServlet("/search_handler")
public class search_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		int id=Integer.parseInt(request.getParameter("id1"));
		String name1=request.getParameter("id1");
		
		pw.print(" <body style=\"background-image: url('css/images/crystal.jpeg');\"><center> <h1><i> Employee Details </i></h1> </center>");
		pw.print("<table border='4' width 1300px>");
		pw.print(" <center> <tr> <th><h3>Employee ID </h3></th> <th style=width:5cm;><h3>Name</h3></th style=width:5cm;> <th style=width:5cm;><h3>City </h3></th> <th style=width:5cm;><h3>Department</h3></th><th style=width:5cm;><h3>Joinning Date</h3></th><th style=width:5cm;><h3>Salary</h3></th><th style=width:5cm;><h3>Delete<h3></th><th style=width:5cm;><h3>update<h3></th></tr>");
		List<bo_class_add> on=dao_class.search(id,name1);
		for(bo_class_add el: on)
		{
			
			pw.print("<tr> <td>"+el.getId()+"</td><td>"+el.getName()+"</td> <td>"+el.getCity()+"</td>  <td>"+el.getDepartment()+"</td>  <td>"+el.getJoin()+" </td> <td>"+el.getSalary()+"</td><td><a href='delete_handler?id="+el.getId()+"'>delete </a><td><a href='edit_handler?id="+el.getId()+"'>edit</a></td></td></tr>");
			
		}
		
		pw.print("</table>");
		
	}

}
