package service;

import beans.BoardInfoBean;
import dao.TopMenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopMenuService {

    @Autowired
    private TopMenuDAO topMenuDAO;

    public List<BoardInfoBean> getTopMenuList(){
        return topMenuDAO.getTopMenuList();
    }

}
