package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.bo_class;
import com.dao.dao_class;

/**
 * Servlet implementation class sign_up_handler
 */
@WebServlet("/sign_up_handler")
public class sign_up_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sign_up_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int pass=Integer.parseInt(request.getParameter("password"));
		int comfirm=Integer.parseInt(request.getParameter("confirm-password"));
		
		
		
		
		bo_class lb=new bo_class();
		
		lb.setUsername(name);
		lb.setEmail(email);
		lb.setPassword(pass);
		lb.setConfirm_pass(comfirm);
		
		int status=dao_class.signup(lb);
		
		if(status>0)
		{
			pw.print("data inserted");
			RequestDispatcher rd=request.getRequestDispatcher("Homepage.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("somthing went wrong");
			RequestDispatcher rd=request.getRequestDispatcher("singup.com");
			rd.include(request, response);
			
		}
	}

}
