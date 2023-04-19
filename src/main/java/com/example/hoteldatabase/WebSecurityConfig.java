package com.example.hoteldatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.hoteldatabase.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig  {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
    //        new AntPathRequestMatcher("/api/**"),		//Postmanin testejä varten kommentoitu pois
            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/index"),
            new AntPathRequestMatcher("/**")
    };
	
	private static final AntPathRequestMatcher[] ADMIN_LIST_URLS = {
            new AntPathRequestMatcher("/admin/**"),
            new AntPathRequestMatcher("/api/**")
	};
	
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.httpBasic() // Postmania varten, ennen tätä Postman palauti html login sivun
		.and()
		.authorizeHttpRequests().requestMatchers(ADMIN_LIST_URLS).hasAuthority("ADMIN") //.hasRole("ADMIN")
		.and()
		.authorizeHttpRequests().requestMatchers(WHITE_LIST_URLS).permitAll()
		.and()
		.authorizeHttpRequests().anyRequest().authenticated()
		.and()
		.headers().frameOptions().disable()	//H2-console
		.and()
		.formLogin().defaultSuccessUrl("/index", true)
		.and()
		.logout().permitAll();
		
		http.cors().and().csrf().disable();
		return http.build();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
