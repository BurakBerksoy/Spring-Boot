package com.example.CmAgreementManagementApplication.controller;

import com.example.CmAgreementManagementApplication.dto.OneToMany.DtoHome;
import com.example.CmAgreementManagementApplication.model.RootEntity;

import java.util.List;

public interface IHomeController {
    List<DtoHome> findAllHomes();
    RootEntity<DtoHome> findHomeById(Long id);
    void deleteFoundHomeById(Long id);
}
