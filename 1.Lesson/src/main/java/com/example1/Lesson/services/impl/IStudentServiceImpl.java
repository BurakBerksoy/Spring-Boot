package com.example1.Lesson.services.impl;

import com.example1.Lesson.dto.DtoStudent;
import com.example1.Lesson.dto.DtoStudentIU;
import com.example1.Lesson.model.Students;
import com.example1.Lesson.repository.IStudentRepository;
import com.example1.Lesson.services.IStudentService;
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
    public List<DtoStudent> getAllStudentList() {
        List<Students> getAllStudents = studentRepository.findAll();
        List<DtoStudent> getAllDtoStudents = new ArrayList<>();
        for (Students students : getAllStudents){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(students, dtoStudent);
            getAllDtoStudents.add(dtoStudent);
        }
        return getAllDtoStudents;
    }

    @Override
    public DtoStudent getByIdStudent(Integer id) {
        Optional<Students> byIdStudent = studentRepository.findById(id);

        if (byIdStudent.isPresent()) {
            Students student = byIdStudent.get(); // Optional'dan Students nesnesi alınır
            DtoStudent dtoStudent = new DtoStudent();

            // Student nesnesindeki veriler, DtoStudent nesnesine kopyalanır
            BeanUtils.copyProperties(student, dtoStudent);

            return dtoStudent;
        }

        return null; // Eğer öğrenci bulunmazsa null döner
    }

    @Override
    public DtoStudent saveNewStudent(DtoStudentIU newStudentIU) {
        Students students = new Students();
        BeanUtils.copyProperties(newStudentIU, students);
        studentRepository.save(students);

        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(students, dtoStudent);
        return dtoStudent;
    }

    @Override
    public void deleteStudentById(Integer id) {
        Optional<Students> byIdStudents = studentRepository.findById(id);
        if (byIdStudents.isPresent()){
            Students students = new Students();
            BeanUtils.copyProperties(byIdStudents, students);
            studentRepository.delete(students);
        }
    }

    @Override
    public DtoStudent updateStudentById(Integer id, DtoStudentIU updateStudentIU) {
        DtoStudent dto = new DtoStudent();

        Optional<Students> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Students students = optional.get();

            students.setFirstName(updateStudentIU.getFirstName());
            students.setLastName(updateStudentIU.getLastName());
            students.setToClass(updateStudentIU.getToClass());
            students.setEmail(updateStudentIU.getEmail());
            students.setPhoneNumber(updateStudentIU.getPhoneNumber());
            students.setPassword(updateStudentIU.getPassword());
            students.setClub(updateStudentIU.getClub());

            Students updatedStudent = studentRepository.save(students);

            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;

        }
        return null;

    }

}
