package mapper;

import beans.MemberInfoBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MemberMapper {

    @Select("select user_name " +
            "from user_table " +
            "where user_id = #{user_id}")
    String checkMemberIdExist(String user_id);

    // ALIAS_FOR_SUBQUERY : mariadb 는 기본적으로 동일 테이블 내에서 서브쿼리 조합이 안되므로,
    // 서브쿼리 내 테이블을 불러야한다면 별명을 지정하여 구분해야 한다.
    @Insert("insert into user_table (user_idx, user_name, user_id, user_pw) " +
            "values ((select max(user_idx) + 1 from user_table ALIAS_FOR_SUBQUERY), " +
            "#{user_name}, #{user_id}, #{user_pw}) ")
    void addMemberInfo(MemberInfoBean joinMemberBean);

    @Select("select user_idx, user_name " +
            "from user_table " +
            "where user_id=#{user_id} and user_pw=#{user_pw} ")
    MemberInfoBean getLoginMemberInfo(MemberInfoBean tempLoginMemberBean);

    @Select("select user_id, user_name " +
            "from user_table " +
            "where user_idx = #{user_idx}")
    MemberInfoBean getModifyMemberInfo(int user_idx); // user_idx 로 찾아야 하니까 당연히 parameter 는 user_idx.

    @Update("update user_table " +
            "set user_pw = #{user_pw} " +
            "where user_idx = #{user_idx}")
    void modifyMemberInfo(MemberInfoBean modifyMemberBean);

}
