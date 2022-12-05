package com.example.book5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.book5.service.UserService;
import com.example.book5.service.impl.UserSecurityService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;
	@Autowired
	UserSecurityService userSecurity;
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//		//encode user's password
//        return new BCryptPasswordEncoder();
//    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecurity) //provide UserService for Spring Security
			.passwordEncoder(passwordEncoder()); //provide password encoder
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/book/login")
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/book/login")
			.defaultSuccessUrl("/book")
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}
	
}
