package com.login;

import java.security.PublicKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class Parsings {
	
	     static String new_browser;
		 static String new_operatingSystem;
		 
	   public  static void setBrowser(String par_browser) {
		 new_browser =par_browser;
		}
	    public static String getBrowser() {
	    	return new_browser;
	    }
	    
	    public  static void setOs(String par_operatingSystemStrin) {
			 new_operatingSystem =par_operatingSystemStrin;
		}
	    public static String getOs() {
	    	return new_operatingSystem;
	    }
   

	public  void parsed (String parse) {
		
		
        UserAgent ua = UserAgent.parseUserAgentString(parse);
        Browser browser = ua.getBrowser();
        OperatingSystem os = ua.getOperatingSystem();
        String browserName = browser.getName();
        String osName = os.getName();
        
        System.out.println("Browser: " + browserName);
        System.out.println("Operating System: " + osName);
//    	String new_browser="" ; 
//    	String new_operatingSystem="";
//    	
//        String userAgent = parse;
//
//        // Regular expressions to match operating system and browser information
//        String osRegex = "\\((.*?)\\)";
//        String browserRegex = "(\\w+)/(\\d+(?:\\.\\d+)?)";
//
//        // Extract operating system information
//        Pattern pattern = Pattern.compile(osRegex);
//        Matcher matcher = pattern.matcher(userAgent);
//        String os = "
//        if (matcher.find()) {
//            os = matcher.group(1);
//        }
//
//        // Extract browser information
//        pattern = Pattern.compile(browserRegex);
//        matcher = pattern.matcher(userAgent);
//        String browser = "";
//        if (matcher.find()) {
//            browser = matcher.group(1);
//            String version = matcher.group(2);
//            browser += " " + version;
//        }
//        
//
//        
//        //Parsing ps=new Parsing();
//        Parsing.setOs(os);
//        Parsing.setBrowser(browser);
//        
        
	}  
	
   

    
 }

