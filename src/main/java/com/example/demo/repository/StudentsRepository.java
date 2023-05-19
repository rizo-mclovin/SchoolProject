package com.example.demo.repository;
import com.example.demo.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer> {
    @Override
    Optional<Student> findById(Integer id);

    List<Student> findByFullStudentNameStartingWith(String name);
    Optional<Student> findAllByFullStudentName(String fullName);
}
