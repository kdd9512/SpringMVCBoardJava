package config;

import beans.MemberInfoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {

    // 로그인 한 사용자의 정보를 담을 MemberInfoBean 에 이름을 붙히고 sessionScope 로 정의한다.
    // MemberInfoBean 은 회원등록, 수정 및 삭제 등에도 사용되므로 반드시 이름을 붙혀서 구분해서 사용해야 한다.
    @Bean("loginMemberBean")
    @SessionScope
    public MemberInfoBean loginMemberBean() {
        return new MemberInfoBean();
    }

}
