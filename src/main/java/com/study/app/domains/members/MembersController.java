package com.study.app.domains.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.app.utils.JWTUtil;

@RestController
@RequestMapping("/Members")
public class MembersController {

	@Autowired
	private JWTUtil jwt;
	
	@Autowired
	private MembersService membersServ;
	
	@GetMapping("/{id}")
	public ResponseEntity<Integer> dupCheck(@PathVariable String id){
		int member = membersServ.dupCheck(id);
		System.out.println("dupCheck"+member);
		return ResponseEntity.ok(member);
	}
}
