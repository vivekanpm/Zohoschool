package com.login;




public class User {
	
	public static String email;
	public static String secemail;
	public static int user_id;
	public static int email_id;
	public static String f_name;
	public static String l_name;
	public static String dob;
	public static String pass;
	public static String userAgent;
	
	
	
	public static String getEmail() {
		return email;
	}
	
	public static void setEmail(String par_email) {
		email=par_email;
	}
	
	public static String getSecemail() {
		return secemail;
	}
	
	public static void setSecEmail(String par_secemail) {
		secemail=par_secemail;
	}
	
	public static int getUserid() {
		return user_id;
	}
	
	public static void setUserid(int par_user_id) {
		user_id=par_user_id;
	}
	
	
	public static int getEmailid() {
		return email_id;
	}
	
	public static void setEmailid(int par_email_id) {
		email_id=par_email_id;
	}
	
	public static String getF_name() {
		return f_name;
	}
	
	public static void setF_name(String par_F_name) {
		f_name=par_F_name;
	}
	
	public static String getL_name() {
		return l_name;
	}
	
	public static void setL_name(String par_L_name) {
		l_name= par_L_name;
	}
	
	public static String getDob() {
		return dob;
	}

	public static void setDob(String par_dob) {
		dob= par_dob;
	}
	
	public static String getPass() {
		return pass;
	}
	
   	public static void setPass(String par_pass) {
		pass= par_pass;
	}
   	
   	public static String getUseragent() {
		return userAgent;
	}
	
	public static void setUseragent(String par_useragent) {
		userAgent= par_useragent;
	}
	
}

