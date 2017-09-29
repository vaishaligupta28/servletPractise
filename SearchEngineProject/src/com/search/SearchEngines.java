package com.search;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEngines extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("doget");
		
		String searchString = req.getParameter("searchString");
		if((searchString == null) || (searchString.length() == 0)){
			reportProblem(resp, "Nothing to Search.Input some string to search");
			return;
		}
		
		searchString = URLEncoder.encode(searchString, java.nio.charset.StandardCharsets.UTF_8.toString());
		String numRes = req.getParameter("numResults");
		if((numRes == null) || (numRes.equals("0") || (numRes.length() == 0))){
			numRes = "10";
		}
		String searchEngine = req.getParameter("searchEngine");
		if(searchEngine == null) {
			reportProblem(resp, "Not selected search engine.Please select any one.");
			return;
		}
		SearchSpec[] commSearchEng = SearchSpec.getCommonSearchEng();
		for(int i=0;i<commSearchEng.length;i++)
		{
			SearchSpec searchSpec = commSearchEng[i];
			if(searchEngine.equals(searchSpec.getName())){
				String url = searchSpec.makeURL(searchString, numRes);
				resp.sendRedirect(url);
				return;
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	private void reportProblem(HttpServletResponse resp, String message) throws IOException
	{
		resp.sendError(resp.SC_NOT_FOUND, "<H2>" + message + "</H2>");
	}
}
