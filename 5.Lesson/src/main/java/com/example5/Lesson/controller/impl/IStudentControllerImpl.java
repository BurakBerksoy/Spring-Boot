package com.example5.Lesson.controller.impl;

import com.example5.Lesson.controller.IStudentController;
import com.example5.Lesson.dto.DtoStudent;
import com.example5.Lesson.dto.DtoStudentIU;
import com.example5.Lesson.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class IStudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(path = "/all")
    @Override
    public List<DtoStudent> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveNewStudent(@RequestBody DtoStudentIU newStudentIU) {
        return studentService.saveNewStudent(newStudentIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentFoundById(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudentFoundById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudentFoundById(@RequestParam(name = "id") Integer id,
                                             @RequestBody DtoStudentIU studentUpdateIU) {
        return studentService.updateStudentFoundById(id, studentUpdateIU);
    }
}
