package com.example.securityDemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@GetMapping("/home")
	public String getMethodName() {
		return "hello world";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user")
	public String UsergetMethodName() {
		return "hello user world";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String AdmingetMethodName() {
		return "hello admin world";
	}
	
}
