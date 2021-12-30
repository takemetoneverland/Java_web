<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
   		response.setCharacterEncoding("utf-8");
    
		String id = ((UserVO) session.getAttribute("user")).getId();
    	String pw = request.getParameter("check_pw");
    	
		UserDAO dao = UserDAO.getInstance();
		
		if(dao.userCheck(id, pw) == 0) { %>
			<script>
				alert("비밀번호가 틀렸습니다.");
				history.back();
			</script>
		<% } else { 
			dao.deleteUser(id);
			session.invalidate(); %>
			<script>
				alert("회원 탈퇴가 정상적으로 처리되었습니다.");
				location.href="/MyWeb";
			</script>
		<% } %>
    	
    
    
    
    