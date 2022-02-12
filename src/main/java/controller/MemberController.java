package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public String login(){

        return "/member/login";
    }

    @GetMapping("/join")
    public String join(){

        return "/member/join";
    }

    @GetMapping("/modify")
    public String memberConfig(){

        return "/member/modify";
    }

    @GetMapping("/logout")
    public String logout(){

        return "/member/logout";
    }

}
