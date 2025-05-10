package com.example2.Lesson.services.impl;

import com.example2.Lesson.dto.DtoStudent;
import com.example2.Lesson.dto.DtoStudentIU;
import com.example2.Lesson.model.Student;
import com.example2.Lesson.repository.IStudentRepository;
import com.example2.Lesson.services.IStudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IStudentServicesImpl implements IStudentServices {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<DtoStudent> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> new DtoStudent(student.getFirstName()))
                .collect(Collectors.toList());
    }

    @Override
    public DtoStudent getByIdStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(value -> new DtoStudent(value.getFirstName())).orElse(null);
    }

    @Override
    public DtoStudent createNewStudent(DtoStudentIU newStudentIU) {
        Student student = new Student();
        student.setFirstName(newStudentIU.getFirstName());
        Student savedStudent = studentRepository.save(student);
        return new DtoStudent(savedStudent.getFirstName());
    }

    @Override
    public void deleteStudentFoundById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateStudentFoundById(Integer id, DtoStudentIU updateStudentIU) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(updateStudentIU.getFirstName());
            Student updatedStudent = studentRepository.save(student);
            return new DtoStudent(updatedStudent.getFirstName());
        }
        return null;
    }
}