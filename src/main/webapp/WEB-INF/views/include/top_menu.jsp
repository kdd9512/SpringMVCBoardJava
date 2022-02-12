<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="<c:url value="/board/main"/>" class="nav-link">자유게시판</a>
            </li>
            <li class="nav-item">
                <a href="<c:url value="/board/main"/>" class="nav-link">유머게시판</a>
            </li>
            <li class="nav-item">
                <a href="<c:url value="/board/main"/>" class="nav-link">정치게시판</a>
            </li>
            <li class="nav-item">
                <a href="<c:url value="/board/main"/>" class="nav-link">스포츠게시판</a>
            </li>
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