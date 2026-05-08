package com.study.app.domains.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int countAllPosts() {
		return mybatis.selectOne("Board.countAllPosts");
	}
	
	public List<BoardDTO> getStartEnd(Long start, Long end){
		Map<String, Long> param = new HashMap<>();
		param.put("start", start);
		param.put("end", end);
		return mybatis.selectList("Board.getStartEnd", param);
	}
	
	public BoardDTO getPostDetail(Long seq){
		return mybatis.selectOne("Board.getPostDetail", seq);
	}
}
