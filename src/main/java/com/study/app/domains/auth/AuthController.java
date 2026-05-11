package com.study.app.domains.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.app.commons.EncrptionUtils;
import com.study.app.domains.members.MembersDTO;
import com.study.app.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JWTUtil jwt;
	
	@Autowired
	private AuthService authServ;
	
	@PostMapping("login")
	public ResponseEntity<Map<String,String>> isLogin(@RequestBody MembersDTO dto){
		//로그인할때도 getsha로!
		String getShaPw = EncrptionUtils.getSha512(dto.getPw());
		dto.setPw(getShaPw);
		int isUser = authServ.isLogin(dto);
				
		//있는 인간인지 쳌
		Map<String,String> result = new HashMap<>();
		if(isUser>0) {//true일때
			String token = jwt.createToken(dto.getId());
			result.put("token", token);
			result.put("id",dto.getId());
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}

}
