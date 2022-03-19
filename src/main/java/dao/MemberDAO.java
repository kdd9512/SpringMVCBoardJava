package dao;

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


}
