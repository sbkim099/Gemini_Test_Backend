package com.study.app.domains.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public int countAllPosts() {
		 return dao.countAllPosts();
	}
	
	public List<BoardDTO> getStartEnd(Long start, Long end){
		return dao.getStartEnd(start, end);
	}
}
