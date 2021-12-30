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
                    <h2>게시판 수정<small>(디자인이궁금하세요?)</small></h2>

                    <form action="/HwWeb/update.board">
                    	<!-- ModifyService에서 request객체에 article이라는 이름으로 BoardVO 객체를 담아놨어서 article에서 값을 가져옴. -->
                        <div class="form-group">
                            <label>글번호</label>
                            <input type="text" class="form-control" value="${article.bId}" name="bId" readonly>
                        </div>
                        <div class="form-group">
                            <label>글쓴이</label>
                            <input type="text" class="form-control" value="${article.writer}" readonly>
                        </div>
                        <div class="form-group">
                            <label>제목</label>
                            <input type="text" class="form-control" value="${article.title}" name="bTitle">
                        </div>
                        <div class="form-group">
                            <label>내용</label>
                            <textarea class="form-control" rows="5" name="bContent">${article.content}</textarea>
                        </div>

                        <!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
                        <div class="form-group">
                            <button type="button" class="btn btn-success" onclick="location.href='/HwWeb/list.board';">목록</button>
                            <!-- form 태그 안에 있는 button인데, type="submit"이면 form 데이터를 전송하게 됨 -->
                            <button type="submit" class="btn btn-info">수정</button>
                            <button type="button" class="btn btn-default" onclick="location.href='/HwWeb/delete.board?bId=${article.bId}';">삭제</button>
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