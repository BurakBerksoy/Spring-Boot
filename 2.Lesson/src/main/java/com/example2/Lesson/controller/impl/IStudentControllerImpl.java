package com.example2.Lesson.controller.impl;

import com.example2.Lesson.controller.IStudentController;
import com.example2.Lesson.dto.DtoStudent;
import com.example2.Lesson.dto.DtoStudentIU;
import com.example2.Lesson.services.IStudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class IStudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentServices studentServices;

    @GetMapping(path = "/all")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentServices.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoStudent getByIdStudent(@PathVariable(name = "id") Integer id) {
        return studentServices.getByIdStudent(id);
    }

    @PostMapping(path = "/create")
    @Override
    public DtoStudent createNewStudent(@RequestBody DtoStudentIU newStudentIU) {
        return studentServices.createNewStudent(newStudentIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentFoundById(@PathVariable(name = "id") Integer id) {
        studentServices.deleteStudentFoundById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudentFoundById(@PathVariable(name = "id") Integer id,
                                             @RequestBody DtoStudentIU updateStudentIU) {
        return studentServices.updateStudentFoundById(id, updateStudentIU);
    }
}
