<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="com.logindb.Database" %>

<!DOCTYPE html>
<html>
<head>

<style>

body{
background-color: #E7F3FF;
}

img{

float:left;
width:200px;
border-radius:10px;
margin-left:10px;


}

</style>




<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="course.css">

</head>
<body>

 <%!
	     Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     Boolean flag=false;

   %>

<div class ="borderTop">

	<ul>
		<li class="top" ><a href="logout.jsp">LOGOUT</a></li>
		<li class="top" ><a href="profile.jsp">PROFILE</a></li>
		<li class="top" ><a href="repository.jsp">REPOSITORY</a></li>
        <li class="top" ><a href="home.jsp">HOME</a></li>
	</ul>

</div>



	
	
	<%
	
			HttpSession httpsession =request.getSession();
			String email=   (String)httpsession.getAttribute("Email");
			Database db = new Database();
			rs= db.repoData();
			
			while (rs.next()) {
				
			    flag=true;
			    
	%>

		
		<div class="left">
		   <img src= <%=rs.getString(6)%> >
		     <div class="left2">
		        <h1 class="left2"> <%=rs.getString(4)%></h1>
		        <h1 class="left2"> <%=rs.getString(5)%></h1>
		        <button class="profilebtn" onclick="location.href='enroll_web.jsp?course_name_1=<%=rs.getString(4)%>'">Go to course</button>   
		   </div>		
		</div>
		
<%} %>

</body>
</html>