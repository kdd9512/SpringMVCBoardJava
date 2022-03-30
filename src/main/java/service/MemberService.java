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

    public void getModifyMemberInfo(MemberInfoBean modifyMemberBean) {
        MemberInfoBean tempModifyMemberBean = memberDAO.getModifyMemberInfo(loginMemberBean.getUser_idx());

        modifyMemberBean.setUser_id(tempModifyMemberBean.getUser_id());
        modifyMemberBean.setUser_name(tempModifyMemberBean.getUser_name());
        modifyMemberBean.setUser_idx(loginMemberBean.getUser_idx()); // idx 가지고 회원정보 찾는거니 이곳에 sql 로 가져온 idx 를 담는다.
    }

    public void modifyMemberInfo(MemberInfoBean modifyMemberBean) {
        modifyMemberBean.setUser_idx(loginMemberBean.getUser_idx()); // 사용자번호가 필요하므로, sql 로 가져온 idx 를 가져옴.

        // 비밀번호는 parameter 로 넘어오는 데이터를 자동으로 주입받으므로 여기서 가져올 필요는 없다.
        memberDAO.modifyMemberInfo(modifyMemberBean);
    }
}
