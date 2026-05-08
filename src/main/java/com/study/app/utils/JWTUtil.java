package com.study.app.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

// 어느 계층에도 속하지 않는다면 Component를 붙여줌
@Component
public class JWTUtil {
	
	@Value("${jwt.expiration}")
	private Long expiration; // 유효기간
	
	private Algorithm alg; // 알고리즘 변수
	private JWTVerifier jwt; // 인증자
	
	// 생성자를 이용해 초기값 세팅
	public JWTUtil(@Value("${jwt.secret}")String secret) {
		this.alg = Algorithm.HMAC256(secret);
		this.jwt = JWT.require(alg).build();
	}
	
	// 토큰 생성 함수
	public String createToken(String id) {
		// .withClaim -> 권한 정보 필요 시 사용
		return JWT.create()
				.withSubject(id)
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + expiration))
				.sign(alg);
	}
	
	// 토큰 유효성 검사하는 함수
	public DecodedJWT validation(String token) {
		return jwt.verify(token);
	}
	
	// subject 편하게 꺼내는 함수
	public String getSubject(String token) {
		return validation(token).getSubject();
	}
}