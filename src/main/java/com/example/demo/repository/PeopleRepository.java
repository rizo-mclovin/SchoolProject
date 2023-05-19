package com.example.demo.repository;
import com.example.demo.model.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Administration, Integer> {
    Optional<Administration> findByUsername(String username);
}