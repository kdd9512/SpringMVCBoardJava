<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- 종종 주소에 jsessionid 라고 붙는 현상 방지 --%>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인</title>
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
                    <%-- 로그인이 실패했을 경우 이하를 표시한다. --%>
                    <c:if test="${fail == true}">
                        <div class="alert alert-danger">
                            <h3>로그인 실패</h3>
                            <p>아이디 비밀번호를 확인해주세요</p>
                        </div>
                    </c:if>
                    <form:form action="/member/login_pro" method="post" modelAttribute="tempLoginMemberBean">
                        <div class="form-group">
                            <form:label path="user_id">아이디</form:label>
                            <form:input path="user_id" class="form-control"/>
                            <form:errors path="user_id" style="color:red"/>
                        </div>
                        <div class="form-group">
                            <form:label path="user_pw">비밀번호</form:label>
                            <form:password path="user_pw" class="form-control"/>
                            <form:errors path="user_pw" style="color:red"/>
                        </div>
                        <div class="form-group text-right">
                            <form:button class="btn btn-primary">로그인</form:button>
                            <a href="<c:url value="/member/join"/>" class="btn btn-danger">회원가입</a>
                        </div>
                    </form:form>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </div>

    <!-- 하단 정보(footer) -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>








