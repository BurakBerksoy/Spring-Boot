package com.example.CmAgreementManagementApplication.controller.impl;

import com.example.CmAgreementManagementApplication.controller.IUserController;
import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUser;
import com.example.CmAgreementManagementApplication.dto.ManyToMany.DtoUserIU;
import com.example.CmAgreementManagementApplication.model.RootEntity;
import com.example.CmAgreementManagementApplication.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserControllerImpl extends RestBaseController implements IUserController {

    @Autowired
    private IUserService userService;

    @GetMapping(path = "/list/all")
    @Override
    public List<DtoUser> allUsers() {
        return userService.allUsers();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public RootEntity<DtoUser> getUserById(@Valid @PathVariable(name = "id") Integer id) {
        return ok(userService.getUserById(id));
    }

    @PostMapping(path = "/save")
    @Override
    public DtoUser saveNewUser(@Valid @RequestBody DtoUserIU newUserIU) {
        return userService.saveNewUser(newUserIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteFoundUserById(@Valid @PathVariable(name = "id") Integer id) {
        DtoUser user = userService.getUserById(id);
        if (user == null) {
            throw new RuntimeException("Böyle bir id bulunamadı");
        }
        userService.deleteFoundUserById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoUser updateFoundUserById(@Valid @PathVariable(name = "id") Integer id,
                                       @Valid @RequestBody DtoUserIU userIU) {
        DtoUser user = userService.getUserById(id);
        if (user == null) {
            throw new RuntimeException("Böyle bir id bulunamadı");
        }
        return userService.updateFoundUserById(id, userIU);
    }
}
