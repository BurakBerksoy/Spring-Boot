package com.example4.Lesson.controller.impl;

import com.example4.Lesson.controller.IStudentController;
import com.example4.Lesson.dto.DtoStudent;
import com.example4.Lesson.dto.DtoStudentIU;
import com.example4.Lesson.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IStudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        return studentService.getStudentById(id);
    }

    @Override
    public DtoStudent createNewStudent(DtoStudentIU newStudentIU) {
        return studentService.createNewStudent(newStudentIU);
    }

    @Override
    public void deleteStudentFoundById(Integer id) {
        studentService.deleteStudentFoundById(id);
    }

    @Override
    public DtoStudent updateStudentFoundById(Integer id, DtoStudentIU updateStudentIU) {
        return studentService.updateStudentFoundById(id, updateStudentIU);
    }
}
