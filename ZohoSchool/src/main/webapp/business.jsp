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
font-family: Times new roman;
}

</style>


</head>


<body>

                         <%  
                         
	                 		 
			           /*       HttpSession sess = request.getSession();
			                 String course_3 =   (String)session.getAttribute("cour3");
			                 String course_4 =   (String)session.getAttribute("cour4"); */
			             
			                 String course_bus1= Course.getCourse_bus1();
			                 String course_bus2= Course.getCourse_bus2();
			                 
			                 String course_cs1= Course.getCourse_cs1();
			                 String course_cs2= Course.getCourse_cs2();
			             
			             %>
			             

<div class ="borderTop">
	<ul>
		
		<li class="top" ><a href="profile.jsp">PROFILE</a></li>
		<li class="top" ><a href="repository.jsp">REPOSITORY</a></li>
        <li class="top" ><a href="home.jsp">HOME</a></li>
	</ul>



</div>
  
	   

		<div >
		  <img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://s3.amazonaws.com/coursera_assets/browse/domain-banner/math_and_logic.png?auto=compress&dpr=0.4&q=10&blur=5" width ="1950 px" height =" 250px">
		</div>
	
		     <div  class ="mainheading">
		       <h1>Business </h1>
		     </div>
	  <div class="leftcourse">  
	  
		     <div class="column">
		          <img src=" https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/51/51d7604aba11e7ae3525d9720463e7/Shiller_FinancialMarkets_New.png?auto=format%2Ccompress%2C%20enhance&dpr=1&w=600&h=204&fit=fill&q=50 " width="300 px" height ="300 px"><br>
		          <p> University of Michigan </p>
		          <h3> Financial Market </h3>
		                     
			       
			       <button class="btn" onclick="location.href='enroll_web.jsp?course_name_1=<%=course_bus1%>'" >Go to course</button>
			       		             
		      </div>
		
		
		             <div class="column">
		             
		                  <img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/dc/9f98f0336111e69f8b4d7acdaafbd1/Brueghel-Children.jpg?auto=format%2Ccompress%2C%20enhance&dpr=1&w=600&h=204&fit=fill&q=50 " width="300 px" height ="300 px"><br>
		                  <p> University of Michigan </p>
		                  <h3> Game Theory </h3>
		                 
		                 <button class="btn" onclick="location.href='enroll_web.jsp?course_name_1=<%=course_bus2%>'" >Go to course</button>
		             
		              </div> 

            </div> 
</body>
</html>


