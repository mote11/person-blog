package com.edu.cqie.anno;

import com.edu.cqie.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.*;

@Documented  //元注解
@Constraint(
        validatedBy = {StateValidation.class} //指定提供校验规则的类
)
@Target({ElementType.FIELD})  //元注解
@Retention(RetentionPolicy.RUNTIME)  //元注解
public @interface State{
    //提供校验失败的信息
    String message() default "Status的参数只能是审核中|发布|驳回";
    //指定分组
    Class<?>[] groups() default {};
    //负载  获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
