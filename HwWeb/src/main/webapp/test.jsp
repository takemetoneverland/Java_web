<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 게시판 더미데이터 만들기용 반복문 쓰고나서 주석처리하거나 지우기-->

	<%--
		for(int i=1; i<=300; i++) {
			String writer = "테스트작성자" + i;
			String title = "테스트 글임" + i;
			String content = "테스트 글이다. 제발 한번에 됐으면 좋겠다." + i;
			BoardDAO.getInstance().regist(writer, title, content);
		}
	--%>

</body>
</html>