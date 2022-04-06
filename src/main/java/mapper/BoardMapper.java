package mapper;

import beans.ContentsInfoBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

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

}
