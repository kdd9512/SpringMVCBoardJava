<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 종종 주소에 jsessionid 라고 붙는 현상 방지 --%>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>자유 게시판</title>
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<!-- 상단 메뉴 부분(navbar) -->
<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<!-- 게시글 리스트 -->
<div class="container" style="margin-top:100px">
    <div class="card shadow">
        <div class="card-body">
            <h4 class="card-title">${boardInfoName}</h4>
            <table class="table table-hover" id='board_list'>
                <thead>
                <tr>
                    <th class="text-center d-none d-md-table-cell">글번호</th>
                    <th class="w-50">제목</th>
                    <th class="text-center d-none d-md-table-cell">작성자</th>
                    <th class="text-center d-none d-md-table-cell">작성날짜</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="obj" items="${contentList}">
                    <tr>
                        <td class="text-center d-none d-md-table-cell">${obj.content_idx}</td>
                        <td>
                            <a href='<c:url value="/board/read?board_info_idx=${board_info_idx}&content_idx=${obj.content_idx}&page=${page}"/>'>
                                    ${obj.content_subject}</a></td>
                        <td class="text-center d-none d-md-table-cell">${obj.content_writer_name}</td>
                        <td class="text-center d-none d-md-table-cell">${obj.content_date}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="d-none d-md-block">
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${pagingBean.prevPage <= 0}">
                            <li class="page-item disabled">
                                <a href='#'
                                   class="page-link">이전</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a href='<c:url value="/board/main?board_info_idx=${board_info_idx}&page=${pagingBean.prevPage}"/>'
                                   class="page-link">이전</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="idx" begin="${pagingBean.min}" end="${pagingBean.max}">
                        <c:choose>
                            <c:when test="${idx == pagingBean.currPage}">
                                <li class="page-item active">
                                    <a href='<c:url value="/board/main?board_info_idx=${board_info_idx}&page=${idx}"/>'
                                       class="page-link">${idx}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a href='<c:url value="/board/main?board_info_idx=${board_info_idx}&page=${idx}"/>'
                                       class="page-link">${idx}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${pagingBean.max >= pagingBean.pageCnt}">
                            <li class="page-item disabled">
                                <a href='#'
                                   class="page-link">다음</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a href='<c:url value="/board/main?board_info_idx=${board_info_idx}&page=${pagingBean.nextPage}"/>'
                                   class="page-link">다음</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>

            <div class="text-right">
                <%--
                    Controller 의 Model 에서 저장한 props "board_info_idx" 를 main 에 넘겼으므로,
                    글쓰기를 호출한 게시판이 어디인지 구별 가능하다.
                --%>
                <a href="<c:url value="/board/write?board_info_idx=${board_info_idx}&page=${page}"/>" class="btn btn-primary">글쓰기</a>
            </div>

        </div>
    </div>
</div>

<!-- 하단 정보(footer) -->
<c:import url="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>







