package com.app.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.app.config.Constants;
import com.app.config.JSONResponse;
import com.app.config.MessagePropertyConfig;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

	/*@Autowired
	private UserDao userDao;*/
	
	@Override
	public void setUnAuthenticationResponse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		ObjectMapper jsonMapper = new ObjectMapper();
	    JSONResponse<HashMap<String, Object>> jsonResponse = new JSONResponse<HashMap<String,Object>>();
		jsonResponse.setStatus(Constants.ERROR);
		jsonResponse.setMessage(MessagePropertyConfig.ERROR_INVALID_CREDENTIAL);
			
	    response.setContentType("application/json;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	     
	    out.print(jsonMapper.writeValueAsString(jsonResponse));
	}

	@Override
	public void setAuthenticatedResponse(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		JSONResponse<HashMap<String, Object>> jsonResponse = new JSONResponse<HashMap<String,Object>>();
		
		//UserEntity users = userDao.getUserByEmail(authentication.getName());
		ObjectMapper jsonMapper = new ObjectMapper();
			
		/*if(users != null) {
			jsonResponse.setStatus(Constants.SUCCESS);
			jsonResponse.setMessage(MessagePropertyConfig.SUCCESS_CREDENTIAL);
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("uuid", users.getUuidCode());
			data.put("sid", request.getSession().getId());
			jsonResponse.setData(data);
		}*/
		
		System.out.println(authentication.getPrincipal());
		response.setContentType("application/json;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	     
	    out.print(jsonMapper.writeValueAsString(jsonResponse));
	}

}
