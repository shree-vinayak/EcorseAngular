package com.sv.ar.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.ar.entities.Login;
import com.sv.ar.repositories.Login_repo;
import com.sv.ar.utilities.ResponseWrapper;

@Service
public class LoginService {

	@Autowired
	private Login_repo loginrepo;

	public Object validateLogin(Login login) {

		ResponseWrapper result = new ResponseWrapper();

		try {
			Login loginObjDB = loginrepo.loadByUsername(login.getUsername());
			if (loginObjDB.getUsername().equals(login.getUsername())
					&& loginObjDB.getPassoword().equals(login.getPassoword())) {
				loginObjDB.setToken("THISISMYJSONWEBTOKEN");
				result.setData(loginObjDB);
				result.setFlag(true);
				result.setMsg("Login Successfully");

			}
			else
			{
				result.setData(null);
				result.setFlag(false);
				result.setMsg("Invalid credential");
			}
			

		} catch (Exception e) {
			result.setFlag(false);
			result.setMsg("Invalid credential");
			result.setData(null);

		}
		return result;
	}

	public Object register(Login login) {

		ResponseWrapper result = new ResponseWrapper();
		try {

			login = loginrepo.save(login);
			result.setData(login);
			result.setFlag(true);
			result.setMsg("Registered Successfully");
			
		} catch (Exception e) {
			result.setFlag(false);
			result.setMsg("Can Not Register, Username is already available");
			result.setData(null);
		}

		return result;
	}

}
