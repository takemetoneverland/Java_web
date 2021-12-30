package kr.co.jsp.board.model;

import java.sql.Timestamp;

public class BoardVO {
	
	private boolean newMark; //new 마크 띄울지 말지의 여부 판단하는 논리 필드
	
	private int bId;
	private String writer;
	private String title;
	private String content;
	private Timestamp date;
	
	public BoardVO() {}

	public BoardVO(int bId, String writer, String title, String content, Timestamp date) {
		super();
		this.bId = bId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public boolean isNewMark() { //boolean 타입 변수의 getter는 is로 시작한다.
		return newMark;
	}

	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}
	
	
	
	

}
