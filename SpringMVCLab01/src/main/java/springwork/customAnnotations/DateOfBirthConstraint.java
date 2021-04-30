package springwork.customAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy= DobValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOfBirthConstraint {
	String message() default "Use correct date dd/mm/yyyy";
	Class<?> [] groups() default{};
	Class<? extends Payload> [] payload() default{};

}
