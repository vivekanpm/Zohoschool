package com.logindb;

import eu.bitwalker.useragentutils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SelectableChannel;
import java.security.DrbgParameters.NextBytes;
import java.security.PublicKey;
import java.sql.*;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.Course;
import com.login.Hashing;
import com.login.Parsing;
import com.login.User;

public class Database extends HttpServlet{
	
	int course_id;
	static int session_id;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =null;

	
	public static Connection connect() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/ZohoScl";
		String username="root";
		String pass= "Michael_scoot";
		
		Class.forName("com.mysql.jdbc.Driver");
		return(DriverManager.getConnection(url,username,pass));
	}
	
	public  Connection connect1() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/model_db";
		String username="root";
		String pass= "Michael_scoot";
		
		Class.forName("com.mysql.jdbc.Driver");
		return(DriverManager.getConnection(url,username,pass));
	}
	
	public void closeConnect() throws SQLException {
		con.close();
		ps.close();
	}
	
	
	
	public static void user_details() throws SQLException, ClassNotFoundException{
		 
		String email=User.getEmail();
		String query = "SELECT User_details.user_id,first_name,last_name,dob,email_id,Email FROM User_details JOIN Email_details ON User_details.user_id=Email_details.user_id WHERE Email = ?";
		Connection con=connect();
		PreparedStatement  ps =  con.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs= ps.executeQuery();
		rs.next();
		
		User.setUserid(rs.getInt(1));
		User.setF_name(rs.getString(2));
		User.setL_name(rs.getString(3));
		User.setDob(rs.getString(4));
		User.setEmailid(rs.getInt(5));
	}
		
		
	public static int getCourseId() throws ClassNotFoundException, SQLException {
		
		String course_name = Course.getEnroll_course();
		String query ="SELECT * FROM Course_details WHERE Course_name = ?";
		Connection con=connect();
		PreparedStatement  ps2 =  con.prepareStatement(query);
		ps2.setString(1, course_name);
		ResultSet rs2= ps2.executeQuery();
		rs2.next();
		int course_id= rs2.getInt(1);
		return course_id;
	}

	
	public String select() {
		String query = "SELECT * FROM User_details";
		return query;
	}
	
	public  void insertData() throws ClassNotFoundException, SQLException {
		String first_name =User.getF_name();
		String last_name =User.getL_name();
		String dob=User.getDob();
		
		String query = "INSERT INTO User_details (first_name,last_name,dob)  values (?,?,?)";
		
		Connection con=connect();
		PreparedStatement  ps =  con.prepareStatement(query);
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.setString(3, dob);
		ps.executeUpdate();
			
	}
	
	public String retriveUserId() {
		String query = "SELECT * from User_details WHERE first_name=? and last_name =?";
		return query;
	}	
	
	public  void insertEmail() throws SQLException, ClassNotFoundException {
		
		String first_name =User.getF_name();
		String last_name =User.getL_name();
		String email=User.getEmail();
		
		String query1 = "SELECT * from User_details WHERE first_name=? and last_name =?";
		String query2 = "INSERT INTO Email_details (user_id,Email,Is_primary,Created_at,Is_verified)  values (?,?,?,CURRENT_DATE,?)";
		
		Connection con=connect();
		PreparedStatement  ps =  con.prepareStatement(query1);
		ps.setString(1, first_name);
		ps.setString(2,last_name);
		ResultSet rs= ps.executeQuery();
		rs.next();
		int user_id = rs.getInt(1);

		Connection con2=connect();
		PreparedStatement  ps2 =  con.prepareStatement(query2);
		ps2.setInt(1, user_id);
		ps2.setString(2,email);
		ps2.setBoolean(3,true);
		ps2.setBoolean(4,true);
		ps2.executeUpdate();
	}
	
	
	public void insertsecEmail() throws SQLException, ClassNotFoundException {
		
		Database.user_details();
		int user_id=User.getUserid();
		String secemail=User.getSecemail();
		String query = "INSERT INTO Email_details (user_id,Email,Is_primary,Created_at,Is_verified)  values (?,?,?,CURRENT_DATE,)";

		Connection con=connect();
		PreparedStatement  ps2 =  con.prepareStatement(query);
		ps2.setInt(1, user_id);
		ps2.setString(2,secemail);
		ps2.setBoolean(3,false);
		ps2.setBoolean(4,false);
		ps2.executeUpdate();
	}
	
	public  ResultSet retriveEmailId() throws SQLException, ClassNotFoundException  {
		
		String email=User.getEmail();
		String query = "SELECT * from Email_details WHERE Email=?";
	    con=connect();
		ps =  con.prepareStatement(query);
		ps.setString(1, email);
		rs= ps.executeQuery();
		return rs;		
	}
	
	public  void insertPass() throws SQLException, ClassNotFoundException {
		String pass =User.getPass();
		
		String first_name =User.getF_name();
		String last_name =User.getL_name();
		
		Hashing hs = new Hashing();
		String hashed_pass = hs.passwordTransfer(pass);
		String query1 = "SELECT * from User_details WHERE first_name=? and last_name =?";
		String query2 = "INSERT INTO Password_details (user_id,password)  values (?,?)";
		
		Connection con=connect();
		PreparedStatement  ps =  con.prepareStatement(query1);
		ps.setString(1, first_name);
		ps.setString(2,last_name);
		ResultSet rs= ps.executeQuery();
		rs.next();
		int user_id = rs.getInt(1);
		
		Connection con2=connect();
		PreparedStatement  ps2 =  con.prepareStatement(query2);
		ps2.setInt(1, user_id);
		ps2.setString(2,hashed_pass);
		ps2.executeUpdate();
		
	}
	
	public ResultSet  validateData() throws SQLException, ClassNotFoundException{
		
		String email=User.getEmail();
		String query = "SELECT Email_details.email_id,Email,pass_id,password  FROM Email_details  JOIN Password_details ON Email_details.user_id = Password_details.user_id WHERE Email= ?";
		con=connect();
	    ps=  con.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs= ps.executeQuery();
		return rs;
	}
	
	public String userIdDataString () {
		
		String query ="SELECT * FROM User_details JOIN Email_details ON User_details.user_id=Email_details.user_id WHERE Email = ?;";
		return query;		
	}
	
	public String courseIdData () {
		String query ="SELECT * FROM Course_details WHERE Course_name = ?";
		return query;		
	}
	
	public static ResultSet enrolledcheck() throws SQLException, ClassNotFoundException{
		Database.user_details();
		int user_id = User.getUserid();
		int course_id =getCourseId();
		String query =  "SELECT course_id FROM Register_table  WHERE user_id = ? and course_id=?" ;
		Connection con=connect();
		PreparedStatement  ps =  con.prepareStatement(query);
		ps.setInt(1, user_id);
		ps.setInt(2, course_id);
		ResultSet rs = ps.executeQuery();
		return rs;
		
	}
	
	public static void insertCourseData() throws SQLException, ClassNotFoundException {
		
		Database.user_details();
		int user_id = User.getUserid();
		int course_id =Database.getCourseId();
		
		String query = "INSERT INTO Register_table (user_id,course_id,course_start_date)  values (?,?,current_date)";
		Connection con=connect();
		PreparedStatement  ps =  con.prepareStatement(query);
		ps.setInt(1, user_id);
		ps.setInt(2, course_id);
		ps.executeUpdate();
	}

	public static void updateStatus() throws SQLException, ClassNotFoundException{
		
		int user_id = User.getUserid();
		int course_id =getCourseId();
		String query ="call enroll(?,?)";
		Connection con=connect();
		PreparedStatement  ps =  con.prepareStatement(query);
		ps.setInt(1, user_id);
		ps.setInt(2, course_id);
		ps.executeUpdate();
		
	}
	
	
	public ResultSet retriveName() throws SQLException, ClassNotFoundException{
		
		String email=User.getEmail();
		String query =  "SELECT first_name,last_name,dob,created_at  FROM User_details JOIN Email_details ON User_details.user_id=Email_details.user_id WHERE Email = ? " ;
		Connection con =connect();
		PreparedStatement ps =  con.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs= ps.executeQuery();
		return rs;	
		
	}
	
