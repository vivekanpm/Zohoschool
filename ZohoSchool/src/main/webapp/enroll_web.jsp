<%@page import="com.login.Course"%>
<%@page import="javax.xml.stream.events.Comment"%>
<%@page import="javax.swing.plaf.synth.SynthOptionPaneUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="com.logindb.Database" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel ="stylesheet" href="web.css">
<style> 
body {font-family: arial;}

button{
  background-color: #99ccff;
  width : 40%;
  height :  80px;
 font-size :large;
 text-align: center;
  margin-top : 10px;
  margin-left : 100px;
}

</style>


</head>

<body>

   <%!
	     Connection con = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null; 

   %>
	
   <%    
						HttpSession httpsession =request.getSession();
		         		
		                String course_name =request.getParameter("course_name_1");  
	                    Course.setEnroll_course(course_name);
		            	
				     	Database db = new Database();						
						rs=db.course_page();
						rs.next();
	

						String video = rs.getString(2);
						String course_description = rs.getString(3);
						String instructor = rs.getString(4);
						String offered = rs.getString(5);
						String image = rs.getString(7); 
								
				
				
 	%>
 		

  <div class ="borderTop">
     
     <p class="p1"> Fall 2023 | Undergraduate  </p>
     <h1 class="h1">  <%= course_name%> </h1>
</div> 
     <div class = "borderMid"> 
              <div class="menu">
					    <a href="#">Syllabus</a>
					    <a href="#">Lecture videos</a>
					    <a href="#">Lecture notes</a>
					    <a href="#">Assignment</a>
             </div>
             <form action="enrol" method="post">
                      
			          <button class="button" onclick="location.href='registered.jsp'" > Enroll</button> <br>
		       </form>
		             
             
      </div> 
          
            <div class = "borderLeft">
              <div class = "whole">
	                <h2 class="h2"> COURSE DESCRIPTION</h2>
	           
	                <p class="p" > <%= course_description %> </p>
	                
	                
	                <h2 class="h3">INSTRUCTOR </h2>
	                <p class="p2"> <%= instructor %> </p>
	              <h2 class= "v1"> VIDEO LECTURE</h2>
	            <iframe width="800" height="350"src=<%=video %> title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>  
            </div>
           </div> 
           
            <div class = "borderRight">
              <h1> Offered by </h1> 
              <img class ="margin" src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/http://coursera-university-assets.s3.amazonaws.com/c0/87a10033a311e892619b85c6fd62bb/IBM-200x48.png?auto=format%2Ccompress&dpr=1&w=&h=45">
              <img class = "courseImagedown" src ="<%= image %>   alt ="course name" width="300" height="300">
  
            </div>
                
           
</body>
</html>






























  