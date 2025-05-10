package com.example.CmAgreementManagementApplication.controller;

import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoAddress;
import com.example.CmAgreementManagementApplication.model.RootEntity;

import java.util.List;

public interface IAddressController {
    List<DtoAddress> findAllAddresses();
    RootEntity<DtoAddress> findAddressById(Long id);
    void deleteFoundAddressById(Long id);
}
