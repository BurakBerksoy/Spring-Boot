package com.example.CmAgreementManagementApplication.service;

import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoCustomer;

import java.util.List;

public interface ICustomerService {
    List<DtoCustomer> findAllCustomers();
    DtoCustomer findCustomerById(Long id);
    void deleteFoundCustomerById(Long id);
}
