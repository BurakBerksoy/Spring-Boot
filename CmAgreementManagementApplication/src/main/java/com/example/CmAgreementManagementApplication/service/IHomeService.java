package com.example.CmAgreementManagementApplication.service;

import com.example.CmAgreementManagementApplication.dto.OneToMany.DtoHome;

import java.util.List;

public interface IHomeService {
    List<DtoHome> findAllHomes();
    DtoHome findHomeById(Long id);
    void deleteFoundHomeById(Long id);
}
