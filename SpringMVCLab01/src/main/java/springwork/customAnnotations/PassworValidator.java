package springwork.customAnnotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PassworValidator implements ConstraintValidator<PasswordConstraint, String>{
	public static final Pattern VALID_PASSWORD = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
	
	public static boolean validate(String pass) {
		Matcher matcher = VALID_PASSWORD.matcher(pass);
		
		return matcher.find();
	}
	@Override
	public void initialize(PasswordConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return validate(value);
	}
	

}
