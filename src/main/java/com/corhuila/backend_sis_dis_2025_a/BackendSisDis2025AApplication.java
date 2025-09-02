package com.corhuila.backend_sis_dis_2025_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class BackendSisDis2025AApplication implements WebMvcConfigurer {
	public static void main(String[] args) { SpringApplication.run(BackendSisDis2025AApplication.class, args); }

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("*");
	}
}
