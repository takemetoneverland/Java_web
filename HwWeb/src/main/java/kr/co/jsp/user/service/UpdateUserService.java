package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class UpdateUserService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");

		UserVO vo = new UserVO();
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		vo.setpNum1(request.getParameter("pNum1"));
		vo.setpNum2(request.getParameter("pNum2"));
		vo.setpNum3(request.getParameter("pNum3"));
		vo.setEmail1(request.getParameter("email1"));
		vo.setEmail2(request.getParameter("email2"));
		vo.setAddress1(request.getParameter("address1"));
		vo.setAddress2(request.getParameter("address2"));
		
		UserDAO dao = UserDAO.getInstance();
		dao.updateUser(vo);
		request.getSession().setAttribute("user", dao.getUserInfo(vo.getId()));
		
		try {
			PrintWriter out = response.getWriter();
			
			String htmlCode = "<script>\r\n"
							+ "alert('회원 정보가 수정되었습니다.');\r\n"
							+ " location.href='/HwWeb/myPage.user';\r\n"
							+ "</script>";
			
			out.print(htmlCode);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
