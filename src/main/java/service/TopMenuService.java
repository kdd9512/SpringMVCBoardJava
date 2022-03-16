package service;

import beans.BoardInfoBean;
import dao.TopMenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopMenuService {

    private final TopMenuDAO topMenuDao;

    public TopMenuService(TopMenuDAO topMenuDao) {
        this.topMenuDao = topMenuDao;
    }

    public List<BoardInfoBean> getTopMenuList(){
      return topMenuDao.getTopMenuList();
    }


}
