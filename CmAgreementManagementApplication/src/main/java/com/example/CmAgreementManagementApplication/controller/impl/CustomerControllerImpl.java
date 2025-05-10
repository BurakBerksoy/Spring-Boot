package com.example.CmAgreementManagementApplication.controller.impl;

import com.example.CmAgreementManagementApplication.controller.ICustomerController;
import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoCustomer;
import com.example.CmAgreementManagementApplication.model.RootEntity;
import com.example.CmAgreementManagementApplication.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerControllerImpl extends RestBaseController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(path = "/list/all")
    @Override
    public List<DtoCustomer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public RootEntity<DtoCustomer> findCustomerById(@Valid @PathVariable(name = "id") Long id) {
        return ok(customerService.findCustomerById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteFoundCustomerById(@Valid @PathVariable(name = "id") Long id) {
        DtoCustomer dtoCustomer = customerService.findCustomerById(id);
        if (dtoCustomer == null) {
            throw new RuntimeException("Böyle bir bulunamadı");
        }
        customerService.deleteFoundCustomerById(id);
    }
}
