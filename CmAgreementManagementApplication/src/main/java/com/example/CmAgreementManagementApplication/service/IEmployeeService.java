package com.example.CmAgreementManagementApplication.service;

import com.example.CmAgreementManagementApplication.dto.ManyToOne.DtoEmployee;

import java.util.List;

public interface IEmployeeService {
    List<DtoEmployee> findAllEmployees();
    DtoEmployee findEmployeeById(Long id);
    void deleteFoundEmployeeById(Long id);
}
