package com.testOffer.models.validator;


import com.testOffer.models.User;
import com.testOffer.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
valiate the user's inpute
 */

@Component
public class ValidatorUser implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorUser.class);

    @Autowired
    private UserService userService;



    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        User u = (User) target;
        validateLogin(errors,u);
        validateAge(errors,u);
        validateCountry(errors,u);
    }


    private void validateLogin(Errors errors, User user) {
        for (User u : userService.getAllUsers()) {
            if(u.getLogin().equalsIgnoreCase(user.getLogin())){
                errors.reject("login.exists", "User with this login already exists");
            }
        }
    }

    private void validateAge(Errors errors, User user) {
       if(user.getAge() <= 18){
           errors.reject("error age", "only adults ! ");
       }
    }

    private void validateCountry(Errors errors, User user) {
        if(!(user.getCountry().equalsIgnoreCase("France"))){
            errors.reject("error country", "must living in french ! ");
        }
    }
}
