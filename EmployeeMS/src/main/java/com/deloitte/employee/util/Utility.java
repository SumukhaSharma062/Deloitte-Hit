package com.deloitte.employee.util;

import org.springframework.util.StringUtils;

public class Utility {

	public static Boolean validateString(String val)
	{
		if(val!=null && StringUtils.hasText(val))
			return true;
		else
			return false;
	}
	
	public static Boolean validateInt(Integer val)
	{
		if(val!=null)
			return true;
		else
			return false;
	}
}
