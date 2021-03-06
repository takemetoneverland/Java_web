<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% for(int i=1; i<=5; i++) { %>
		<h2>이클립스 내부에서 jsp 문서 작성하기!</h2>
		<p>
			안녕하세요! 오늘은 12월 7일 화요일입니다. <br>
			지금은 jsp 문서를 작성중이에요!
		</p>
	<% } %>

	<hr>
	
	<h2>구구단 4단</h2>
	<%
		for(int hang=1; hang<=9; hang++) {
			//out.pring()는 브라우저에 바로 출력을 실행하는 메서드이다.
			//브라우저에 출력할 텍스트나 html 태그는 ""에 감싸서 전달하고
			//자바 변수나 메서드의 리턴값은 바로 작성하면 된다.
			out.print("4 x " + hang + " = " + (4*hang) + "<br>");			
		}
	%>

	<!-- 
		반복문, 조건문을 사용하여 구구단을 홀수단 (3, 5, 7, 9)만
		브라우저에 출력하기
		(구구단 단 범위: 2 ~ 9단)
	 -->
	
	<hr>
	
	<%
		for(int dan=2; dan<=9; dan++){
			if(dan % 2 != 0) {
				out.print("<h2>구구단 " + dan + "단</h2>");
				for(int hang=1; hang<=9; hang++) {
					out.print(dan + " x " + hang + " = " + (dan*hang) + "<br>");					
				}				
			}
		}
	%>	 

</body>
</html>