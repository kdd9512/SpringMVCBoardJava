package controller;

import beans.BoardInfoBean;
import beans.ContentsInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.MainService;
import service.TopMenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @Autowired
    private TopMenuService topMenuService;

    @GetMapping("/main")
    public String main(Model model) {

        ArrayList<List<ContentsInfoBean>> list = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            List<ContentsInfoBean> list1 = mainService.getMainList(i);
            list.add(list1);
        }

        model.addAttribute("list", list);

        List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
        model.addAttribute("board_list", board_list);

        return "main";
    }

}
