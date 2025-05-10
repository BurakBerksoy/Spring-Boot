package com.example1.Lesson.services;

import com.example1.Lesson.dto.DtoStudent;
import com.example1.Lesson.dto.DtoStudentIU;

import java.util.List;

public interface IStudentService {
    List<DtoStudent> getAllStudentList();
    DtoStudent getByIdStudent(Integer id);
    DtoStudent saveNewStudent(DtoStudentIU newStudentIU);
    void deleteStudentById(Integer id);
    DtoStudent updateStudentById(Integer id, DtoStudentIU updateStudentIU);
}
