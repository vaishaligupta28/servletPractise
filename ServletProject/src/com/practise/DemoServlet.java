package com.practise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class DemoServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		String pass = req.getParameter("pwd");
		
		PrintWriter pw= res.getWriter();
		pw.println("Tested Generic Servlet");
		pw.println("<html><body><h3>Welcome"+ " <b>"+ name + 
				"</b></h3><br><h3>Your password</h3><b>"+ " " + pass + 
				" "+ "</b></body></html>");
		pw.flush();
		pw.close();
	}	
}
