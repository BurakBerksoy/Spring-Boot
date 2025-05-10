package com.example.CmAgreementManagementApplication.service;

import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUser;
import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUserIU;

import java.util.List;

public interface IUserService {
    List<DtoUser> allUsers();
    DtoUser getUserById(Integer id);
    DtoUser saveNewUser(DtoUserIU newUserIU);
    void deleteFoundUserById(Integer id);
    DtoUser updateFoundUserById(Integer id, DtoUserIU userIU);
}
