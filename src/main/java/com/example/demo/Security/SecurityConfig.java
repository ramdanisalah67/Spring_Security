package com.example.demo.Security;




import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic().and().authorizeRequests().antMatchers("/user/**").hasRole("USER")
			.antMatchers("/admin/**").hasRole("Admin").and().csrf().disable();
			
		}
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.inMemoryAuthentication().withUser("salah").password("{noop}123").authorities("ADMIN").and().
	withUser("ahmed").password("{noop}1101").authorities("USER");
	
	
}
}
