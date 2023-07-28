package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.bo_class_add;
import com.dao.dao_class;

/**
 * Servlet implementation class edit_handler
 */
@WebServlet("/edit_handler")
public class edit_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_handler() {
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
		
		int id1=Integer.parseInt(request.getParameter("id"));
		
		bo_class_add eb=dao_class.element_byid(id1);
		
		pw.print("<form  action='controller_edit' method='get'> ");
		
		
pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>City: </td> <td><input type='text' name='city' value='"+eb.getCity()+"'/></td></tr>");
	   	pw.print("<tr><td>Department:</td> <td><input type='text' name='Dept' value='"+eb.getDepartment()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Joining : </td> <td><input type='text' name='date1' value='"+eb.getJoin()+"'/></td></tr>");
	      
		pw.print("<tr><td>Salary : </td> <td><input type='text' name='sal' value='"+eb.getSalary()+"'/></td></tr>");
	    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
pw.print("</table>");
		
		pw.print("</form>");
	}

}
