package kr.co.jsp.board.model;

import java.sql.Timestamp;

/*
CREATE TABLE my_board (
    board_id NUMBER PRIMARY KEY,
    writer VARCHAR2(30) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(2000),
    reg_date DATE DEFAULT sysdate,
    hit NUMBER DEFAULT 0
);

CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
 */


public class BoardVO {
	
	//new 마크를 띄울 지 말지의 여부를 판단하는 논리 필드 추가
	private boolean newMark;

	private int bId;
	private String writer;
	private String title;
	private String content;
	private Timestamp date;
	private int hit;
	
	
	
	//boolean 타입 변수의 getter는 is로 시작하는 것이 관례이다.
	public boolean isNewMark() {
		return newMark;
	} 
	
	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}
	
	public BoardVO() {}

	public BoardVO(int bId, String writer, String title, String content, Timestamp date, int hit) {
		super();
		this.bId = bId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.date = date;
		this.hit = hit;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	

}