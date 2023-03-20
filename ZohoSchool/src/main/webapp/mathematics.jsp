<%@page import="com.login.Course"%>
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
text-align :center;
font-family: Times new roman;
}

</style>


</head>
<body>



                         <%  
		                 
			                 String course_mat1=Course.getCourse_mat1();
			                 String course_mat2=Course.getCourse_mat2();
			               
			             
			             %>

<div class ="borderTop">
	<ul>
		
		<li class="top" ><a href="profile.jsp">PROFILE</a></li>
		<li class="top" ><a href="repository.jsp">REPOSITORY</a></li>
        <li class="top" ><a href="home.jsp">HOME</a></li>
	</ul>



</div>
  
	      
	      <div >
		  <img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://s3.amazonaws.com/coursera_assets/browse/domain-banner/math_and_logic.png?auto=compress&dpr=0.4&q=10&blur=5" width ="1950 px" height ="250px">
		</div>
	
		     <div class = "mainheading"">
		       <h1> Mathematics  </h1>
		     </div>
		 <div class="leftcourse">
		     <div class="column">
		          <img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/08/8c6610c07e11e6a7f5e70b413367a6/DMSIcon.jpg?auto=format%2Ccompress%2C%20enhance&dpr=1&w=600&h=204&fit=fill&q=50" width="300 px" height ="300 px"><br>
		          <p> University of Michigan </p>
		          <h3> Mathematics For Data Science </h3>
		              
		              
			            <button class="btn" onclick="location.href='enroll_web.jsp?course_name_1=<%=course_mat1%>'">Go to course</button>
		             
		      </div>
		
		
		             <div class="column">
		             
		                  <img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/6f/84dd00f4e311e5b1964b8e2cbb6cfc/intro_to_data_and_probability.png?auto=format%2Ccompress%2C%20enhance&dpr=1&w=600&h=204&fit=fill&q=50" width="300 px" height ="300 px"><br>
		                  <p> University of Michigan </p>
		                  <h3> Introduction to mathematical thinking </h3>
		                 
                           <button class="btn" onclick="location.href='enroll_web.jsp?course_name_1=<%=course_mat2%>'">Go to course</button>		             
		              </div> 
		            </div>
</body>
</html>


