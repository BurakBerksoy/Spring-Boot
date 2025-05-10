package com.example6.Lesson.repository;

import com.example6.Lesson.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
