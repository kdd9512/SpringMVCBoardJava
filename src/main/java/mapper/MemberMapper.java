package mapper;

import beans.MemberInfoBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {

    @Select("select user_name " +
            "from user_table " +
            "where user_id = #{user_id}")
    String checkMemberIdExist(String user_id);

}
