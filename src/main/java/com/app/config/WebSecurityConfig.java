package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.authentication.RESTAuthenticationEntryPoint;
import com.app.authentication.RESTAuthenticationFailureHandler;
import com.app.authentication.RESTAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*@Autowired
	UserService userService;
	*/
	
	@Autowired
	private RESTAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private RESTAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
 
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
          	
    	http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.formLogin().successHandler(authenticationSuccessHandler);
		http.formLogin().failureHandler(authenticationFailureHandler);
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("jimmyd").password("1234").roles("USER");
    }
    
    /*@Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
           return super.userDetailsServiceBean();
    }*/
    
   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService());
    }*/
    
	/*@Bean
	protected UserDetailsService userDetailsService() {
		return new UserDetailsService() {
	  
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				
			UserEntity userEntity = userService.getUserByEmail(email);
			if(userEntity != null) {
				return new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
			} else
				throw new UsernameNotFoundException("could not find the user '"+ email + "'");
			}   
		};
	}*/

}
