package com.study.app.domains.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardServ;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getPostsList(Long cPage){
		Long start = (cPage - 1) * 10 + 1;
		Long end = cPage * 10;
		
		int count = boardServ.countAllPosts();
		List<BoardDTO> list = boardServ.getStartEnd(start,end);
		
		Map<String, Object> resp = new HashMap<>();
		resp.put("count", count);
		resp.put("list", list);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/{seq}")
	public ResponseEntity<BoardDTO> getPostDetail(@PathVariable Long seq){
		BoardDTO dto = boardServ.getPostDetail(seq);
		return ResponseEntity.ok(dto);
	}
}
