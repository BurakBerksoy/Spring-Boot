package com.example4.Lesson.controller;

import com.example4.Lesson.dto.DtoStudent;
import com.example4.Lesson.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController {
    List<DtoStudent> getAllStudents();
    DtoStudent getStudentById(Integer id);
    DtoStudent createNewStudent(DtoStudentIU newStudentIU);
    void deleteStudentFoundById(Integer id);
    DtoStudent updateStudentFoundById(Integer id, DtoStudentIU updateStudentIU);
}
