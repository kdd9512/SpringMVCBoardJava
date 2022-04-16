package dao;

import beans.ContentsInfoBean;
import mapper.BoardMapper;
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

    public List<ContentsInfoBean> getContentBean(int board_info_idx) {
        return boardMapper.getContentBean(board_info_idx);
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
}
