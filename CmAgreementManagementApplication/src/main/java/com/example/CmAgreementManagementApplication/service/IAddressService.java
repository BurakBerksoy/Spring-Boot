package com.example.CmAgreementManagementApplication.service;

import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoAddress;

import java.util.List;

public interface IAddressService {
    List<DtoAddress> findAllAddresses();
    DtoAddress findAddressById(Long id);
    void deleteFoundAddressById(Long id);
}
