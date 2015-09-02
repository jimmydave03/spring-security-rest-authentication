package com.app.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.app.service.AuthenticationService;

@Component
public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Autowired
	AuthenticationService authenticationService;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		
		authException.printStackTrace();
		authenticationService.setUnAuthenticationResponse(request, response);
	}
}