package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardVO;
import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class LoginService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.userCheck(id, pw);
		
		String htmlCode;

		try {
			PrintWriter out = response.getWriter();
			if(result == -1) {
				htmlCode = "<script>\r\n"
						+ "alert('아이디가 존재하지 않습니다.');\r\n"
						+ "location.href='/HwWeb/loginPage.user';\r\n"
						+ "</script>";
				out.print(htmlCode);
				out.flush();
			} else if(result == 0){
				htmlCode = "<script>\r\n"
						+ "alert('비밀번호가 틀렸습니다.');\r\n"
						+ "location.href='/HwWeb/loginPage.user';\r\n"
						+ "</script>";
				out.print(htmlCode);
				out.flush();
			} else {
				UserVO vo = dao.getUserInfo(id);
				List<BoardVO> writeList = dao.writeList(id);
				request.getSession().setAttribute("user", vo);
				request.setAttribute("writeList", writeList);
				response.sendRedirect("/HwWeb/myPage.user");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
