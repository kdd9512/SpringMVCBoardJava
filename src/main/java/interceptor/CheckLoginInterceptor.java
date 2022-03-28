package interceptor;

import beans.MemberInfoBean;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {

    private MemberInfoBean loginMemberBean;

    public CheckLoginInterceptor(MemberInfoBean loginMemberBean) {
        this.loginMemberBean = loginMemberBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        if (!loginMemberBean.isMemberLogin()) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/member/not_login");
            return false;
        }
        return true;
    }
}
