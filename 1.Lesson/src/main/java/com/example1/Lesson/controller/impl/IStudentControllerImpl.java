package com.example1.Lesson.controller.impl;

import com.example1.Lesson.controller.IStudentController;
import com.example1.Lesson.dto.DtoStudent;
import com.example1.Lesson.dto.DtoStudentIU;
import com.example1.Lesson.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class IStudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(path = "/all")
    @Override
    public List<DtoStudent> getAllStudentList() {
        return studentService.getAllStudentList();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoStudent getByIdStudent(@Valid @PathVariable(name = "id") Integer id) {
        DtoStudent dtoStudent = studentService.getByIdStudent(id);
        if (dtoStudent == null) {
            throw new RuntimeException("Student not found");
        }
        return dtoStudent;
    }

    @PostMapping(path = "/create")
    @Override
    public DtoStudent saveNewStudent(@Valid @RequestBody DtoStudentIU newStudentIU) {
        return studentService.saveNewStudent(newStudentIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@Valid @PathVariable(name = "id") Integer id) {
        DtoStudent dtoStudent = studentService.getByIdStudent(id);
        if (dtoStudent == null){
            throw new RuntimeException("Student not found");
        }
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudentById(@Valid @PathVariable(name = "id") Integer id,
                                        @Valid @RequestBody DtoStudentIU updateStudentIU) {
        DtoStudent dtoStudent = studentService.getByIdStudent(id);
        if (dtoStudent == null){
            throw new RuntimeException("Student not found");
        }
        return dtoStudent;
    }
}
