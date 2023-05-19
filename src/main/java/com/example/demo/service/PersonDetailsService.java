package com.example.demo.service;

import com.example.demo.model.Administration;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Administration> admin = peopleRepository.findByUsername(s);
        if (admin.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new PersonDetails(admin.get());
    }
}