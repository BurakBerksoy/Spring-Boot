package com.example.CmAgreementManagementApplication.controller.impl;

import com.example.CmAgreementManagementApplication.controller.IAddressController;
import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoAddress;
import com.example.CmAgreementManagementApplication.model.RootEntity;
import com.example.CmAgreementManagementApplication.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/address")
public class AddressControllerImpl extends RestBaseController implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping(path = "/list/all")
    @Override
    public List<DtoAddress> findAllAddresses() {
        return addressService.findAllAddresses();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public RootEntity<DtoAddress> findAddressById(@Valid @PathVariable(name = "id") Long id) {
        return ok(addressService.findAddressById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteFoundAddressById(@Valid @PathVariable(name = "id") Long id) {
        DtoAddress address = addressService.findAddressById(id);
        if (address == null) {
            throw new RuntimeException("Böyle bir id bulunamadı");
        }
        addressService.deleteFoundAddressById(id);
    }
}
