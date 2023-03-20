package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.management.relation.RelationServiceNotRegisteredException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logindb.Database;



@WebServlet("/enrol")
public class Enroll extends HttpServlet {
	
	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String email=User.getEmail();
		String course_name = Course.getEnroll_course();
		HttpSession httpsession =request.getSession();
		
		String email=null;
		if(httpsession!=null) {
		email = (String)httpsession.getAttribute("Email");
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		
		try {
			Database db =new Database();
			
			rs=Database.enrolledcheck();		
					
		if (rs.next()== false) {
			
			Database.insertCourseData();			
			Database.updateStatus();
			httpsession.setAttribute("show", "Successfully registered for the course !");
			response.sendRedirect("registered.jsp");
			}
			
			else {
				
				httpsession.setAttribute("show", "Course already registered !");
				response.sendRedirect("registered.jsp");
			}
					
		db.closeConnect();			
		}		
			
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				
		
	}



	

}




