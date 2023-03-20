package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.logindb.Database;

@WebServlet("/mail")

public class Addmail  extends HttpServlet{
	
	
	public void doGet (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
	    String email =User.getEmail();
		String secemail=  req.getParameter("addemail");
		User.setSecEmail(secemail);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		PrintWriter out = res.getWriter();
				
		try {
			
			Database db =new Database();
			db.insertsecEmail();
			HttpSession httpsession =req.getSession();
			httpsession.setAttribute("message", "Your mail is added");
			res.sendRedirect("email_registered.jsp");
			db.closeConnect();	
						
		}		
			
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
  } 


}

		
		
		
		
		
		
		
		