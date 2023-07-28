package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.bo_class;
import com.dao.dao_class;

/**
 * Servlet implementation class login_handler
 */
@WebServlet("/login_handler")
public class login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String s=request.getParameter("login");
		int s1=Integer.parseInt(request.getParameter("password"));
		
		bo_class lb=new bo_class();
		if(dao_class.login(s, s1))
		{
			
			pw.print("login sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("afterlogin.html");
			rd.forward(request, response);
			
		}
		else
		{
			pw.print("something went wrong");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			
		}
	}

}
