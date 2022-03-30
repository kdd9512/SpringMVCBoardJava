package dao;

import beans.MemberInfoBean;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private MemberMapper memberMapper;

    public String checkMemberIdExist(String user_id) {
        return memberMapper.checkMemberIdExist(user_id);
    }

    public void addMemberInfo(MemberInfoBean joinMemberBean) {
        memberMapper.addMemberInfo(joinMemberBean);
    }

    public MemberInfoBean getLoginMemberInfo(MemberInfoBean tempLoginMemberBean) {
        return memberMapper.getLoginMemberInfo(tempLoginMemberBean);
    }

    public MemberInfoBean getModifyMemberInfo(int user_idx) {
        return memberMapper.getModifyMemberInfo(user_idx);
    }

    public void modifyMemberInfo(MemberInfoBean modifyMemberBean) {
        memberMapper.modifyMemberInfo(modifyMemberBean);
    }

}
