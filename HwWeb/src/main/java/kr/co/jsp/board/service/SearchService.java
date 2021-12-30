package kr.co.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String keyword = request.getParameter("search");
		List<BoardVO> list = BoardDAO.getInstance().searchBoard(keyword);
		
		request.setAttribute("boardList", list);
		
	}

}
