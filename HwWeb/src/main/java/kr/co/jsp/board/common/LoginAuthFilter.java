package kr.co.jsp.board.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginAuth",
			//로그인 필터가 적용되는 곳
			urlPatterns = {"/write.board", "/modify.board", "/delete.board", "/myPage.user"},
			servletNames = {"basic"})
public class LoginAuthFilter implements Filter {
    public LoginAuthFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("doFilter 메서드 발동");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null) { //user 세션의 값이 null이면
			System.out.println("회원 권한 없음. 통과 안됨.");
			res.sendRedirect("/HwWeb"); //메인페이지로 보낸다.
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("로그인 권한 필터 객체 생성");
	}

}
