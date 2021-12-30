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
            <div class="row join-wrap">
                <!--join-form을 적용한다 float해제 margin:0 auto-->
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    <p>*표시는 필수 입력 표시입니다</p>
                    
                    <form action="/HwWeb/update.user">
                    <table class="table">
                        <tbody class="m-control">
                            <tr>
                                <td class="m-title">*ID</td>
                                <%-- value에는 input창에 뜨는 기본값을 미리 적어둠 --%>
                                <td><input class="form-control input-sm" name="id" value="${user.id}" readonly></td>
                            </tr>
                            <tr>
                                <td class="m-title">*이름</td>
                                <%-- onfocus="this.value=''"는 클릭하면 value로 지정되어있던 기본값이 사라지면서 입력할 수 있게 된다. --%>
                                <td><input class="form-control input-sm" name="name" value="${user.name}" onfocus="this.value=''"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호</td>
                                <td><input class="form-control input-sm" type="password" name="pw" value="${user.pw}" onfocus="this.value=''"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호확인</td>
                                <td><input class="form-control input-sm" type="password"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*E-mail</td>
                                <td>
                                    <input class="form-control input-sm" name="email1" value="${user.email1}" onfocus="this.value=''">@
                                    <select class="form-control input-sm sel" name="email2">
                                    	<%-- select 태그는 value가 아닌 selected로 기본값을 정할 수 있음. --%>
                                        <option ${user.email2 == 'naver.com' ? selected : ''}>naver.com</option>
                                        <option ${user.email2 == 'gmail.com' ? selected : ''}>gmail.com</option>
                                        <option ${user.email2 == 'daum.net' ? selected : ''}>daum.net</option>
                                    </select>
                                    <button class="btn btn-info">중복확인</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*휴대폰</td>
                                <td>
                                    <input class="form-control input-sm sel" name="pNum1" value="${user.pNum1}" onfocus="this.value=''"> -
                                    <input class="form-control input-sm sel" name="pNum2" value="${user.pNum2}" onfocus="this.value=''"> -
                                    <input class="form-control input-sm sel" name="pNum3" value="${user.pNum3}" onfocus="this.value=''">
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*주소</td>
                                <td><input class="form-control input-sm add" name="address1" value="${user.address1}" onfocus="this.value=''"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*상세주소</td>
                                <td><input class="form-control input-sm add" name="address2" value="${user.address2}" onfocus="this.value=''"></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <div class="titlefoot">
                        <button class="btn" type="submit">수정</button>
                        <button class="btn" onclick="location.href='/HwWeb/myPage.user';">목록</button>
                    </div>
                    </form>
                </div>


            </div>

        </div>

    </section>
    <!-- footer.jsp 따로 만든 것 붙여넣기 -->
	<jsp:include page="../include/footer.jsp"/>    
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>