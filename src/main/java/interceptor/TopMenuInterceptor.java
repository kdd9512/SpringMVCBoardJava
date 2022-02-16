package interceptor;

import beans.BoardInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import service.TopMenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TopMenuInterceptor implements HandlerInterceptor {

    //    @Autowired
    //    private TopMenuService topMenuService;

    // ** Interceptor 에서는 @Autowired 로 Bean 객체를 자동주입 받는것이 불가능하다.
    // 1. ServletAppContext 에서 자동주입 하고
    // 2. interceptor 쪽으로 넘긴 다음
    // 3. interceptor 쪽에서 생성자를 이용해 주입해야 한다.

    private final TopMenuService topMenuService;

    public TopMenuInterceptor(TopMenuService topMenuService) {
        this.topMenuService = topMenuService;
    }

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse resp,
                             Object handler) throws Exception {
        List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
        req.setAttribute("topMenuList", topMenuList);

        return true;
    }
}
