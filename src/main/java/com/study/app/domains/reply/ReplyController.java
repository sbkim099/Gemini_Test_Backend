package com.study.app.domains.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyServ;	
	
//	@GetMapping
//	public ResponseEntity<List<ReplyDTO>> selectByParentSeq(@PathVariable Long parent_seq) {
//		List<ReplyDTO> list = replyServ.selectByParentSeq(parent_seq);
//		return ResponseEntity.ok(list);
//	}
	
}
