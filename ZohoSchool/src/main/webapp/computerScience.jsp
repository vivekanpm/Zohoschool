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
/*  		                	 HttpSession httpsession =request.getSession();
		                 		
                              if (httpsession.getAttribute("Email")== null){
		                 			
		                 			response.sendRedirect("index.html");
		                 		}  */ 
		                 					                 
				                 String course_cs1=Course.getCourse_cs1();
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
		       <h1 class="coursehead"> Computer Science </h1>
		     </div>
		 <div class="leftcourse">
		     <div class="column">
		          <img src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://d15cw65ipctsrr.cloudfront.net/da/507477bbb74db4b7f98d1d50f15cbb/IBM-DW-Eng-PC-Coursera-Final-1-.png?auto=format%2Ccompress%2C%20enhance&dpr=1&w=600&h=204&fit=fill&q=50" width="300 px" height ="300 px"><br>
		          <p> University of Michigan </p>
		          <h3> IBM Data Science course </h3>
		              
		                      <button class="btn" onclick="location.href='enroll_web.jsp?course_name_1=<%=course_cs1%>'" >Go to course</button>
		             
		      </div>
		
		
		             <div class="column">
		             
		                  <img src=" https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://d15cw65ipctsrr.cloudfront.net/bd/0202c87e244d30bdecd889bd2719ae/DataScienceFundamentalsPythonSQL.png?auto=format%2Ccompress%2C%20enhance&dpr=1&w=600&h=216&q=50&fit=fill" width="300 px" height ="300 px"><<br>
		                  <p> University of Michigan</p>
		                  <h3> Design Thinking for Innovation</h3>
		                 
		              <button class="btn" onclick="location.href='enroll_web.jsp?course_name_1=<%=course_cs2%>'">Go to course</button>
		             
		              </div>
		       </div>

</body>
</html>


