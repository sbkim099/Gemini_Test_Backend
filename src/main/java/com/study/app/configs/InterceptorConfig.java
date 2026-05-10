package com.study.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.app.interceptors.TokenValidator;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private TokenValidator testInterceptor;
	//컨트롤러에 도달하기 전 문 앞에서 검사 (이미 여기서 통과/거부 결정됨)
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/auth/login",
				"/members/**",
				"/board/**");//board는 전체 토큰 엉ㅄ어도 보내줌
	}
}
