<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- 종종 주소에 jsessionid 라고 붙는 현상 방지 --%>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원 정보 수정</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>

<!-- 상단 메뉴 부분(navbar) -->
<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<div class="container" style="margin-top:100px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card shadow">
                <div class="card-body">
                    <form:form action="/member/modify_pro" method="post" modelAttribute="modifyMemberBean">
                        <div class="form-group">
                            <form:label path="user_name">이름</form:label>
<%-- disable 보다 readOnly 가 낫다. 비활성화를 해버리면 modelAttribute 에서 값을 못가져오는 경우가 생긴다. --%>
                            <form:input path="user_name" class="form-control" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <form:label path="user_id">아이디</form:label>
                            <form:input path="user_id" class="form-control" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <form:label path="user_pw">비밀번호</form:label>
                            <form:password path="user_pw" class="form-control"/>
                            <form:errors path="user_pw" style="color:red"/>
                        </div>
                        <div class="form-group">
                            <form:label path="user_pw2">비밀번호 확인</form:label>
                            <form:password path="user_pw2" class="form-control"/>
                            <form:errors path="user_pw2" style="color:red"/>
                        </div>
                        <div class="form-group">
                            <div class="text-right">
                                <form:button class="btn btn-primary">정보수정</form:button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<!-- 하단 정보(footer) -->
<c:import url="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>
