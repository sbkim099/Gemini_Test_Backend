package com.study.app.domains.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("idExist/{id}")
	public ResponseEntity<Integer> dupCheck(@PathVariable String id){
		int member = membersServ.dupCheck(id);
		return ResponseEntity.ok(member);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MembersDTO> selectOneMember(@PathVariable String id){
		MembersDTO profile = membersServ.selectOneMember(id);
		return ResponseEntity.ok(profile);
	}
	@PostMapping
	public ResponseEntity<Void> signUp(@RequestBody MembersDTO dto){//@RequestBody : JSON 데이터를 자바 객체로 변환할 때 필수
		membersServ.signUp(dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delMember(@PathVariable String id){
		membersServ.delMember(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> upMember(@PathVariable String id, @RequestBody MembersDTO dto){
		membersServ.upMember(id, dto);
		return ResponseEntity.ok().build();
	}
	
}
