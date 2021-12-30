package kr.co.jsp.user.model;

import java.util.List;

import kr.co.jsp.board.model.BoardVO;

public interface IUserDAO {
	
		//중복 ID 여부를 검증하는 메서드
		boolean confirmId(String id);
		
		//회원 가입을 처리하는 메서드
		void insertUser(UserVO vo);
		
		//로그인 유효성을 검증하는 메서드
		int userCheck(String id, String pw);
		
		//특정 회원의 모든 정보를 가져오는 메서드
		UserVO getUserInfo(String id);
		
		//회원 정보를 수정하는 메서드
		void updateUser(UserVO vo);
		
		//회원 탈퇴를 처리할 메서드
		void deleteUser(String id);
		
		//특정 회원의 게시글을 가져오는 메서드
		List<BoardVO> writeList(String id);

}
