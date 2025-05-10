package com.example5.Lesson.service.impl;

import com.example5.Lesson.dto.DtoStudent;
import com.example5.Lesson.dto.DtoStudentIU;
import com.example5.Lesson.model.Student;
import com.example5.Lesson.repository.IStudentRepository;
import com.example5.Lesson.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<DtoStudent> getAllStudent() {
        List<Student> allStudent = studentRepository.findAll();
        List<DtoStudent> allDtoStudent = new ArrayList<>();
        for (Student student : allStudent){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            allDtoStudent.add(dtoStudent);
        }
        return allDtoStudent;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()){
            return null;
        }
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(optionalStudent, dtoStudent);
        return dtoStudent;
    }

    @Override
    public DtoStudent saveNewStudent(DtoStudentIU newStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(newStudentIU, student);
        Student saveStudent = studentRepository.save(student);
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(saveStudent, dtoStudent);
        return dtoStudent;
    }

    @Override
    public void deleteStudentFoundById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateStudentFoundById(Integer id, DtoStudentIU studentUpdateIU) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()){
            return null;
        }
        Student student = optionalStudent.get();
        studentUpdateIU.setFullName(student.getFullName());
        studentUpdateIU.setPassword(student.getPassword());

        studentRepository.save(student);

        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(student, dtoStudent);
        return dtoStudent;
    }
}
