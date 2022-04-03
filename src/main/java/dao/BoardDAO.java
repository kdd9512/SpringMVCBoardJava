package dao;

import beans.ContentsInfoBean;
import mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

    @Autowired
    private BoardMapper boardMapper;

    public void addContentInfo(ContentsInfoBean writeContentBean) {
        boardMapper.addContentInfo(writeContentBean);
    }

}
