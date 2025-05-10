package com.example.CmAgreementManagementApplication.controller;

import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUser;
import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUserIU;
import com.example.CmAgreementManagementApplication.model.RootEntity;

import java.util.List;

public interface IUserController {
    List<DtoUser> allUsers();
    RootEntity<DtoUser> getUserById(Integer id);
    DtoUser saveNewUser(DtoUserIU newUserIU);
    void deleteFoundUserById(Integer id);
    DtoUser updateFoundUserById(Integer id, DtoUserIU userIU);
}
