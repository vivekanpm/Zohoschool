<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>

body{
background-color: #E7F3FF;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="course.css">

</head>


<body>

<% HttpSession httpsession =request.getSession();
   String res = (String) httpsession.getAttribute("show");

%>

<div class ="borderTop">
	<ul>
		<li class="top" ><a href="logout.jsp">LOGOUT</a></li>
		<li class="top" ><a href="profile.jsp">PROFILE</a></li>
		<li class="top" ><a href="repository.jsp">REPOSITORY</a></li>
        <li class="top" ><a href="home.jsp">HOME</a></li>
	</ul>

</div>

<div class="registerBody">
<h1 class ="register"> <%= res%>  </h1>

</div>


</body>
</html>

