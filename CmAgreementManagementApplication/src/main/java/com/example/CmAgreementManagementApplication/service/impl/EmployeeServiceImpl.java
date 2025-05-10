package com.example.CmAgreementManagementApplication.service.impl;

import com.example.CmAgreementManagementApplication.dto.ManyToOne.DtoDepartment;
import com.example.CmAgreementManagementApplication.dto.ManyToOne.DtoEmployee;
import com.example.CmAgreementManagementApplication.exception.BaseException;
import com.example.CmAgreementManagementApplication.exception.ErrorMessage;
import com.example.CmAgreementManagementApplication.exception.MessageType;
import com.example.CmAgreementManagementApplication.model.relations.ManyToOne.Employee;
import com.example.CmAgreementManagementApplication.repository.IEmployeeRepository;
import com.example.CmAgreementManagementApplication.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> findAllEmployees() {
       List<DtoEmployee> dtoEmployees = new ArrayList<>();
       List<Employee> employees = employeeRepository.findAll();
       if (!employees.isEmpty()) {
           for (Employee employee : employees) {
               DtoEmployee dtoEmployee = new DtoEmployee();
               BeanUtils.copyProperties(employee, dtoEmployee);

               dtoEmployee.setDtoDepartment(new DtoDepartment(employee.getDepartment().getName()));
               dtoEmployees.add(dtoEmployee);
           }
       }
       return dtoEmployees;
    }

    @Override
    public DtoEmployee findEmployeeById(Long id) {
        Optional<Employee> findEmployeeId = employeeRepository.findById(id);
        if (findEmployeeId.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        Employee employee = findEmployeeId.get();
        DtoEmployee dtoEmployee = new DtoEmployee();
        BeanUtils.copyProperties(employee, dtoEmployee);

        dtoEmployee.setDtoDepartment(new DtoDepartment(employee.getDepartment().getName()));
        return dtoEmployee;
    }

    @Override
    public void deleteFoundEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
