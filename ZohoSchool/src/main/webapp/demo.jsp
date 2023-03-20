<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="course_view.css">

</head>
<body>

<div class ="head">
  <h1>Course</h1>
</div>

<div style="overflow:auto">
  <div class="menu">
    <a href="#">Syllabus</a>
    <a href="#">Lecture videos</a>
    <a href="#">Lecture notes</a>
    <a href="#">Assignment</a>
  </div>

  <div class="main">
    <h2>Course description</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
        <h2>Course Instructor</h2>
    <p> Vivekan p</p>
  </div>

  <div class="right">
    <h2>About</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
  </div>
</div>

<div style="background-color:#e5e5e5;text-align:center;padding:10px;margin-top:7px;">Zoho school </div>
</body>
</html>




package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.management.relation.RelationServiceNotRegisteredException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logindb.Database;



@WebServlet("/enrol")
public class enroll extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession httpsession =request.getSession();
		HttpSession session2 =request.getSession();
	    String email=   (String)httpsession.getAttribute("Email");
		String course_name = (String)session2.getAttribute("course_name_fin");
    
  
		
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2= null;
		PreparedStatement ps3= null;
		PreparedStatement ps4= null;
		ResultSet rs1 =null;
		ResultSet rs2 =null;

		
		
		PrintWriter out = response.getWriter();
		
		
		try {
			Database db =new Database();
			con =db.connect();
			ps1 = con.prepareStatement(db.userIdDataString ());
			ps1.setString(1, email);
			rs1= ps1.executeQuery();
			rs1.next();
			int user = rs1.getInt(1);
			httpsession.setAttribute("user_id",user);
			

			
			ps2 = con.prepareStatement(db.courseIdData ());
			ps2.setString(1, course_name);
			rs2 = ps2.executeQuery();
			rs2.next();
			int course = rs2.getInt(1);
			httpsession.setAttribute("course_id",course);	
			
		
			
			ps3 = con.prepareStatement(db.insertCourseData());
			ps3.setInt(1, user);
			ps3.setInt(2, course);
			ps3.executeUpdate();
			
			ps4 = con.prepareStatement(db.updateStatus());
			ps4.setInt(1, user);
			ps4.setInt(2, course);
			ps4.executeUpdate();
			
			response.sendRedirect("registered.jsp");
		
					
		}		
			
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				
		
	}

	

}































