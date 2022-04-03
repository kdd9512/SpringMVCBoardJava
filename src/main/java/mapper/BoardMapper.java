package mapper;

import beans.ContentsInfoBean;
import org.apache.ibatis.annotations.Insert;

public interface BoardMapper {

    @Insert("insert into content_table(content_idx, content_subject, content_text, " +
            "content_file, content_writer_idx, content_board_idx, content_date) " +
            "values ((select max(content_idx) + 1 from content_table ALIAS_FOR_SUBQUERY), " +
            "#{content_subject}, #{content_text}, #{content_file}, #{content_writer_idx}, " +
            "#{content_board_idx}, CURRENT_DATE())")
    void addContentInfo(ContentsInfoBean writeContentBean);
}
