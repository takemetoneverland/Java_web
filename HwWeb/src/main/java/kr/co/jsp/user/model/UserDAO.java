package kr.co.jsp.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.jsp.board.model.BoardVO;

public class UserDAO implements IUserDAO {
	
	private DataSource ds;
	
	public UserDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	/////////////////////////////////////////////////////////////////////////

	//중복 ID 여부를 검증하는 메서드
	@Override
	public boolean confirmId(String id) {
		boolean flag = false;
		String sql = "SELECT * FROM hw_user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	//회원 가입을 처리하는 메서드
	@Override
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO hw_user VALUES(?,?,?,?,?,?)";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			//전화번호(3개로 따로 입력 받은 것) "-" 붙여서 하나로 DB에 넣음
			pstmt.setString(4, vo.getpNum1() + "-" + vo.getpNum2() + "-" + vo.getpNum3());
			//이메일주소 (ID부분, 주소부분 따로 입력 받았던 것) "@" 붙여서 하나로 DB에 넣음
			pstmt.setString(5, vo.getEmail1() + "@" + vo.getEmail2());
			//주소(기본주소와 상세주소 따로 입력 받았던 것) 합쳐서 하나로 DB에 넣음
			pstmt.setString(6, vo.getAddress1() + "&" + vo.getAddress2());
			pstmt.executeUpdate();
		} catch (Exception e) {
		}
		
	}

	//로그인 유효성을 검증하는 메서드
	@Override
	public int userCheck(String id, String pw) {
		int check = 0;
		String sql = "SELECT * FROM hw_user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbPw = rs.getString("user_pw");
				if(dbPw.equals(pw)) check = 1;
				else check = 0;
			} else {
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

	//특정 회원의 모든 정보를 가져오는 메서드
	@Override
	public UserVO getUserInfo(String id) {
		UserVO user = null;
		String sql = "SELECT * FROM hw_user WHERE user_id = ?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("user_id"));
				user.setPw(rs.getString("user_pw"));
				user.setName(rs.getString("user_name"));
				/*
				DB에는 email컬럼 하나에 email주소가 저장되어있는데,
				가져올 때는 @를 기준으로 잘라서
				아이디 부분과 주소 부분을 따로 가져온다.
				UserVO 객체에 email1, email2 변수가 2개여서임.
				전화번호랑 주소도 같은 이유.
				*/
				String[] email = rs.getString("user_email").split("@");
				user.setEmail1(email[0]);
				user.setEmail2(email[1]);
				String[] phone = rs.getString("user_phone").split("-");
				user.setpNum1(phone[0]);
				user.setpNum2(phone[1]);
				user.setpNum3(phone[2]);
				String[] addr = rs.getString("user_addr").split("&");
				user.setAddress1(addr[0]);
				user.setAddress2(addr[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//회원 정보를 수정하는 메서드
	@Override
	public void updateUser(UserVO vo) {
		String sql = "UPDATE hw_user SET user_pw=?, "
				+ "user_name=?, user_phone=?, user_email=?, "
				+ "user_addr=? WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getpNum1() + "-" + vo.getpNum2() + "-" + vo.getpNum3());
			pstmt.setString(4, vo.getEmail1() + "@" + vo.getEmail2());
			pstmt.setString(5, vo.getAddress1() + "&" + vo.getAddress2());
			pstmt.setString(6, vo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//회원 탈퇴를 처리할 메서드
	@Override
	public void deleteUser(String id) {
		String sql = "DELETE FROM hw_user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//특정 회원의 게시글을 가져오는 메서드 (마이페이지)
	@Override
	public List<BoardVO> writeList(String id) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "SELECT * FROM hw_board b JOIN hw_user u ON b.writer = u.user_id WHERE u.user_id = ?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date")
						);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
