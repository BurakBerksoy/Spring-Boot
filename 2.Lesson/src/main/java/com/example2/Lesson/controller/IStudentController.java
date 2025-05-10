package com.example2.Lesson.controller;

import com.example2.Lesson.dto.DtoStudent;
import com.example2.Lesson.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController {
    List<DtoStudent> getAllStudents();
    DtoStudent getByIdStudent(Integer id);
    DtoStudent createNewStudent(DtoStudentIU newStudentIU);
    void deleteStudentFoundById(Integer id);
    DtoStudent updateStudentFoundById(Integer id, DtoStudentIU updateStudentIU);
}
