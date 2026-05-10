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
	
	public int insert(BoardDTO dto) {
		return mybatis.insert("Board.insert", dto);
	}
	
	public int updatePost(Long seq, BoardDTO dto) {
		Map<String, Object> param = new HashMap<>();
		param.put("seq", seq);
		param.put("title", dto.getTitle());
		param.put("contents", dto.getContents());
		return mybatis.update("Board.updatePost", param);
	}
	
	public int deletePost(Long seq) {
		return mybatis.delete("Board.deletePost", seq);
	}
}
