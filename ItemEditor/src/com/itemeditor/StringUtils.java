package com.itemeditor;

public class StringUtils {

	public static boolean isInteger(Object arg) {
		if (arg == null)
			return false;

		try {
			Integer.parseInt(arg instanceof String ? (String) arg : arg.toString());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDouble(Object arg) {
		if (arg == null)
			return false;

		try {
			Double.parseDouble(arg instanceof String ? (String) arg : arg.toString());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
	
	public static String applyColors(char replace, String string) {
		
		return string.replaceAll(String.valueOf(replace), "\u00A7");
	}
	
	public static String applyColors(String string) {
		
		return applyColors('&', string);
	}
	
	public static boolean equalsIgnoreCase(String arg0, String...arg1) {
		for (String s : arg1)
			if (s.equalsIgnoreCase(arg0))
				return true;
		
		return false;
	}

	public static class UUIDUtils {


		/**
		 * Checking if a string is a UUID.
		 * @param arg the string argument.
		 * @return if the string is a UUID.
		 */
		public static boolean isUUID(String arg) {
			if (arg == null)
				return false;
			return arg.matches("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}");
		}
		
		/**
		 * Adding hyphens to UUID.
		 * @param input the base UUID.
		 * @return the new UUID.
		 */
		public static String addHyphens(String input) {
			String uuid = input.replaceAll(                                            
					"(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",                            
					"$1-$2-$3-$4-$5");
			
			return uuid;
		}
		
	}
}
