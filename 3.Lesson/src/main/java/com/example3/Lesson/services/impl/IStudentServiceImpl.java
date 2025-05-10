package com.example3.Lesson.services.impl;

import com.example3.Lesson.dto.DtoStudent;
import com.example3.Lesson.dto.DtoStudentIU;
import com.example3.Lesson.model.Student;
import com.example3.Lesson.repository.IStudentRepository;
import com.example3.Lesson.services.IStudentServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IStudentServiceImpl implements IStudentServices {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<DtoStudent> getAllStudents() {
        List<Student> studentAll = studentRepository.findAll();
        List<DtoStudent> dtoStudentAll = new ArrayList<>();
        for (Student student : studentAll){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoStudentAll.add(dtoStudent);
        }
        return dtoStudentAll;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(optionalStudent, dtoStudent);
            return dtoStudent;
        }
        return null;
    }

    @Override
    public DtoStudent createNewStudent(DtoStudentIU newIU) {
        Student student = new Student();
        BeanUtils.copyProperties(newIU, student);
        studentRepository.save(student);
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(student, dtoStudent);
        return dtoStudent;
    }

    @Override
    public void deleteFoundStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateFoundStudentById(Integer id, DtoStudentIU updateIU) {
        Optional<Student> updateFoundById = studentRepository.findById(id);
        if (updateFoundById.isEmpty()){
            return null;
        }
        Student student = updateFoundById.get();
        student.setFirstName(updateIU.getFirstName());
        student.setPassword(updateIU.getPassword());
        Student updateStudent = studentRepository.save(student);
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(updateStudent, dtoStudent);
        return dtoStudent;
    }
}
