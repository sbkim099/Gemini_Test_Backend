package com.study.app.domains.members;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int dupCheck(String id) {
		return mybatis.selectOne("Members.dupCheck", id);
	}
	
	public int signUp(MembersDTO dto) {
		return mybatis.insert("Members.signUp",dto);
	}
}
