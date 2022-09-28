package com.sv.ar.utilities;

import javax.servlet.http.HttpServletRequest;

public class Validate {

	
	public static boolean validateToken(HttpServletRequest request)
	{
		try
		{
			String token= request.getHeader("Authorization");
			if(token.equals("THISISMYJSONWEBTOKEN"))
				return true;
			return false;
		}
		catch(Exception e)
		{
		 return false;	
		}
		
	}
}
