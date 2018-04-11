package com.tuturial.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configurable
@EnableWebSecurity
@ComponentScan("com.tutorial.security.*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//一個sercice的接口
	@Autowired
	UserDetailsService customUserDetailsService;
	
	//token的接口 管理 新增 刪除 更新 是否存在
	@Autowired
	@Qualifier("token")
    PersistentTokenRepository tokenRepository;
	
	//提供token   也在 implements PersistentTokenRepository註冊
	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices basedToken = new PersistentTokenBasedRememberMeServices("remember-me",customUserDetailsService,tokenRepository);
		System.out.println("basedToken "+basedToken);
		return basedToken; 
	}
	
	//提供授權服務
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() { 
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		System.out.println("AuthenticationProvider ?");
		
		authenticationProvider.setUserDetailsService(customUserDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticationProvider;
	}
	
	
	//加密
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//生證產生器
	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {;
		return new AuthenticationTrustResolverImpl();
	}
	
	//認證機制
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailsService);

	    auth.authenticationProvider(getAuthenticationProvider());
	    
	}

	//連線過濾權限控制
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("in coming security");
		/*
		http.csrf().disable().authorizeRequests().antMatchers("/","/registerPage","/registerAction").permitAll()
		.antMatchers("/contactPage").hasRole("ADMIN").antMatchers("/forget/forgetAccPage").hasRole("ADMIN").and().formLogin().loginPage("/loginPage")
		.loginProcessingUrl("/loginAction").usernameParameter("email")
		.passwordParameter("password").and()
		.rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)  
		.tokenValiditySeconds(86400).and().exceptionHandling().accessDeniedPage("/Access_Denied")
		.and().logout().logoutUrl("/logoutAction").logoutSuccessUrl("/");
		*/
		
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/","/**","/forget/**").permitAll();
		
		http.authorizeRequests().antMatchers("/dog/**").hasRole("USER");
		
		http.formLogin()
		.loginPage("/loginPage").failureUrl("/loginPage?error=true")
		.loginProcessingUrl("/loginAction").usernameParameter("email")
		.passwordParameter("password").defaultSuccessUrl("/dog/DogPage");
		
		http.logout().logoutUrl("/logoutAction").logoutSuccessUrl("/homePage");
		
		http.rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)  
		.tokenValiditySeconds(86400);
		
		http.exceptionHandling().accessDeniedPage("/Access_Denied");
		
	}
	
	   
	 
	
}
