package com.example4.Lesson.service.impl;

import com.example4.Lesson.dto.DtoStudent;
import com.example4.Lesson.dto.DtoStudentIU;
import com.example4.Lesson.model.Student;
import com.example4.Lesson.repository.IStudentRepository;
import com.example4.Lesson.service.IStudentService;
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
    public List<DtoStudent> getAllStudents() {
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
        Optional<Student> studentById = studentRepository.findById(id);
        if (studentById.isEmpty()){
            return null;
        }
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(studentById, dtoStudent);
        return dtoStudent;
    }

    @Override
    public DtoStudent createNewStudent(DtoStudentIU newStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(newStudentIU, student);
        studentRepository.save(student);
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(student, dtoStudent);
        return dtoStudent;
    }

    @Override
    public void deleteStudentFoundById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateStudentFoundById(Integer id, DtoStudentIU updateStudentIU) {
        Optional<Student> studentById = studentRepository.findById(id);
        if (studentById.isEmpty()){
            return null;
        }
        Student studentUpdate = studentById.get();
        studentUpdate.setFullName(updateStudentIU.getFullName());
        studentUpdate.setPassword(updateStudentIU.getPassword());

        studentRepository.save(studentUpdate);

        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(studentUpdate, dtoStudent);
        return dtoStudent;
    }
}
