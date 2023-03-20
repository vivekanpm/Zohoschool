<%@page import="java.sql.ResultSet"%>
<%@page import="com.logindb.Database"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="course.css">
<style>

body{
background-color: #E7F3FF;
}

</style>
</head>

<body>


<div class ="borderTop">
	<ul>
		<li class="top" ><a href="logout.jsp">LOGOUT</a></li>
		<li class="top" ><a href="profile.jsp">PROFILE</a></li>
		<li class="top" ><a href="repository.jsp">REPOSITORY</a></li>
        <li class="top" ><a href="home.jsp">HOME</a></li>
	</ul>

</div>
 
<div class="sessionhead">
     <p class="secmailHead" >You have active session in <p>
</div>

<%     
     Database db=new Database();
     ResultSet rs =db.profileSession();
     
     while(rs.next()){
    	 String login_time =rs.getString(1);
    	 String browser=rs.getString(2);
    	 String os=rs.getString(3);
%>
       <div class="session">
            <p class= "profile_font"> <%=browser%> browser , <%=os%> OS from <%=login_time %> <p>
        </div>


<%} %>
</body>
</html>