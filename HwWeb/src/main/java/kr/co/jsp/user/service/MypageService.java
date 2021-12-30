package kr.co.jsp.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardVO;
import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class MypageService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		UserVO vo = (UserVO) request.getSession().getAttribute("user");
		String id = vo.getId();
		
		List<BoardVO> list = UserDAO.getInstance().writeList(id);
		request.setAttribute("writeList", list);
	}

}
