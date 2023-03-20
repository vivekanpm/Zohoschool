package com.login;

import eu.bitwalker.useragentutils.*;




public class Parsing{
	
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
        
		   
   public static void main(String[] args){
	   String parse = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3";
    	
        UserAgent ua = UserAgent.parseUserAgentString(parse);
        Browser browser = ua.getBrowser();
        OperatingSystem os = ua.getOperatingSystem();
        String browserName = browser.getName();
        String osName = os.getName();
        System.out.println("Browser: " + browserName);
        System.out.println("Operating System: " + osName);
    }
}


