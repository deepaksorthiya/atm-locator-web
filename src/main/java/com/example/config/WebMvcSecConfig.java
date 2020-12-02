package com.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.CustomJdbcUserDetailManager;

/**
 * @author Deepak Katariya
 * @date Sep 28, 2020
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebMvcSecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
			http
			.formLogin().defaultSuccessUrl("/home").loginPage("/login").permitAll()
			.and()
			.logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/login")
			.and()
			.authorizeRequests().antMatchers("/js/**", "/css/**","/images/**","/webjars/**","/**/favicon.ico").permitAll()
			.anyRequest().authenticated();
		// @formatter:on

	}

	// Expose the UserDetailsService as a Bean
	@Bean(BeanIds.USER_DETAILS_SERVICE)
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		CustomJdbcUserDetailManager userDetailsServiceBean = new CustomJdbcUserDetailManager();
		userDetailsServiceBean.setDataSource(dataSource);
		userDetailsServiceBean.setRolePrefix("ROLE_");
		userDetailsServiceBean.setAuthenticationManager(authenticationManagerBean());
		return userDetailsServiceBean;
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

}
