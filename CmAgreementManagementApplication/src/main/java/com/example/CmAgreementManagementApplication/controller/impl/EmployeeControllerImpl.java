package com.example.CmAgreementManagementApplication.controller.impl;

import com.example.CmAgreementManagementApplication.controller.IEmployeeController;
import com.example.CmAgreementManagementApplication.dto.ManyToOne.DtoEmployee;
import com.example.CmAgreementManagementApplication.model.RootEntity;
import com.example.CmAgreementManagementApplication.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employee")
public class EmployeeControllerImpl extends RestBaseController implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(path = "/list/all")
    @Override
    public List<DtoEmployee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public RootEntity<DtoEmployee> findEmployeeById(@Valid @PathVariable(name = "id") Long id) {
        return ok(employeeService.findEmployeeById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteFoundEmployeeById(@Valid @PathVariable(name = "id") Long id) {
        DtoEmployee dtoEmployee = employeeService.findEmployeeById(id);
        if (dtoEmployee == null) {
            throw new RuntimeException("Böyle bir id bulunamadı");
        }
        employeeService.deleteFoundEmployeeById(id);
    }
}
