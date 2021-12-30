<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style type="text/css">
    </style>
</head>
<body>
    <!-- header.jsp 따로 만든 것 붙여넣기 -->
    <jsp:include page="../include/header.jsp"/>
    
<section>
        <div class="container">
            <div class="row join-wrap">
                
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER                   
                    </div>
                    <div>
                        <p>${user.id}님 회원정보</p>
                    </div>
                    <div>
                        <button type="button" class="btn btn-primary" onclick="location.href='/HwWeb/modPage.user';">회원정보변경</button>
                        <button type="button" class="btn btn-primary" id="delCheck">회원 탈퇴</button>
                        
                    </div>
                    <div class="delete-hidden">
                        <form action="/HwWeb/delete.user">
                        <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="pw">
                        <button type="submit" class="btn btn-primary" >확인</button>
                        </form>
                    </div>
                    
                    <br>
                    <div>
                        <p>${user.id}님의 작성 게시물</p>
                        <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="text-align: center;">번호</th>
                            <th style="text-align: center;">제목</th>
                            <th style="text-align: center;">작성자</th>
                            <th style="text-align: center;">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                    	
                    	<c:forEach var="b" items="${writeList}">	
	                        <tr>
	                            <td>${b.bId}</td>
	                            <td><a href="/HwWeb/content.board?bId=${b.bId}&page=${param.page == null ? 1: param.page}&countPerPage=${param.countPerPage == null ? 10 : param.countPerPage}">${b.title}</a></td>
	                            <td>${b.writer}</td>
	                            <td>
	                            	<fmt:formatDate value="${b.date}" pattern="yyyy-MM-dd hh:mm"/>
	                            </td>
	                        </tr>
                        </c:forEach>

                    </tbody>
                </table>
                    </div>
                    
                    
                </div>


            </div>

        </div>

    </section>
    <!-- footer.jsp 따로 만든 것 붙여넣기 -->
	<jsp:include page="../include/footer.jsp"/>    
    
    <script>
        //탈퇴버튼 디스플레이 처리
        var delCheck = document.getElementById("delCheck");
        delCheck.onclick = function() {
            var del  = document.querySelector(".delete-hidden");
            if(del.style.display == "none" || del.style.display == "") {
                del.style.display = "inline";
            } else {
                del.style.display = "none";
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/HwWeb/js/bootstrap.js"></script>
</body>
</html>