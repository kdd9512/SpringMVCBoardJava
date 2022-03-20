package validator;


import beans.MemberInfoBean;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberInfoBean.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberInfoBean memberBean = (MemberInfoBean) target;

        if (!memberBean.getUser_pw().equals(memberBean.getUser_pw2())) {
            errors.rejectValue("user_pw", "NotEquals");
            errors.rejectValue("user_pw2", "NotEquals");
        }

        if (!memberBean.isMemberIdExist()) {
            errors.rejectValue("user_id","DoNotCheckIdExist");
        }

    }
}
