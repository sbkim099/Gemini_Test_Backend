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
		System.out.println("login:"+isUser);
		Map<String,String> result = new HashMap<>();
		if(isUser>0) {//true일때
			String token = jwt.createToken(dto.getId());
			result.put("token", token);
			result.put("id",dto.getId());
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	/*
	 @GetMapping("membersOnly")
	public ResponseEntity <String> memebersOnly(HttpServletRequest request){
		String authHeader = request.getHeader("Authorization");//로그인한 고객 입장
		String token = authHeader.substring(7);//찐 토큰만 꺼내옴
		try {
			jwt.validation(token);//유효한 토큰(로그인정보)인지 확인
			return ResponseEntity.ok("Good"); // 맞으면 good 보냄
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 401 주기
	}   
	 */
	@GetMapping
	public ResponseEntity<Void> memberCheck(@RequestAttribute("loginId") String id){//컨트롤러에서 꺼내기 파라미터에 @RequestAttribute만 적어주면 스프링이 알아서 값을 채워
		return ResponseEntity.ok().build();
	}
}
