<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String title = request.getParameter("title");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(title.equals("player1")) { %>
			
			<div align="center">
				<h2>선택한 선수 정보</h2>
				<hr>
				<p>
					당신이 선택한 선수는 <strong>손흥민</strong> 입니다.
				</p>
				<hr>
				<h3>⚽하이라이트 영상⚽<h3>
				<iframe width="800" height="600" src="https://www.youtube.com/embed/K0zBWw3R7mw?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
			
	<% } else if(title.equals("player2")) { %>
	
			<div align="center">
				<h2>선택한 선수 정보</h2>
				<hr>
				<p>
					당신이 선택한 선수는 <strong>이강인</strong> 입니다.
				</p>
				<hr>
				<h3>⚽하이라이트 영상⚽<h3>
				<iframe width="800" height="600" src="https://www.youtube.com/embed/XZwfiF04Orc?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			</div>
	
	<% } %>

</body>
</html>