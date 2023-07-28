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
 * Servlet implementation class controller_edit
 */
@WebServlet("/controller_edit")
public class controller_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller_edit() {
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
         
        
        int id=Integer.parseInt(request.getParameter("id")); 
        
      
		String name1=request.getParameter("name");
		String city1=request.getParameter("city");
		String dept1=request.getParameter("Dept");
		
		String join1=request.getParameter("date1");
		int salary=Integer.parseInt(request.getParameter("sal")); 
		
		
		bo_class_add ob=new bo_class_add();
		ob.setId(id);
		ob.setName(name1);
		ob.setCity(city1);
		ob.setDepartment(dept1);
		ob.setJoin(join1);
		ob.setSalary(salary);
		int status=dao_class.update(ob);
		if(status>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("data_fetch_handler");
    	    rd.forward(request, response);
		}
		else
		{
			pw.print("went worng");
		}
		
        
	}

}
