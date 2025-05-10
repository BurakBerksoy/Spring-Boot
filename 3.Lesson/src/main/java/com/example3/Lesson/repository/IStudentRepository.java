package com.example3.Lesson.repository;

import com.example3.Lesson.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
