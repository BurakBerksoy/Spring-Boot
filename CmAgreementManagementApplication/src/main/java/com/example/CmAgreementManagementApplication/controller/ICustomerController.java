package com.example.CmAgreementManagementApplication.controller;

import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoCustomer;
import com.example.CmAgreementManagementApplication.model.RootEntity;

import java.util.List;

public interface ICustomerController {
    List<DtoCustomer> findAllCustomers();
    RootEntity<DtoCustomer> findCustomerById(Long id);
    void deleteFoundCustomerById(Long id);
}
