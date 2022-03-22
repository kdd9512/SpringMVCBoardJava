package controller;

import beans.MemberInfoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
public class HomeController {

	// loginMemberBean 이 session 으로 들어오고 있는지 확인하기 위한 코드.
//	@Resource(name = "loginMemberBean")
//	private MemberInfoBean loginMemberBean;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
//		System.out.println(loginMemberBean);
		return "redirect:/main";
	}
}

