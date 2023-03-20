<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="com.logindb.Database" %>
<%@ page import="com.login.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

body{
background-color: #E7F3FF;
}

input[type=text], input[type=password] {
  width: 15 %;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid grey;
  box-sizing: border-box;
}

</style>

<link rel="stylesheet" href="course.css">

</head>


<div class ="borderTop">
	<ul>
		<li class="top" ><a href="logout.jsp">LOGOUT</a></li>
		<li class="top" ><a href="profile.jsp">PROFILE</a></li>
		<li class="top" ><a href="repository.jsp">REPOSITORY</a></li>
        <li class="top" ><a href="home.jsp">HOME</a></li>
	</ul>

</div>
  
<body>


   <%!
	     Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null; 

   %>

<% 
			
	String email=User.getEmail();	
	Database db = new Database();
	
	rs=db.retriveName();
	rs.next();
	String F_name = rs.getString(1);
	String L_name = rs.getString(2);
	String dob = rs.getString(3);
	String created_at = rs.getString(4);
	
	rs=db.getPrimaryemail();
	rs.next();
	String primary_email =rs.getString(1);

%>

<div class="registerBody">
     <h1 class ="register">  Welcome <%=F_name%> <%=L_name%>     </h1>


	<div class ="profile_left">
	
			<p class= "profile_font">First name : <%=F_name%> <p>
			<p class= "profile_font">Last name : <%=L_name%> <p>
			<p class= "profile_font">Date of birth  : <%=dob%> <p>
			<p class= "profile_font"> Primary email : <%=primary_email%> <p>
			<p class= "profile_font"> Created at : <%=created_at%> <p>
			
			<button  class = "pro_button" onclick="location.href='session.jsp'">SESSIONS</button> <br>
			
		    <form action ="mail" method ="get">
		    
				    <input type="text" placeholder=" Add secondary email" name ="addemail" > <br>
				    
				    <button  class = "pro_button"> SUBMIT </button> <br>
		
		    </form>
				    <div class="secmail">
				    <p class="secmailHead">Secondary Email <p>
<%		
		rs=db.emailSecondary();		
		while (rs.next()){
		String mail=rs.getString(3);
%>

		     <p class= "profile_font"> <%=mail %> <p> 
		     <button class="chnge_primary_btn" onclick="location.href='primary.jsp?sec_email=<%=mail%>'">Change to primary</button>

 <%}%>
 
 
                </div>
     </div>
</div>

</body>
</html>