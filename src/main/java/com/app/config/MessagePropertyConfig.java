package com.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:message.properties")
public class MessagePropertyConfig {

	public static String SUCCESS_CREDENTIAL;
	public static String ERROR_INVALID_CREDENTIAL;
	
	@Value("${success.credential}")
	public void setSUCCESS_CREDENTIAL(String sUCCESS_CREDENTIAL) {
		SUCCESS_CREDENTIAL = sUCCESS_CREDENTIAL;
	}
	
	@Value("${error.invalid.credential}")
	public void setERROR_INVALID_CREDENTIAL(String eRROR_INVALID_CREDENTIAL) {
		ERROR_INVALID_CREDENTIAL = eRROR_INVALID_CREDENTIAL;
	}
}
