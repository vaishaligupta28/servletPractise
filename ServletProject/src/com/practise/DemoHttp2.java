package com.practise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoHttp2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String pass = req.getParameter("pwd");
		
		PrintWriter pw= res.getWriter();
		pw.println("Tested HttpServlet Using POST");
		
		pw.println("<html><body><h3>Welcome"+ " <b>"+ name + 
				"</b></h3><br><h3>Your password</h3><b>"+ " " + pass + 
				" "+ "</b></body></html>");	
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
	
}
