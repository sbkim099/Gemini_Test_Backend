package com.study.app.domains.members;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.app.commons.EncrptionUtils;

@Repository
public class MembersDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int dupCheck(String id) {
		return mybatis.selectOne("Members.dupCheck", id);
	}
	
	public int signUp(MembersDTO dto) {
		String getShaPw = EncrptionUtils.getSha512(dto.getPw());
		dto.setPw(getShaPw);
		return mybatis.insert("Members.signUp",dto);
	}
	
	public int isLogin(MembersDTO dto) {
		return mybatis.selectOne("Members.isLogin",dto);
	}
}
