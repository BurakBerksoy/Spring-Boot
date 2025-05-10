package com.example5.Lesson.service;

import com.example5.Lesson.dto.DtoStudent;
import com.example5.Lesson.dto.DtoStudentIU;

import java.util.List;

public interface IStudentService {
    List<DtoStudent> getAllStudent();
    DtoStudent getStudentById(Integer id);
    DtoStudent saveNewStudent(DtoStudentIU newStudentIU);
    void deleteStudentFoundById(Integer id);
    DtoStudent updateStudentFoundById(Integer id, DtoStudentIU studentUpdateIU);
}
