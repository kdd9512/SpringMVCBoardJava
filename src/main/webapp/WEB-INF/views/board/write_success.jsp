<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    alert("작성되었습니다.")
    // property 로 넘어온 값은 writeContentBean 이므로, 용도에 맞는 자료는 writeContentBean 안에서 찾아야 한다.
    location.href="/board/read?board_info_idx=${writeContentBean.content_board_idx}&content_idx=${writeContentBean.content_idx}";
</script>