<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/HwWeb/css/bootstrap.css">
        <link rel="stylesheet" href="/HwWeb/css/custom.css">
        <title>게시판 페이지 만들기</title>
</head>
<body>
	<nav class="navbar navbar-default" id="nav">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/HwWeb">MIN and PARK</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/HwWeb" style="margin-right: 10px;">메인</a></li>
                <li><a href="/HwWeb/list.board">게시판</a></li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
                    
                    <%-- 화면 상단 우측 메뉴 (드롭다운) --%>
                    <ul class="dropdown-menu">
                    <%-- 로그인 하지 않았을 때와 로그인 했을 때 메뉴 다르게 보이게 하려고
                    	c:choose 조건문 사용함. --%>
                    <c:choose>
                    	<%-- 로그인 안했을 때 보이는 메뉴 --%>
                    	<c:when test="${user == null}">
                        	<li><a href="/HwWeb/loginPage.user">로그인</a></li>
                        	<li><a href="/HwWeb/joinPage.user">회원가입</a></li>
                        </c:when>
                        <%-- 로그인 했을 때 보이는 메뉴 --%>
                        <c:otherwise>
                        	<li><a href="/HwWeb/myPage.user">마이페이지</a></li>
                        	<li><a href="/HwWeb/logout">로그아웃</a></li>
                        </c:otherwise>
                    </c:choose>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</body>
</html>