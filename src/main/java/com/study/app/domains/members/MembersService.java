package com.study.app.domains.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {
	@Autowired
	private MembersDAO memberdao;
	
	public int dupCheck(String id) {
		return memberdao.dupCheck(id);
	}
}
