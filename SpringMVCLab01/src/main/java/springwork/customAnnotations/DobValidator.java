package springwork.customAnnotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DobValidator implements ConstraintValidator<DateOfBirthConstraint, String>{
	public static final Pattern VALID_DOB = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");
	
	public static boolean validate(String dob) {
		Matcher matcher = VALID_DOB.matcher(dob);
		
		return matcher.find();
	}
	@Override
	public void initialize(DateOfBirthConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return validate(value);
	}
	
	

}
