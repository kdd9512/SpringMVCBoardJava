package validator;


import beans.MemberInfoBean;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberInfoBean.class.isAssignableFrom(clazz);
    }

    // MemberInfoBean 는 공동으로 사용하기 때문에 validator 도 RootAppContext 처럼 용도에 맞게 분류해 주어야 한다.
    @Override
    public void validate(Object target, Errors errors) {
        MemberInfoBean memberBean = (MemberInfoBean) target;

        // 예외/에러가 발생했을 경우 해당 Object 의 이름을 가져온다.
        // 이것으로 오류가 발생한 페이지를 구분해서 오류메세지를 전달할 수 있다.
        String beanName = errors.getObjectName();
//        System.out.println(beanName);

        // error 가 발생한 Object 의 이름이 이하(joinMemberBean)와 같을 때에만 작동.
        if (beanName.equals("joinMemberBean") || beanName.equals("modifyMemberBean")) {
            if (!memberBean.getUser_pw().equals(memberBean.getUser_pw2())) {
                errors.rejectValue("user_pw", "NotEquals");
                errors.rejectValue("user_pw2", "NotEquals");
            }
        }

        if (beanName.equals("joinMemberBean")) {
            if (!memberBean.isMemberIdExist()) {
                errors.rejectValue("user_id", "DoNotCheckIdExist");
            }
        }

    }
}
