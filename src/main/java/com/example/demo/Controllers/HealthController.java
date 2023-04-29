package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.HealthCheck;

@RestController
public class HealthController {
	
	@GetMapping("/health")
	public HealthCheck health() {
		return new HealthCheck("Success");
	}
}