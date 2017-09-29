package com.search;

public class SearchSpec {
	
	private String name, baseURL, numResSuffix;
	
	private static SearchSpec[] commonSearchEng= {
		new SearchSpec("google", "http://www.google.co.in/search?q=", "&num="), 
		new SearchSpec("duck duck go", "https://duckduckgo.com/?q=","&nbq="), 
		new SearchSpec("lycos", "http://search.lycos.com/web/?q=", "&maxhits="), 
		new SearchSpec("hotbot", "http://www.hotbot.com/?MT=", "&DC=")
			};
	SearchSpec(String name, String baseURL, String numResSuffix)
	{
		this.name = name;
		this.baseURL = baseURL;
		this.numResSuffix = numResSuffix;
	}
	
	public String makeURL(String searchString, String numResults)
	{
		return(baseURL+searchString+numResSuffix+numResults);
	}
	public String getName()
	{
		return name;
	}
	public static SearchSpec[] getCommonSearchEng()
	{
		return commonSearchEng;
	}
}
