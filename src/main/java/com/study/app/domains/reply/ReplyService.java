package com.study.app.domains.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDao;
	
	public List<ReplyDTO> selectByParentSeq(Long parent_seq) {
		return replyDao.selectByParentSeq(parent_seq);
	}
	
	public void addReply(ReplyDTO dto) {
		replyDao.addReply(dto);
	}
	
	public void updateReply(ReplyDTO dto) {
		replyDao.updateReply(dto);
	}
	
	public void deleteReply(Long seq) {
		replyDao.deleteReply(seq);
	}
}