package service;

import beans.MemberInfoBean;
import dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Resource(name = "loginMemberBean")
    private MemberInfoBean loginMemberBean;

    public boolean checkMemberIdExist(String user_id) {
        String user_name = memberDAO.checkMemberIdExist(user_id);

        // user_name 이 null 이라는건 겹치는 id 가 없다는 것이므로 해당 id를 등록에 사용할 수 있다.
        // 조건에 부합할 경우 true 를 반환한다.
        return user_name == null;
    }

    public void addMemberInfo(MemberInfoBean joinMemberBean) {
        memberDAO.addMemberInfo(joinMemberBean);
    }

    public void getLoginMemberInfo(MemberInfoBean tempLoginMemberBean) {
        MemberInfoBean tempLoginMemberBean2 = memberDAO.getLoginMemberInfo(tempLoginMemberBean);

        if (tempLoginMemberBean2 != null) {
            loginMemberBean.setUser_idx(tempLoginMemberBean2.getUser_idx());
            loginMemberBean.setUser_name(tempLoginMemberBean2.getUser_name());
            loginMemberBean.setMemberLogin(true);
        }
    }

}
