<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!--게시판만 적용되는 css-->            
        <style>
            .table-striped > tbody > tr {
                background-color: rgba(255, 255, 255)
            }
            .row h2 {
                color: aliceblue;
            }
            .pagination-sm {
                margin: 0;
            }
        </style>
    </head>

    <body>
    <!-- header.jsp 따로 만든 것 붙여넣기 -->
    <jsp:include page="../include/header.jsp"/>
        
    <section>
        
        <div class="container">
            <div class="row">
                
                <h2>게시판 목록</h2>
                 <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="background-color: #9DCAFF; text-align: center;">번호</th>
                            <th style="background-color: #9DCAFF; text-align: center;">제목</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성자</th>
                            <th style="background-color: #9DCAFF; text-align: center;">작성일</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                    	<!-- c:forEach는 반복문임. arraylist인 boardList(BoardVO객체들이 들어가있음)의 이름을 var에서 b로 정해줌 -->
                    	<c:forEach var="b" items="${boardList}">
	                        <tr>
	                            <td>${b.bId}</td>
	                            <td>
	                            	<a href="/HwWeb/content.board?bId=${b.bId}&page=${param.page == null ? 1 : param.page}&countPerPage=${param.countPerPage == null ? 10 : param.countPerPage}">${b.title}</a>
		                            <!-- &nbsp;는 공백(띄어쓰기)임. <br>은 여러개 써도 하나만 인식해서 제목과 new 아이콘 사이의
		                            	공백을 만들어 주려고 &nbsp;가 두번임 -->
		                            &nbsp;&nbsp;
		                            <!-- c:if는 if조건문임. newMark(boolean타입이라 true or false의 값을 줌)
		                            	newMark값이 true이면 img 태그 실행될것임-->
		                            <c:if test="${b.newMark}">
	                            		<img alt="newMark" src="/HwWeb/images/new.gif">
	                            	</c:if>
	                            </td>
	                            <td>${b.writer}</td>
	                            <td>
	                            	<!-- 출력되는 형식 : 2019-09-14 08:05-->
	                            	<fmt:formatDate value="${b.date}" pattern="yyyy-MM-dd hh:mm"/>
	                            </td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

			<%-- 페이징 처리하는 구간 --%>
                <div class="text-center">
                    <ul class="pagination pagination-sm">
                    
                    <%-- 이전 버튼 --%>
                    <c:if test="${pc.prev}">
                        <li>
                        	<a href="/HwWeb/list.board?page=${pc.beginPage-1}&countPerPage=${pc.paging.countPerPage}">이전</a>
                        </li>
                    </c:if>
                    
                    <%-- 페이지 버튼 --%>
                    <c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
                        <li>
                        	<a href="/HwWeb/list.board?page=${pageNum}&countPerPage=${pc.paging.countPerPage}" style="${pageNum == pc.paging.page ? 'background-color: gray;' : ''}">${pageNum}</a>
                        </li>
                        
                    </c:forEach>
                        
                     <%-- 다음 버튼 --%>
                     <c:if test="${pc.next}">
                        <li>
                        	<a href="/HwWeb/list.board?page=${pc.endPage+1}&countPerPage=${pc.paging.countPerPage}">다음</a>
                        </li>
                     </c:if>
                    </ul>
                    <button class="btn btn-info pull-right" onclick="location.href='/HwWeb/write.board';">글쓰기</button>
                </div>
                
            </div>
        </div>
        
        <div>
        	<%-- 게시글 검색창 select로 작성자, 내용 검색도 만들어보기 시간되면... --%>
        	<form action="/HwWeb/search.board" style="align:center">
        		<input type="text" name="search" placeholder="제목을 입력하세요." style="border-radius: 5px; width: 300px; height: 25px">
        		<input type="submit" value="검색" style="border-radius: 5px; width: 50px; height: 25px">
        	</form>
        </div>
    </section>
    <!-- footer.jsp 따로 만든 것 붙여넣기 -->    
    <jsp:include page="../include/footer.jsp"/>
        
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/HwWeb/js/bootstrap.js"></script>

    </body>

</html>
