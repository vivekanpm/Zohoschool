package com.login;

public class Course {
	
	// mat: Mathematics , bus:Business, cs:Computer science 
	
	private static String course_mat1 ;
	private static String course_mat2 ;
	private static String course_bus1;
	private static String course_bus2 ;
	private static String course_cs1 ;
	private static String course_cs2 ;
	private static String enroll_course ;
	
	
	
	public static String getCourse_mat1() {
		return course_mat1;		
	}
	
	public static void setCourse_mat1(String mat1) {
		course_mat1 = mat1;
	}
    
	public static String getCourse_mat2() {
		return course_mat2;		
	}
	
	public static void setCourse_mat2(String mat2) {
		course_mat2 = mat2;
	}
	
	public static String getCourse_bus1() {
		return course_bus1;		
	}
	
	public static void setCourse_bus1(String bus1) {
		course_bus1 = bus1;
	}
	
	public static String getCourse_bus2() {
		return course_bus2;		
	}
	
	public static void setCourse_bus2(String bus2) {
		course_bus2 = bus2;
	}
	public static String getCourse_cs1() {
		return course_cs1;		
	}
	
	public static void setCourse_cs1(String cs1) {
		course_cs1 = cs1;
	}
	public static String getCourse_cs2() {
		return course_cs2;		
	}
	
	public static void setCourse_cs2(String cs2) {
		course_cs2= cs2;
	}
	
	public static void setEnroll_course(String Ec) {
		enroll_course= Ec;
	}
	
	public static String getEnroll_course() {
		return enroll_course;
		
	}
	
	
}