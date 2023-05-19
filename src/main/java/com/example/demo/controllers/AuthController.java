package com.example.demo.controllers;
import com.example.demo.model.Administration;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.service.RegistrationService;
import com.example.demo.util.PersonValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PersonValidator personValidator;
    private final RegistrationService registrationService;
    private final PeopleRepository adminRepository ;


    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("administrator") Administration administration){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("administrator") @Valid Administration administration, BindingResult bindingResult){
        personValidator.validate(administration, bindingResult);

        if (bindingResult.hasErrors()){
            return "/auth/registration";
        }
        registrationService.register(administration);

        return "auth/successReg";
    }

}
