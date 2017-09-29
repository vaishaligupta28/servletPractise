package com.practise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoHttp extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init method");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget()");
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String pass = req.getParameter("pwd");
		
		PrintWriter pw= res.getWriter();
		pw.println("Tested HttpServlet using GET");
		
		pw.println("<html><body><h3>Welcome"+ " <b>"+ name + 
				"</b></h3><br><h3>Your password</h3><b>"+ " " + pass + 
				" "+ "</b></body></html>");	
		pw.flush();
		pw.close();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy methods");
	}
}
