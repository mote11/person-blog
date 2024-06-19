package com.edu.cqie.validation;

import com.edu.cqie.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param s  将来要校验的数据
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则
        if(s==null){
            return false;
        }
        if (s.equals("audit")||s.equals("publish")||s.equals("reject")){
            return true;
        }
        return false;
    }
}
