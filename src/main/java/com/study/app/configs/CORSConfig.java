package com.study.app.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // 이 주소로부터 들어오는 것들은 허용하겠다는 의미
		.allowedMethods("*")
		.allowedHeaders("*")
		.allowedOrigins("*");
	}
}
