package com.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/login")
public class SessionMaintenenceFilter extends HttpFilter implements Filter {
      

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 
		HttpServletRequest req = (HttpServletRequest)  request;
		HttpServletResponse res = (HttpServletResponse)  response;
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		HttpSession httpsession = req.getSession(false);
		res.setHeader("Cache-Control","no-cache,no-store");
		
		if(httpsession.getAttribute("Email")==null && !(uri.endsWith("login"))){
			res.sendRedirect("index.html");
		}
		
		
		else {
		chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}




