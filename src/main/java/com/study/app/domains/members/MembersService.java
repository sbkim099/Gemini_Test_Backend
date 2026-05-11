package com.study.app.domains.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {
	@Autowired
	private MembersDAO membersDAO;
	
	public int dupCheck(String id) {
		return membersDAO.dupCheck(id);
	}
	
	public int signUp(MembersDTO dto) {
		return membersDAO.signUp(dto);
	}
	
	public int delMember(String id) {
		return membersDAO.delMember(id);
	}
	
	public MembersDTO selectOneMember(String id) {
		return membersDAO.selectOneMember(id);
	}
	
	public int upMember(String id, MembersDTO dto) {
		return membersDAO.upMember(id, dto);
	}
}
