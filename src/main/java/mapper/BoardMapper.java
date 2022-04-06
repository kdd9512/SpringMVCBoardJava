package mapper;

import beans.ContentsInfoBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface BoardMapper {

    @SelectKey(
            statement = "select max(content_idx) + 1 from content_table ALIAS_FOR_SUBQUERY", // 원하는 값을 구할 query 작성
            keyProperty = "content_idx", // statement 가 반환한 값을 저장할 변수 이름.
                                         // 이하 writeContentBean 내부의 같은 이름을 갖는 변수에 반환값이 담긴다.
            before = true, // 이하 query 보다 먼저 실행할 것인지를 설정.
            resultType = int.class) // 변수에 들어갈 값의 자료유형.
    @Insert("insert into content_table(content_idx, content_subject, content_text, " +
            "content_file, content_writer_idx, content_board_idx, content_date) " +
            "values ((select max(content_idx) + 1 from content_table ALIAS_FOR_SUBQUERY), " +
            "#{content_subject}, #{content_text}, #{content_file}, #{content_writer_idx}, " +
            "#{content_board_idx}, CURRENT_DATE())")
    void addContentInfo(ContentsInfoBean writeContentBean);

    @Select("select board_info_name " +
            "from board_info_table " +
            "where board_info_idx = #{board_info_idx}")
    String getBoardInfoName(int board_info_idx);

    @Select("select a1.content_idx, a1.content_subject, a2.user_name as content_writer_name, " +
            "DATE_FORMAT(a1.content_date, '%Y-%m-%d') as content_date " +
            "from content_table a1, user_table a2 " +
            "where a1.content_writer_idx = a2.user_idx and a1.content_board_idx = #{board_info_idx} " +
            "order by a1.content_idx desc ")
    List<ContentsInfoBean> getContentBean(int board_info_idx);

    @Select("select a2.user_name as content_writer_name, DATE_FORMAT(a1.content_date, '%Y-%m-%d') as content_date, " +
            "a1.content_subject, a1.content_text, a1.content_file " +
            "from content_table a1, user_table a2 " +
            "where a1.content_writer_idx = a2.user_idx and a1.content_idx = #{content_idx}")
    ContentsInfoBean getContentInfo (int content_idx);

}
