package com.study.app.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.study.app.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenValidator implements HandlerInterceptor{
	
	@Autowired
	private JWTUtil jwt;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		}
		
		// 2. [추가] 회원가입 및 중복체크 예외 처리
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // /members로 시작하는 주소들에 대해
        if (uri.startsWith("/members")||uri.startsWith("/auth")) {
            // POST 방식(회원가입)이거나 GET 방식(중복체크)이면 통과!
            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("GET")) {
                return true;
            }
        }
        if (uri.startsWith("/board")) {
            if (method.equalsIgnoreCase("GET")) {
                return true; // board의 get들만 노토큰으로 통과
            }
            // POST, PUT, DELETE는 401처리
        }
		
		String authHeader = request.getHeader("Authorization");
		if(authHeader != null && authHeader.startsWith("Bearer")) {
			String token = authHeader.substring(7);
			
			try {
				String id = jwt.getSubject(token);
				request.setAttribute("loginId", id);
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return false; 
	}
}
