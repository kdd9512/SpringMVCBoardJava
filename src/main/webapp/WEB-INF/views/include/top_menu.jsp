<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%-- 종종 주소에 jsessionid 라고 붙는 현상 방지 --%>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg">
    <%-- <a class="navbar-brand" href="/main">SoftCampus</a> 방식으로 사용할 수는 있으나
    의도하지 않은 페이지로 링크가 걸리는 경우가 발생할 수 있기 때문에 절대경로를 직접쓰는건 적절치 못하다.--%>
    <%-- 절대경로를 사용하고싶다면 이하와 같이 사용한다 --%>
    <a class="navbar-brand" href="<c:url value="/main"/>">SoftCampus</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navMenu">
<%-- <%@ page isELIgnored="false" %> (표현언어 = EL 무시할건가? 를 묻는 것)추가해야 정상적으로 request 값을 받아온다. --%>
<%-- 이걸 false로 해주지 않으면 표현언어 구문 해석 시 단순한 text 로 해석한다. --%>
        <ul class="navbar-nav">
            <c:forEach var="obj" items="${topMenuList}">
                <li class="nav-item">
                    <a href="<c:url value="/board/main?board_info_idx=${obj.board_info_idx}"/>"
                       class="nav-link">${obj.board_info_name}</a>
                </li>
            </c:forEach>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="<c:url value="/member/login"/>" class="nav-link">로그인</a>
            </li>
            <li class="nav-item">
                <a href="<c:url value="/member/join"/>" class="nav-link">회원가입</a>
            </li>
            <li class="nav-item">
                <a href="<c:url value="/member/modify"/>" class="nav-link">정보수정</a>
            </li>
            <li class="nav-item">
                <a href="<c:url value="/member/logout"/>" class="nav-link">로그아웃</a>
            </li>
        </ul>
    </div>
</nav>