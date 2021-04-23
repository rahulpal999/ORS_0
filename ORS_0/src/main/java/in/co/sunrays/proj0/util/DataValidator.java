package in.co.sunrays.proj0.util;

/**
 * This class validates input data
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class DataValidator {

	 /**
    * Checks if value is Null
    * 
    * @param val
    * @return
    */
   
	public static boolean isNull(String value)
	{
		if(value==null||value.trim().length()==0)
		{
			return true;
		}
		else
		{
			return false;	
		}
		
	}
	
	 /**
    * Checks if value is NOT Null
    * 
    * @param val
    * @return
    */
   
	public static boolean isNOTNull(String value)
	{
		return !isNull(value);
	}
	
	 /**
    * Checks if value is an Integer
    * 
    * @param val
    * @return
    */

	public static boolean isInteger(String value)
	{
		
		if (isNOTNull(value))
		{
		try 
		{
			int i=Integer.parseInt(value);
			
			return true;
		} 
		catch (NumberFormatException e)
		{
			return false;
		}
			
		} 
		else 
		{
		return false;	
		}
		
		
		
		
	}
	
	  /**
    * Checks if value is Long
    * 
    * @param val
    * @return
    */
   		
		public static boolean isLong(String value)
		{
			if (isNOTNull(value))
			{
			try 
			{
				Long i=Long.parseLong(value);
				return true;
			} 
			catch (NumberFormatException e)
			{
				return false;
			}
				
			} 
			else 
			{
			return false;	
			}
		}
		
		 /**
	     * Checks if value is valid Email ID
	     * 
	     * @param val
	     * @return
	     */
	    
		public static boolean isEmailId(String email)
		{
			String emailreg="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (isNOTNull(email))
			{
			try 
			{
				return email.matches(emailreg);
			} 
			catch (NumberFormatException e)
			{
				return false;
			}		
			} 
			else
			{
           return false;
			}
		}
		
		 /**
	     * Checks if value is Date
	     * 
	     * @param val
	     * @return
	     */
	    
		
	 /**
		 * Checks if value is Phone No
		 * 
		 * @param val
		 * @return boolean
		 */
		public static boolean isPhoneNo(String val) 
		{
			String regex ="^[6-9]\\d{9}$";
			if (!val.matches(regex)) 
			{
				return true;
			} 
			else
			{	
				return false;
			}
		}
		
		
		
		
		/**
		 * Checks if value is name
		 * 
		 * @param val
		 * @return
		 */
		public static boolean isName(String val) {

		String name = "^[a-zA-Z]{3,15}$";
		System.out.println("isName method run");
			
			if (!val.matches(name)) 
			{
				return true;
			} else
			{
				return false;
			}
			
		}

		/**
		 * check value is in range 
		 * @param val
		 * @return
		 */
		public static boolean isRange(String val) {

			System.out.println("isRange method run");
			
			String name ="^[a-zA-Z]{3,15}$";
			if (!val.matches(name)) {
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean isRollNO(String val) {
		
			String passregex = "^([0-9]{2}[a-zA-Z]{2}[0-9]{2})$";
			if (!val.matches(passregex)) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Checks if value is Password
		 * 
		 * @param val
		 * @return boolean
		 */
		/*This regex will enforce these rules:

			At least one upper case English letter, (?=.*?[A-Z])
			At least one lower case English letter, (?=.*?[a-z])
			At least one digit, (?=.*?[0-9])
			At least one special character, (?=.*?[#?!@$%^&*-])
			Minimum eight in length .{8,} (with the anchors)
*/
		public static boolean isPassword(String val) {
			String passregex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

			if (val.matches(passregex))
			{
				return true;
			} 
			else
			{
				return false;
			}
		}
		
		
		public static boolean isMarks(String value)
		{
			System.out.println("is marks called");
			boolean pass=false;
			if(value=="null")
			{
				return true;
			}
			
			int i=Integer.parseInt(value);
			System.out.println("int value------------>"+i);
		   
			
			if(i<100 )
			{
		    pass=true;
			}
			return pass;
			
			
		}

		public static boolean isMark(String value)
		{
			boolean pass=true;
		
			if(value=="null")
			{
				return pass;
			}
			
			
			int i=Integer.parseInt(value);
			System.out.println("int value------------>"+i);
		    	
			if(i<0 )
			{
		    pass=false;
			}
			return pass;
			
			
		}

		/**
		 * Checks if value contains White Space
		 * 
		 * @param val
		 * @return boolean
		 */
		public static boolean isWhiteSpace(String val) {
			if (val.matches(".*\\s+.*")) {
				return true;
			} else {
				return false;
			}
		}

		public static boolean isName2(String val) {

			String name = "[a-zA-Z][a-zA-Z ]+";

			if (isNOTNull(val)) {
				try {

					return val.matches(name);

				} catch (NumberFormatException e) {
					return false;
				}
			} else {
				return false;
			}
		}

		/**
		 * Checks White Space
		 * 
		 * @param val
		 * @return boolean
		 */
		public static boolean isNameWithSpace(String val) {
			String name = "[a-zA-Z ]*";
			if (isNOTNull(val)) {
				try {
					return val.matches(name);

				} catch (NumberFormatException e) {
					return false;
				}

			} else {
				return false;
			}
		}
		
		

}
