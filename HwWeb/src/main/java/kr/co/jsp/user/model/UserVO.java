package kr.co.jsp.user.model;

public class UserVO {
	
	private String id;
	private String pw;
	private String name;
	private String pNum1; //핸드폰번호 input 3개로 나눠 받아서 3개임
	private String pNum2;
	private String pNum3;
	private String email1; //이메일 아이디 부분
	private String email2; //이메일 @ 뒤에 주소 부분
	private String address1; //기본 주소
	private String address2; //상세 주소
	
	public UserVO() {}

	public UserVO(String id, String pw, String name, String pNum1, String pNum2, String pNum3, String email1,
			String email2, String address1, String address2) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.pNum1 = pNum1;
		this.pNum2 = pNum2;
		this.pNum3 = pNum3;
		this.email1 = email1;
		this.email2 = email2;
		this.address1 = address1;
		this.address2 = address2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpNum1() {
		return pNum1;
	}

	public void setpNum1(String pNum1) {
		this.pNum1 = pNum1;
	}

	public String getpNum2() {
		return pNum2;
	}

	public void setpNum2(String pNum2) {
		this.pNum2 = pNum2;
	}

	public String getpNum3() {
		return pNum3;
	}

	public void setpNum3(String pNum3) {
		this.pNum3 = pNum3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	

}
