package controller;

import beans.MemberInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import service.MemberService;
import validator.MemberValidator;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Resource(name = "loginMemberBean")
    private MemberInfoBean loginMemberBean;

    // 로그인 부분.
    @GetMapping("/login")
    public String login(@ModelAttribute("tempLoginMemberBean") MemberInfoBean tempLoginMemberBean,
                        @RequestParam(value = "fail", defaultValue = "false") boolean fail, // 로그인 성공/실패 여부를 parameter 로 전달.
                        Model model) { // fail 을 Model 에 담는다.

        model.addAttribute("fail", fail);

        return "/member/login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("tempLoginMemberBean") MemberInfoBean tempLoginMemberBean,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "/member/login";
        }

        memberService.getLoginMemberInfo(tempLoginMemberBean);

        if (loginMemberBean.isMemberLogin()) {
            return "/member/login_success";
        } else {
            return "/member/login_fail";
        }

    }

    @GetMapping("/logout")
    public String logout() {
        loginMemberBean.setMemberLogin(false);
        return "/member/logout";
    }

    @GetMapping("/not_login")
    public String not_login() {
        return "/member/not_login";
    }


    // 회원가입 부분
    @GetMapping("/join")
    public String join(@ModelAttribute("joinMemberBean") MemberInfoBean joinMemberBean) {

        return "/member/join";
    }

    // 회원가입시 Bean 에 설정해놓은 유효성검사 @Valid, 결과도출 BindingResult result
    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinMemberBean") MemberInfoBean joinMemberBean,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "/member/join";
        }

        memberService.addMemberInfo(joinMemberBean);

        return "/member/join_success";
    }


    // 비밀번호 일치여부 확인 위한 initBinder
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        MemberValidator validator1 = new MemberValidator();
        binder.addValidators(validator1);
    }

    @GetMapping("/modify")
    public String memberConfig(@ModelAttribute("modifyMemberBean") MemberInfoBean modifyMemberBean) {

        memberService.getModifyMemberInfo(modifyMemberBean);

        return "/member/modify";
    }

    @PostMapping("/modify_pro")
    public String modify_pro(@Valid @ModelAttribute("modifyMemberBean") MemberInfoBean modifyMemberBean,
                             BindingResult result){
        if (result.hasErrors()) {
            return "/member/modify";
        }

        // modifyMemberBean 에 입력받은 password 가 있을 것이다.
        memberService.modifyMemberInfo(modifyMemberBean);

        return "/member/modify_success";
    }



}
