package com.github.m0uj.starter.commons.web.validator;

import com.github.m0uj.starter.commons.web.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by m0uj on 4/11/17.
 */
@Component
public class UserValidator implements Validator {
    private final UsernameValidator usernameValidator;

    public UserValidator(UsernameValidator usernameValidator) {
        this.usernameValidator = usernameValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;

        if (userDTO == null)
            errors.reject("user.null", "User is empty");

        try {
            ValidationUtils.invokeValidator(usernameValidator, userDTO, errors);
        } finally {
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "Password is required");
        if((userDTO != null) && (userDTO.getPassword() != null)){
            if (!userDTO.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))
                errors.rejectValue("password", "password.invalid", "Password is not valid (at least 8 characters including numbers)");
        }
    }
}
