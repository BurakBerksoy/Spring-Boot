package com.example.CmAgreementManagementApplication.controller.impl;

import com.example.CmAgreementManagementApplication.controller.IHomeController;
import com.example.CmAgreementManagementApplication.dto.OneToMany.DtoHome;
import com.example.CmAgreementManagementApplication.model.RootEntity;
import com.example.CmAgreementManagementApplication.service.IHomeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/hoom")
public class HomeControllerImpl extends RestBaseController implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping(path = "/list/all")
    @Override
    public List<DtoHome> findAllHomes() {
        return homeService.findAllHomes();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public RootEntity<DtoHome> findHomeById(@Valid @PathVariable(name = "id") Long id) {
        return ok(homeService.findHomeById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteFoundHomeById(@Valid @PathVariable(name = "id") Long id) {
        DtoHome dtoHome = homeService.findHomeById(id);
        if (dtoHome == null) {
            throw new RuntimeException("Böyle bir id bulunamdı");
        }
        homeService.deleteFoundHomeById(id);
    }
}
