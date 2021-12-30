package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;
import kr.co.jsp.user.service.IUserService;

public class DeleteUserService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html; charset=UTF-8");	
		String id = ((UserVO) request.getSession().getAttribute("user")).getId();
		String pw = request.getParameter("check_pw");

		UserDAO dao = UserDAO.getInstance();

		String htmlCode;
		try {
			if(dao.userCheck(id, pw) == 0) {
				PrintWriter out = response.getWriter();

				htmlCode = "<script>\r\n"
						+ "alert('비밀번호가 틀렸습니다.');\r\n"
						+ "location.href='/MyWeb/myPage.user';\r\n"
						+ "</script>";

				out.print(htmlCode);
				out.flush();
			} else {
				dao.deleteUser(id);
				request.getSession().invalidate();

				PrintWriter out = response.getWriter();

				htmlCode = "<script>\r\n"
						+ "alert('회원 탈퇴가 정상적으로 처리되었습니다.');\r\n"
						+ "location.href='/MyWeb';\r\n"
						+ "</script>";

				out.print(htmlCode);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
