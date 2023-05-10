package com.qa.practicerediff.utilities;

import java.util.Date;

public class PracticeRediff_Utilities {
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace("", "_").replace(":", "_");
		return "chowdhurygs" +emailTimeStamp+ "@rediffmail.com";
		
	}
	
   public static CharSequence generatePasswordWithTimeStamp() {
	   Date date1 = new Date();
	   String passwordTimeStamp = date1.toString().replace("", "_").replace(":", "_");
	   return "Shajlee" +passwordTimeStamp+ "1@";
	   
   }
   
   public static final int IMPLICIT_WAIT_TIME = 10;
   public static final int PAGELOAD_TIME = 10;
   public static final int SCRIPT_TIMEOUT = 100;
   
		
	}



