package kr.co.jsp.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.service.DeleteUserService;
import kr.co.jsp.user.service.IUserService;
import kr.co.jsp.user.service.JoinService;
import kr.co.jsp.user.service.LoginService;
import kr.co.jsp.user.service.MypageService;
import kr.co.jsp.user.service.UpdateUserService;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService sv;
	private RequestDispatcher dp;
	
    public UserController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println(uri);
		
		switch(uri) {
		
		case "joinPage":
			System.out.println("회원 가입 페이지로 이동 요청");
			response.sendRedirect("user/user_join.jsp");
			break;
			
		case "join":
			System.out.println("회원 등록 요청이 들어옴");
			sv = new JoinService();
			sv.execute(request, response);
			break;
			
		case "loginPage":
			System.out.println("로그인 페이지로 이동 요청");
			response.sendRedirect("user/user_login.jsp");
			break;
			
		case "login":
			System.out.println("로그인 요청이 들어옴");
			sv = new LoginService();
			sv.execute(request, response);
			break;
			
		case "myPage":
			System.out.println("마이페이지로 이동 요청");
			sv = new MypageService();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("user/user_mypage.jsp");
			dp.forward(request, response);
			break;
			
		case "modPage":
			System.out.println("회원정보 수정 페이지로 이동 요청");
			response.sendRedirect("user/user_mypageinfo.jsp");
			break;
			
		case "update":
			System.out.println("회원정보 수정 요청이 들어옴");
			sv = new UpdateUserService();
			sv.execute(request, response);
			break;
			
		case "delete":
			System.out.println("회원 탈퇴 요청이 들어옴");
			sv = new DeleteUserService();
			sv.execute(request, response);
			break;
		
		}
	}
	
}
