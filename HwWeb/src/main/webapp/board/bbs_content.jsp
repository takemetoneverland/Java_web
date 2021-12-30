<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>
 	<!-- header.jsp 따로 만든 것 붙여넣기 -->
 	<jsp:include page="../include/header.jsp"/>
    
     <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                    <h2>게시판 상세보기</h2>
					<!-- ContentService에서 request 객체에 content라는 이름으로 BoardVO 객체를 담아놔서 content에서 가져옴 -->
                    <form>
                        <div class="form-group">
                            <label>등록일</label>
                            <input type="text" class="form-control" value="${content.date}">
                        </div>
                        <div class="form-group">
                            <label>글번호</label>
                            <input type="text" class="form-control" value="${content.bId}">
                        </div>
                        <div class="form-group">
                            <label>글쓴이</label>
                            <input type="text" class="form-control" value="${content.writer}">
                        </div>
                        <div class="form-group">
                            <label>제목</label>
                            <input type="text" class="form-control" value="${content.title}">
                        </div>
                        <div class="form-group">
                            <label>내용</label>
                            <textarea class="form-control" rows="5">${content.content}</textarea>
                        </div>
                        
                        <div class="form-group">
                            <button type="button" class="btn btn-success" onclick="location.href='/HwWeb/list.board?page=${param.page}&countPerPage=${param.countPerPage}';">목록</button>
                            <button type="button" class="btn btn-info" onclick="location.href='/HwWeb/modify.board?bId=${content.bId}';">수정</button>
                            <button type="button" class="btn btn-delete" onclick="location.href='/HwWeb/delete.board?bId=${content.bId}';">삭제</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>


        </section>
    	<!-- footer.jsp 따로 만든 것 붙여넣기 -->
        <jsp:include page="../include/footer.jsp"/>
    
</body>
</html>