<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    alert("수정되었습니다.")
    // property 로 넘어온 값은 modifyContentBean 이므로, 용도에 맞는 자료는 modifyContentBean 안에서 찾아야 한다.
    location.href="/board/read?board_info_idx=${modifyContentBean.content_board_idx}&content_idx=${modifyContentBean.content_idx}";
</script>
