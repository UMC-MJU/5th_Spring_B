package week7.api.global.validation.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import week7.api.global.validation.validator.CategoriesExistValidator;

@Documented // - 사용자 정의 애노테이션
@Constraint(validatedBy = CategoriesExistValidator.class)   // validatedBy~ 클래스로 본 애노테이션이 붙은 클래스를 검증
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) // 검증 범위
@Retention(RetentionPolicy.RUNTIME) // 생명 주기
public @interface ExistCategories {
    String message() default "Invalid category"; // 기본 오류 메시지
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
