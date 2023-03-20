<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> 

body {font-family: Helvetica;
background-image: url("bg.jpg");
}

form {border: 2px  solid red
width 300px;}



input[type=text], input[type=password] {
  width: 75%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid grey;
  box-sizing: border-box;
}

.bodyindex{
	text-align: center;
	margin: 200px 400px 500px 740px ;
}

.buttonindex{
  background-color:#0066ff;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 75%;
}

.error{
text-align:center;
}

.borderindex {
  border: 7px #4266f5 ;
  border-radius : 15px;
  padding: 25px 50px;
  background-color: white;
  width:300px;
  


</style>
</head>
<body>

<% HttpSession httpsession =request.getSession();
   String err_msg = (String) httpsession.getAttribute("error");

%>

<div class="error">
 <h1><%=err_msg%></h1>
</div>

	<div class="bodyindex">
	
	    <div class="borderindex">
	   
	    <h2>Welcome back</h2>
	    
	    
	    <form action ="login" method="post">
	    
	 
	    <input type="text" placeholder="Enter Username" name ="email" required> <br>
	    <input type="password" placeholder="Enter password" name ="pass" required> <br>
	    
	    <button  class = "buttonindex"> LOGIN </button> <br>
	
	    </form>
	
	
	    New user <a  href="user_signup.html"> sign up</a>
	    
	    
	   </div>
	</div>

</body>
</html>