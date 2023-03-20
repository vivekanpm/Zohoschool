<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.login.User" %>
<%@ page import="com.login.Course" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="course.css">

<style>

body{

text-align :center;
font-family:sans-serif; 
background-image: url("bg1.jpg");
}




* {
  box-sizing: border-box;
}

</style>

</head>



<body>

<%     		
    Course.setCourse_mat1("Mathematicsfor Data Science");
    Course.setCourse_mat2("Introduction to mathematical thinking");
    Course.setCourse_bus1("Financial Market");
    Course.setCourse_bus2("Game theory"); 
    Course.setCourse_cs1("IBM Data Science Professional Certificate");
    Course.setCourse_cs2("Design Thinking for Innovation");      		
%>

<div class ="borderTop">
	<ul>
		<li class="top" ><a href="profile.jsp">PROFILE</a></li>
		<li class="top" ><a href="repository.jsp">REPOSITORY</a></li>
        <li class="top" ><a href="home.jsp">HOME</a></li>
	</ul>

</div>
  
     
   <h1 class="welcome"> Welcome back !</h1>


<div style = "margin : auto ;">

<h2 class ="center">Get your Education today !</h2>

</div>
    
    <div class="column1">
        <a href = mathematics.jsp><img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://s3.amazonaws.com/coursera_assets/browse/domains/data_science.png?auto=compress&dpr=1&w=&h=340&fit=crop" width="350 px" height ="200 px"></a><br>
         <p class= "para_fond"> Mathematics </p>
    </div>
    
   <div class="column">
             <a href = business.jsp><img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://s3.amazonaws.com/coursera_assets/browse/domains/business.png?auto=compress&dpr=1&w=&h=160&fit=crop" width="350 px" height ="200 px"></a><br>
            <p class= "para_fond"> Business</p>
       </div>

            <div class="column">
                 <a href = computerScience.jsp><img src=" https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://s3.amazonaws.com/coursera_assets/browse/domains/computer_science.png?auto=compress&dpr=1&w=&h=160&fit=crop" width="350 px" height ="200 px"></a><br>
                <p class= "para_fond"> Computer science</p>
             </div> 
            
</body>
</html>




   