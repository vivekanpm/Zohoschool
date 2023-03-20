<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="com.logindb.Database" %>

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
	     Boolean flag=false;

   %>
   
<%  
    Database db =new Database();
    db.modifyEmail();
    
    String sec_email =request.getParameter("sec_email");
    String query ="UPDATE Email_details SET Is_primary= 1 WHERE Email=?";
	Connection con =Database.connect();
	ps =  con.prepareStatement(query);
	ps.setString(1, sec_email);
	ps.executeUpdate();
	HttpSession httpsession =request.getSession();
	httpsession.setAttribute("message", "The mail is changed to primary");
	response.sendRedirect("email_registered.jsp");
%>
</body>
</html>