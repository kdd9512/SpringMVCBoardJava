package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/main")
    public String boardMain(){

        return "/board/main";
    }

    @GetMapping("/board_write")
    public String boardWrite(){

        return "/board/board_write";
    }

    @GetMapping("/board_read")
    public String boardRead(){

        return "/board/board_read";
    }

    @GetMapping("/board_modify")
    public String boardModify(){

        return "/board/board_modify";
    }

    @GetMapping("/board_remove")
    public String boardRemove(){

        return "/board/board_remove";
    }

}
