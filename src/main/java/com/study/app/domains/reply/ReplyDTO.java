package com.study.app.domains.reply;

public class ReplyDTO {
	
	private Long seq;
	private String writer;
	private String contents;
	private String write_date;
	private Long parent_seq;
	
	public ReplyDTO() {}
	
	public ReplyDTO(Long seq, String writer, String contents, String write_date, Long parent_seq) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.contents = contents;
		this.write_date = write_date;
		this.parent_seq = parent_seq;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public Long getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(Long parent_seq) {
		this.parent_seq = parent_seq;
	}
}