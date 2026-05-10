package com.study.app.domains.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.app.domains.members.MembersDAO;
import com.study.app.domains.members.MembersDTO;

@Service
public class AuthService {
	@Autowired
	private MembersDAO membersDAO;
	
	public int isLogin(MembersDTO dto) {
		return membersDAO.isLogin(dto);
	}

}
