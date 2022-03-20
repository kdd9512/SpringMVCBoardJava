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
    <title>회원가입</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<script>
    function checkMemberIdExist() {

        let user_id = $("#user_id").val()

        if (user_id.length == 0) {
            alert("아이디를 입력하세요.")
            return
        }

        $.ajax({
            url : "/member/checkMemberIdExist/" + user_id,
            type : "get",
            dataType : "text",
            success : function (result) {
                if (result.trim() === "true") {
                    alert("사용 가능한 아이디입니다.")
                    $("#memberIdExist").val('true')
                } else {
                    alert("사용할 수 없는 아이디입니다.")
                    $("#memberIdExist").val('false')
                }
            }
            
        })

    }
    // 사용자 아이디 입력칸을 클릭한 뒤 문자를 입력하면 기본값(검사하기 이전이므로 false)을 전달.
    function resetMemberIdExist() {
        $("#memberIdExist").val('false')
    }
    
</script>

<!-- 상단 메뉴 부분(navbar) -->
<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<div class="container" style="margin-top:100px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card shadow">
                <div class="card-body">
                    <%-- 커스텀 태그 설정 --%>
                    <form:form action="/member/join_pro" method="post" modelAttribute="joinMemberBean">
                        <form:hidden path="memberIdExist"/>
                        <div class="form-group">
                            <form:label path="user_name">이름</form:label>
                            <form:input path="user_name" class="form-control"/>
                            <form:errors path="user_name" style="color:red"/>
                        </div>
                        <div class="form-group">
                            <form:label path="user_id">아이디</form:label>
                            <div class="input-group">
                                <form:input path="user_id" class="form-control" onkeypress="resetMemberIdExist()"/>
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-primary" onclick="checkMemberIdExist()">중복확인</button>
                                </div>
                            </div>
                            <form:errors path="user_id" style="color:red"/>
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
                                <form:button class="btn btn-primary">회원가입</form:button>
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








