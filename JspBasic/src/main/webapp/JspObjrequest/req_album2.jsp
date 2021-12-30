<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table{
		width: 1400px;		
	}
	tr {
		text-align: center;
	}
</style>

</head>
<body>
	
	<div align="center">
			<table border="1">
				<tr>
					<th>사진</th>
					<th>이름</th>
					<th>소속</th>
					<th>생일</th>		
				</tr>
				<tr>
					<td>
						<img alt="son" src="son.jpg" width="200">
					</td>
					<td>
						<a href="req_album_result.jsp?title=player1">손흥민</a>
					</td>
					<td>토트넘 홋스퍼 FC</td>
					<td>1992.7.8</td>		
				</tr>
				<tr>
					<td>
						<img alt="lee" src="lee.jpg" width="200">
					</td>
					<td>
						<a href="req_album_result.jsp?title=player2">이강인</a>
					</td>
					<td>레알 마요르카</td>
					<td>2001.2.19</td>				
				</tr>
			</table>
	</div>
	
</body>
</html>