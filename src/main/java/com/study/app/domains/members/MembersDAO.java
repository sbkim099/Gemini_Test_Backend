package com.study.app.domains.members;

import java.util.HashMap;
import java.util.Map;

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
	
	public int delMember(String id) {
		return mybatis.delete("Members.delMember",id);
	}
	
	public MembersDTO selectOneMember(String id) {
		return mybatis.selectOne("Members.selectOneMember",id);
	}
	
	public int upMember(String id, MembersDTO dto) {
		Map<String,Object> upData = new HashMap<>();
		upData.put("id",id);
		upData.put("dto", dto);
		return mybatis.update("Members.upMember",upData);
	}
}
