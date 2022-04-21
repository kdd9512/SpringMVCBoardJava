package service;

import beans.ContentsInfoBean;
import dao.BoardDAO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private BoardDAO boardDAO;

    public List<ContentsInfoBean> getMainList(int board_info_idx) {
        RowBounds rowBounds = new RowBounds(0,5);
        return boardDAO.getContentBean(board_info_idx, rowBounds);
    }

}
