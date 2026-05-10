package com.study.app.domains.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.app.utils.JWTUtil;

@RestController
@RequestMapping("/members")
public class MembersController {

	@Autowired
	private JWTUtil jwt;
	
	@Autowired
	private MembersService membersServ;
	
	@GetMapping("/{id}")
	public ResponseEntity<Integer> dupCheck(@PathVariable String id){
		int member = membersServ.dupCheck(id);
		return ResponseEntity.ok(member);
	}
	
	@PostMapping
	public ResponseEntity<Void> signUp(@RequestBody MembersDTO dto){//@RequestBody : JSON 데이터를 자바 객체로 변환할 때 필수
		membersServ.signUp(dto);
		return ResponseEntity.ok().build();
	}
}
