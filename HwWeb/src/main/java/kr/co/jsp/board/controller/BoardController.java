package kr.co.jsp.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.service.ContentService;
import kr.co.jsp.board.service.DeleteService;
import kr.co.jsp.board.service.GetListService;
import kr.co.jsp.board.service.IBoardService;
import kr.co.jsp.board.service.ModifyService;
import kr.co.jsp.board.service.RegistService;
import kr.co.jsp.board.service.SearchService;
import kr.co.jsp.board.service.UpdateService;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dp;
	private IBoardService sv;

	public BoardController() {
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
		String conPath = request.getContextPath();
		uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));

		System.out.println(uri);

		switch(uri) {

		case "write":
			System.out.println("글쓰기 페이지로 이동 요청");
			response.sendRedirect("board/bbs_write.jsp");
			break;

		case "regist":
			System.out.println("글 등록 요청이 들어옴");
			sv = new RegistService();
			sv.execute(request, response);
			response.sendRedirect("/HwWeb/list.board");
			break;
			
		case "list":
			System.out.println("글 목록 요청이 들어옴");
			sv = new GetListService();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("board/bbs.jsp");
			dp.forward(request, response);
			break;
			
		case "content":
			System.out.println("글 상세보기 요청이 들어옴");
			sv = new ContentService();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("board/bbs_content.jsp");
			dp.forward(request, response);
			break;
			
		case "modify":
			System.out.println("글 수정 페이지로 이동 요청");
			sv = new ModifyService();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("board/bbs_modify.jsp");
			dp.forward(request, response);
			break;
			
		case "update":
			System.out.println("글 수정 요청이 들어옴");
			sv = new UpdateService();
			sv.execute(request, response);
			response.sendRedirect("/HwWeb/content.board?bId=" + request.getParameter("bId"));
			break;
			
		case "delete":
			System.out.println("글 삭제 요청이 들어옴");
			sv = new DeleteService();
			sv.execute(request, response);
			response.sendRedirect("/HwWeb/list.board");
			break;
			
		case "search":
			System.out.println("글 검색 요청이 들어옴");
			sv = new SearchService();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("board/bbs.jsp");
			dp.forward(request, response);
			break;
			
		}

	}

}