public ResultSet getPrimaryemail() throws SQLException, ClassNotFoundException {
		
		Database.user_details();
	    int user_id =User.getUserid();
	    
		String query1 = "SELECT Email FROM Email_details  WHERE user_id =? and Is_primary = 1";
		Connection con =connect();
		ps =  con.prepareStatement(query1);
		ps.setInt(1,user_id);
		rs= ps.executeQuery();
		return rs;
	}
	
	public ResultSet emailSecondary() throws SQLException, ClassNotFoundException {
		
		Database.user_details();
	    int user_id =User.getUserid();
		String query1 = "SELECT * FROM Email_details  WHERE user_id =? and Is_primary = 0";
		
		Connection con =connect();
		ps =  con.prepareStatement(query1);
		ps.setInt(1,user_id);
		rs= ps.executeQuery();
		return rs;
	}
	
	public ResultSet course_page() throws ClassNotFoundException, SQLException {
		String course_name = Course.getEnroll_course();
		String query = "SELECT * FROM course WHERE course_name=?";
		Connection con =connect1();
		ps =  con.prepareStatement(query);
		ps.setString(1,course_name);
		rs= ps.executeQuery();
		return rs;
			
		
	}
	
	public ResultSet repoData() throws SQLException, ClassNotFoundException {
		String email=User.getEmail();
		String query = "SELECT user_id ,Course_details.course_id,Email,course_name,status,course_image\n"
				+ "FROM Course_details JOIN (SELECT Email_details.user_id ,course_id,Email,status FROM Email_details JOIN Register_table ON Email_details.user_id = Register_table.user_id) AS fin\n"
				+ "ON Course_details.course_id=fin.course_id WHERE Email=?";
		con =connect();
		ps =  con.prepareStatement(query);
		ps.setString(1, email);
		rs= ps.executeQuery();
		return rs;
		
	
	}		
	
	public void insertSession() throws ClassNotFoundException, SQLException {
		
		Database.user_details();
	    int user_id =User.getUserid();
		String email=User.getEmail();
		String userAgent =User.getUseragent();
		
		UserAgent ua = UserAgent.parseUserAgentString(userAgent);
        Browser browser = ua.getBrowser();
        OperatingSystem os = ua.getOperatingSystem();
        String browserName = browser.getName();
        String osName = os.getName();
		String query ="INSERT INTO Session (user_id,browser,os,login_time,duration,Is_active) values(?,?,?,now(),DATEDIFF(login_time,logout_time),?)";
		String query1 ="select last_insert_id()";
		
		Connection con =connect();
		ps =  con.prepareStatement(query);
		ps.setInt(1,user_id);
		ps.setString(2,browserName);
		ps.setString(3,osName);
		ps.setBoolean(4, true);
		ps.executeUpdate(); 
		
		ps =  con.prepareStatement(query1);
		rs= ps.executeQuery();
		rs.next();
		session_id =rs.getInt(1);

	}
	
	public void logoutSession() throws ClassNotFoundException, SQLException {
		
		String query ="UPDATE Session SET logout_time= now() WHERE session_id=?";
		String query1 ="UPDATE Session SET Is_active= false WHERE session_id=?";
		String query2 ="UPDATE Session  SET duration = CONCAT(TIMESTAMPDIFF(HOUR, login_time, NOW()), 'h ', MOD(TIMESTAMPDIFF(MINUTE, login_time, NOW()), 60), 'm') WHERE session_id=?";

		Connection con =connect();
		ps =  con.prepareStatement(query);
		ps.setInt(1, session_id);
		ps.executeUpdate();
		

		ps =  con.prepareStatement(query1);
		ps.setInt(1, session_id);
		ps.executeUpdate();
		
		ps =  con.prepareStatement(query2);
		ps.setInt(1, session_id);
		ps.executeUpdate();
	}
	
	public ResultSet profileSession() throws ClassNotFoundException, SQLException {
		
		Database.user_details();
	    int user_id =User.getUserid();
		String query= "SELECT login_time,browser,os FROM Session WHERE user_id = ? and Is_active=1";
		Connection con =connect();
		ps =  con.prepareStatement(query);
		ps.setInt(1, user_id);
		rs=ps.executeQuery();
		return rs;				
	}	
	
	public void modifyEmail() throws ClassNotFoundException, SQLException {
		
		Database.user_details();
	    int user_id =User.getUserid();
		String query ="UPDATE Email_details SET Is_primary= 0 WHERE user_id=? and Is_primary =1 ";

		Connection con =connect();
		ps =  con.prepareStatement(query);
		ps.setInt(1, user_id);
		ps.executeUpdate();

	}
	
	
	
	
}


