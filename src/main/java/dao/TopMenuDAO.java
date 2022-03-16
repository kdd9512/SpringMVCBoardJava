package dao;

import beans.BoardInfoBean;
import mapper.TopMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopMenuDAO {

    private final TopMenuMapper topMenuMapper;

    public TopMenuDAO(TopMenuMapper topMenuMapper) {
        this.topMenuMapper = topMenuMapper;
    }

    public List<BoardInfoBean> getTopMenuList(){
        return topMenuMapper.getTopMenuList();
    }

}
