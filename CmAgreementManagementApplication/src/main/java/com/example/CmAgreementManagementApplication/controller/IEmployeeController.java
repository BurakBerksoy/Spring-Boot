package com.example.CmAgreementManagementApplication.controller;

import com.example.CmAgreementManagementApplication.dto.ManyToOne.DtoEmployee;
import com.example.CmAgreementManagementApplication.model.RootEntity;

import java.util.List;

public interface IEmployeeController {
    List<DtoEmployee> findAllEmployees();
    RootEntity<DtoEmployee> findEmployeeById(Long id);
    void deleteFoundEmployeeById(Long id);
}
