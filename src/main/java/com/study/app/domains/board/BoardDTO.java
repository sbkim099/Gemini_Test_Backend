package com.study.app.domains.board;

public class BoardDTO {
	private Long seq;
    private String writer;
    private String title;
    private String contents;
    private Long view_count;
    private String write_date;
    
    public BoardDTO() {}
	public BoardDTO(Long seq, String writer, String title, String contents, Long view_count, String write_date) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.view_count = view_count;
		this.write_date = write_date;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Long getView_count() {
		return view_count;
	}
	public void setView_count(Long view_count) {
		this.view_count = view_count;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
}
