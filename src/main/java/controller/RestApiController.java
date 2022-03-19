package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.MemberService;

@RestController
public class RestApiController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/checkUserIdExist/{user_id}")
    public String memberIdExist(@PathVariable String user_id){
        boolean check = memberService.checkMemberIdExist(user_id);

        return check + ""; // "" 를 붙혀 문자열로 강제변환.
    }

}
