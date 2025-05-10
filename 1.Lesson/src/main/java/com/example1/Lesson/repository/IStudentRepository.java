package com.example1.Lesson.repository;

import com.example1.Lesson.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Students, Integer> {
}
