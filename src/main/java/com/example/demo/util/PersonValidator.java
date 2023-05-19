package com.example.demo.util;

import com.example.demo.model.Administration;
import com.example.demo.service.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Administration.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Administration administration = (Administration) o;

        try {
            personDetailsService.loadUserByUsername(administration.getUsername());
        }catch (UsernameNotFoundException usernameNotFoundException){
            return;
        }

        errors.rejectValue("username", "", "Пользователь с таким ФИО уже существует ");
    }
}










