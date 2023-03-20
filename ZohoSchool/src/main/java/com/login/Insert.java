package com.login;


import java.util.regex.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.logindb.Database;

public class Insert  extends HttpServlet{
	
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=-_!])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
     }
    

		
	public void doPost (HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		String f_name =  req.getParameter("F_name");
		String l_name=  req.getParameter("L_name");
		String dob =  req.getParameter("dob");
	    String email=  req.getParameter("email");
	    String  pass= req.getParameter("pass");
	    
	    User.setEmail(email);
	    User.setF_name(f_name);
		User.setL_name(l_name);
		User.setDob(dob);
		User.setPass(pass);
		
	    
	    
	    if(isValidPassword(pass)==false) {
	    	//System.out.println("Password wrong");
	    	res.sendRedirect("error_password.jsp");
	    }
		
	    else {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		PrintWriter out = res.getWriter();
		
		try {
			
			
			Database db =new Database();
			
			rs=db. retriveEmailId();
			
			if(rs.next()==false ) {
					db.insertData();			
					db.insertEmail();			
					db.insertPass();		
					res.sendRedirect("index.html");
		}
		
			else {
				
				out.println("User already exist,Go to login page");
			}
			
			
		db.closeConnect();	
					
		}		
			
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    }

			
  } 

}


		
		
		
		
		
		
		
		