package com.minitues.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authentication(String username,String password)
	{
		boolean isValidUserName=username.equalsIgnoreCase("in28minitues");
		boolean isValidPassword=password.equalsIgnoreCase("dummy");
		return isValidUserName && isValidPassword;
		
	}

}
