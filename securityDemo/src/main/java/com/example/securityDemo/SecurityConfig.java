package com.example.securityDemo;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	DataSource dataSource;
	
	@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/h2-console/**").permitAll()
        		.anyRequest().authenticated());
           // http.formLogin(withDefaults());
            http.httpBasic(withDefaults());
            http.headers(headers -> headers
                    .frameOptions(frameOptions -> frameOptions
                            .sameOrigin()
                    )
            );
            http.csrf(csrf -> csrf.disable());
            return http.build();
    }
	
	
	
	 @Bean
	    public UserDetailsService userDetailsService( ) {
		 
            UserDetails user1= User.withUsername("user")
            		.password("{noop}pass")
            		.roles("USER")
            		.build();
            UserDetails admin= User.withUsername("admin")
            		.password("{noop}pass1")
            		.roles("ADMIN")
            		.build();
            
            JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
            userDetailsManager.createUser(user1);
            userDetailsManager.createUser(admin);
            
 	        return userDetailsManager;
	    }
}
