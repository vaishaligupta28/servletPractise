package com.practise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servRegis")
public class Register extends HttpServlet {

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		Connection conn = null;
		PreparedStatement pst = null;
		String insertQuery = "INSERT INTO user VALUES(?, ?, ?, ?, ?)";
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String passd = req.getParameter("passd");
		
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "admin#12";
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, pass);
			pst = conn.prepareStatement(insertQuery);
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, uname);
			pst.setString(4, email);
			pst.setString(5, passd);
			
			int i = pst.executeUpdate();
			if(i>0) {
				System.out.println("registered");
				pw.println("Successfully registered");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
