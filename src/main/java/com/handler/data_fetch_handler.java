package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.bo_class_add;
import com.dao.dao_class;



/**
 * Servlet implementation class data_fetch_handler
 */
@WebServlet("/data_fetch_handler")
public class data_fetch_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public data_fetch_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print(" <body style=\"background-image: url('css/images/crystal.jpeg');\"><center> <h1><i> Employee Details </i></h1> </center>");
        pw.print("<form action=\"search_handler\" method=\"get\"><tr><td><label for=\"\"><h3 id=\"aa\">Id:</h3></label></td><td><input type=\"text\" name=\"id1\" id=\"bb\" placeholder=\"enter Id\"><br><td><button type=\"submit\" id=\"but\">Submit</button></td><tr>");
        pw.print("</form>");
		
		
		pw.print("<table border='1';>");
		pw.print("<center> <tr> <th><h3>Employee ID </h3></th> <th style=width:5cm;><h3>Name</h3></th style=width:5cm;> <th style=width:5cm;><h3>City </h3></th> <th style=width:5cm;><h3>Department</h3></th><th style=width:5cm;><h3>Joinning Date</h3></th><th style=width:5cm;><h3>Salary</h3></th><th style=width:5cm;><h3>Delete<h3></th><th style=width:5cm;><h3>update<h3></th></tr> </center>");
		List<bo_class_add> on=dao_class.fetch();
		for(bo_class_add el: on)
		{
			pw.print("<tr> <td>"+el.getId()+"</td><td>"+el.getName()+"</td> <td>"+el.getCity()+"</td>  <td>"+el.getDepartment()+"</td>  <td>"+el.getJoin()+" </td> <td>"+el.getSalary()+"</td><td><a href='delete_handler?id="+el.getId()+"'>delete </a><td><a href='edit_handler?id="+el.getId()+"'>edit</a></td></td></tr>");
			
		}
		
		pw.print("</table>");
		
		pw.println("<br>");
		pw.print("<a href=add.html><div style=\"height: 20px ;width:45px ; border: 3px solid; background-color: rgb(27, 213, 20);\">Back</div></a>");
	pw.print("</body>");
		  pw.close();	
	}

}
