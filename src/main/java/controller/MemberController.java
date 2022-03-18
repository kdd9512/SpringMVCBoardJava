package controller;

import beans.MemberInfoBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import validator.MemberValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public String login(){

        return "/member/login";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("joinMemberBean") MemberInfoBean joinMemberBean){

        return "/member/join";
    }

    // 회원가입시 Bean 에 설정해놓은 유효성검사 @Valid, 결과도출 BindingResult result
    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinMemberBean") MemberInfoBean joinMemberBean,
                           BindingResult result){
        if (result.hasErrors()){
            return "/member/join";
        }

        return "/member/join_success";
    }

    // 비밀번호 일치여부 확인 위한 initBinder
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        MemberValidator validator1 = new MemberValidator();
        binder.addValidators(validator1);
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
