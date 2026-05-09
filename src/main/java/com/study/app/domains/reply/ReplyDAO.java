package com.study.app.domains.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate batis;	
	
	public List<ReplyDTO> selectByParentSeq(Long parent_seq) {
		return batis.selectList("Reply.selectByParentSeq", parent_seq);
	}
	
	public void addReply(ReplyDTO dto) {
		batis.insert("Reply.insert",dto);
	}
}
