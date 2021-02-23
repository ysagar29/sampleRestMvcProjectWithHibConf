package com.incture.utils;

public class HelperClass {

	// private static final Logger logger =
	// LoggerFactory.getLogger(HelperClass.class);

	public static boolean checkString(String s) {
		if (s == null || s.equals("") || s.trim().isEmpty() || s.matches("") || s.equals(null)) {
			return true;
		}
		return false;
	}

}
