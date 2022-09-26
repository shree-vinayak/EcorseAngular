package com.sv.ar.utilities;

import javax.servlet.http.HttpServletRequest;

public class Validate {

	
	public static boolean validateToken(HttpServletRequest request)
	{
		String token= request.getHeader("Authorization");
		if(token.equals("THISISMYJSONWEBTOKEN"))
			return true;
		return false;
	}
}
