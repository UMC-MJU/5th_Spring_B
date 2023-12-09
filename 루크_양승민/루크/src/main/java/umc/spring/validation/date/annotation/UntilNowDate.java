package umc.spring.validation.date.annotation;

import umc.spring.validation.date.validator.DateUntilNowValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateUntilNowValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UntilNowDate {

    String message() default "현재 날짜 이후일 수 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
