package umc.study.validation.annotation;

import umc.study.validation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistReviewImage {

}
