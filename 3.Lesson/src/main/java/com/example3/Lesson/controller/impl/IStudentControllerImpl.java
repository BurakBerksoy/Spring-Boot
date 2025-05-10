package com.example3.Lesson.controller.impl;

import com.example3.Lesson.controller.IStudentController;
import com.example3.Lesson.dto.DtoStudent;
import com.example3.Lesson.dto.DtoStudentIU;
import com.example3.Lesson.services.IStudentServices;
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
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
        return studentServices.getStudentById(id);
    }

    @PostMapping(path = "/create")
    @Override
    public DtoStudent createNewStudent(@RequestBody DtoStudentIU newIU) {
        return studentServices.createNewStudent(newIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteFoundStudentById(@PathVariable(name = "id") Integer id) {
        studentServices.deleteFoundStudentById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateFoundStudentById(@PathVariable(name = "id") Integer id,
                                             @RequestBody DtoStudentIU updateIU) {
        return studentServices.updateFoundStudentById(id, updateIU);
    }
}
