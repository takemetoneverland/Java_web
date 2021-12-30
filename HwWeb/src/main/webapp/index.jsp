<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--메인만 적용되는 css영역-->   
        <style>
            body {
                background-image: url(images/main.jpg) !important;
                background-repeat: no-repeat;
                background-size: cover
            }
        </style>
    </head>

    <body>
    <!-- header.jsp 따로 만든 것 붙여넣기 -->
    <jsp:include page="include/header.jsp"/>
        
    <section>
    
    <div class="container" id="mainCon">
        <div class="jumbotron" id="jbDiv">
            <div class="container" id="introArea">
                <h1>MVC2 패턴 게시판 사이트</h1>
                <p>임영선, 정다윤, 정다은</p>
                <p>고생하셨습니다😍<p>
            </div>

        </div>
        
        <div class="col-md-6 col-xs-12" style="padding: 0px 0px;">
            <h2 style="color:black">최근 게시물</h2>
            <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                <thead>
                    <tr>
                        <th style="background-color: #9DCAFF; text-align: center;">번호</th>
                        <th style="background-color: #9DCAFF; text-align: center;">제목</th>
                        <th style="background-color: #9DCAFF; text-align: center;">작성자</th>
                        <th style="background-color: #9DCAFF; text-align: center;">작성일</th>
                    </tr>
                </thead>
                
                <%-- 게시판 최근 게시물
                	(그냥 화면에 보여주기용(?) 용도로 써서 controller 안만들고 scriptlet 안에 썼어요.)
                	(원본 템플릿은 공지사항이었는데 딱히 공지라고 할 만한 글이 없어서
                	게시판에서 최근 게시물 5개 뜨게 작성해보았어요. 마음껏 바꿔보세요.) 
                --%>
                <tbody>
                <%List<BoardVO> mainList = BoardDAO.getInstance().mainBoard();%>
                <%for(BoardVO article : mainList) { %>
                    <tr>
                        <td><%=article.getbId() %></td>
                        <td>
                        	<a href="/HwWeb/content.board?bId=<%=article.getbId()%>"><%=article.getTitle() %></a>
                        	<%long now = System.currentTimeMillis(); 
                        		long regTime = article.getDate().getTime();
                        		if(now - regTime < 60 * 60 * 24 * 1000) { %>
									<img alt="newMark" src="/HwWeb/images/new.gif">
                        	<% } %>
                        </td>
                        <td><%=article.getWriter()%></td>
                        <td><%=article.getDate() %></td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        
    </div>
    </section>
    
    <%--
    board 테이블 생성문
    CREATE TABLE hw_board (
    board_id NUMBER PRIMARY KEY,
    writer VARCHAR2(30) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(2000),
    reg_date DATE DEFAULT sysdate    
	);
	
	board 시퀀스 생성문
	CREATE SEQUENCE hw_board_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
    
    user 테이블 생성문
    CREATE TABLE hw_user(
    user_id VARCHAR2(30) PRIMARY KEY,
    user_pw VARCHAR2(30) NOT NULL,
    user_name VARCHAR2(20) NOT NULL,
    user_phone VARCHAR2(20),
    user_email VARCHAR2(100),
    user_addr VARCHAR2(100),
	);
    --%>
    
    <!-- footer.jsp 따로 만든 것 붙여넣기 -->
    <jsp:include page="include/footer.jsp"/>
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    
    </body>
    
    

</html>
