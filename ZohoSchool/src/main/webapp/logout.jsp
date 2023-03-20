<%@page import="com.login.Parsing"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ page import = "java.util.Date" %> 
  <%@ page import="java.sql.*" %>
  <%@ page import="com.logindb.Database" %>
  <%@ page import="java.text.SimpleDateFormat" %>
  <%@ page import="com.login.User" %>
 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <%!
	     Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null; 

   %>

<% 
			
			Database db=new Database();
			HttpSession httpsession =request.getSession();
			db.logoutSession();
			
			httpsession.removeAttribute("Email");
			httpsession.invalidate(); 
			
			response.sendRedirect("home.jsp");



%>

		
</body>
</html>

