package com.study.app.domains.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyServ;	
	
	@GetMapping("/{parent_seq}")
	public ResponseEntity<List<ReplyDTO>> selectByParentSeq(@PathVariable Long parent_seq) {
		List<ReplyDTO> list = replyServ.selectByParentSeq(parent_seq);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> addReply(@RequestBody ReplyDTO dto) {
		replyServ.addReply(dto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> updateReply(@RequestBody ReplyDTO dto) {
		replyServ.updateReply(dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{seq}")
	public ResponseEntity<Void> deleteReply(@PathVariable Long seq) {
		replyServ.deleteReply(seq);
		return ResponseEntity.ok().build();
	}
}