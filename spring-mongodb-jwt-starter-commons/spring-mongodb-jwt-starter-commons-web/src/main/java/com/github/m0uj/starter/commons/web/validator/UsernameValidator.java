package com.github.m0uj.starter.commons.web.validator;

import com.github.m0uj.starter.commons.domain.service.UserSelectionService;
import com.github.m0uj.starter.commons.web.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by m0uj on 4/19/17.
 */
@Component
public class UsernameValidator implements Validator {
    private final UserSelectionService userSelectionService;

    public UsernameValidator(UserSelectionService userSelectionService) {
        this.userSelectionService = userSelectionService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required", "Username is required");
        if((userDTO != null) && (userDTO.getUsername() != null)){
            if (!userDTO.getUsername().matches("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"))
                errors.rejectValue("username", "username.invalid.email", "Username is not a valid email");
            if (checkUsernameExists(userDTO.getUsername()))
                errors.rejectValue("username", "username.exists", "Username is taken");
        }
    }

    private boolean checkUsernameExists(String username) {
        return userSelectionService.selectByUsername(username) != null;
    }
}
