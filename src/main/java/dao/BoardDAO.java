package dao;

import beans.ContentsInfoBean;
import mapper.BoardMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    private BoardMapper boardMapper;

    public void addContentInfo(ContentsInfoBean writeContentBean) {
        boardMapper.addContentInfo(writeContentBean);
    }

    public String getBoardInfoName(int board_info_idx) {
        return boardMapper.getBoardInfoName(board_info_idx);
    }

    public List<ContentsInfoBean> getContentBean(int board_info_idx, RowBounds rowBounds) {
        return boardMapper.getContentBean(board_info_idx, rowBounds);
    }

    public ContentsInfoBean getContentInfo(int content_idx) {
        return boardMapper.getContentInfo(content_idx);
    }

    public void modifyContentInfo(ContentsInfoBean modifyContentBean) {
        boardMapper.modifyContentInfo(modifyContentBean);
    }

    public void removeContentInfo(int content_idx) {
        boardMapper.removeContentInfo(content_idx);
    }

    public int getContentCnt(int content_board_idx) {
        return boardMapper.getContentCnt(content_board_idx);
    }
}
