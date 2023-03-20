package com.login;

import java.io.IOException;


import java.io.PrintWriter;
import java.security.acl.AclNotFoundException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logindb.Database;

public class Check_login  extends HttpServlet{
	
	
	protected void doPost (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		System.out.println("inside login");
	    String email=  req.getParameter("email");
		String  pass= req.getParameter("pass");
		String userAgent = req.getHeader("User-Agent");
		
		User.setEmail(email);
		User.setUseragent(userAgent);

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		PrintWriter out = res.getWriter();
		
		
		try {
			
			Database db =new Database();
			
			rs=db.validateData();
			if(rs.next()){
				
				Hashing hs = new Hashing();
				String hashed_pass1 = hs.passwordTransfer(pass);
				
				String pass1 = rs.getString(4);
				
				if(hashed_pass1.equals(pass1)) { 	
					
					HttpSession httpsession =req.getSession();
					httpsession.setAttribute("Email",email);
					httpsession.setAttribute("Password",pass);
					
					db.insertSession();
					res.sendRedirect("home.jsp");	 
					
				}
				
				else {
					out.println(" Username and password doesnot matches");
					HttpSession httpsession =req.getSession();
					httpsession.setAttribute("error"," Username and password doesnot matches");
					res.sendRedirect("error_msg.jsp");
				}	
			}	
					
			else {
				out.println(" Username doesn't exist ,Go to the signup page ");
				HttpSession httpsession =req.getSession();
				httpsession.setAttribute("error","Username doesn't exist");
				res.sendRedirect("error_signup.jsp");
				
			}
				
			db.closeConnect();	
		}		
			
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
  } 

}
