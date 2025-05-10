package com.example3.Lesson.services;

import com.example3.Lesson.dto.DtoStudent;
import com.example3.Lesson.dto.DtoStudentIU;

import java.util.List;

public interface IStudentServices {
    List<DtoStudent> getAllStudents();
    DtoStudent getStudentById(Integer id);
    DtoStudent createNewStudent(DtoStudentIU newIU);
    void deleteFoundStudentById(Integer id);
    DtoStudent updateFoundStudentById(Integer id, DtoStudentIU updateIU);
}
