package dao;

import beans.BoardInfoBean;
import mapper.TopMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopMenuDAO {

    @Autowired
    private TopMenuMapper topMenuMapper;

    public List<BoardInfoBean> getTopMenuList(){
        List<BoardInfoBean> topMenuList = topMenuMapper.getTopMenuList();
        return topMenuList;
    }

}
