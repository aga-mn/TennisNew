package tennis.oval;


import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import tennis.exceptions.InvalidInputException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;

import java.util.*;

public class SpringOvalValidator implements org.springframework.validation.Validator, InitializingBean {

    private Validator validator;

    public SpringOvalValidator() {
        validator = new Validator();
    }

    public SpringOvalValidator(Validator validator) {
        this.validator = validator;
    }

    @SuppressWarnings("unchecked")
    public boolean supports(Class clazz) {
        return true;
    }

    public void validate(Object target, Errors errors) {
        System.out.println("ewwerwerwerwer ");  
        List<ConstraintViolation> constraints = validator.validate(target);
        for (ConstraintViolation constraint : constraints) {
        	System.out.println(constraint);
        	throw new InvalidInputException(constraint.getMessage(), "Invalid input");
        }
        
    }

   

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(validator, "Property [validator] is not set");
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}