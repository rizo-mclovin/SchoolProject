package com.example.demo.service;

import com.example.demo.model.Administration;
import com.example.demo.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class RegistrationService{
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(Administration administration){
        administration.setPassword(passwordEncoder.encode(administration.getPassword()));
//        administration.setRole("ROLE_USER");
        peopleRepository.save(administration);
    }

}
