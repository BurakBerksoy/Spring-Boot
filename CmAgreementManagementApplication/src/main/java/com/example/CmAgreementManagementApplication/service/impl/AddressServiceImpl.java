package com.example.CmAgreementManagementApplication.service.impl;

import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoAddress;
import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoCustomer;
import com.example.CmAgreementManagementApplication.exception.BaseException;
import com.example.CmAgreementManagementApplication.exception.ErrorMessage;
import com.example.CmAgreementManagementApplication.exception.MessageType;
import com.example.CmAgreementManagementApplication.model.relations.OneToOne.Address;
import com.example.CmAgreementManagementApplication.model.relations.OneToOne.Customer;
import com.example.CmAgreementManagementApplication.repository.IAddressRepository;
import com.example.CmAgreementManagementApplication.repository.ICustomerRepository;
import com.example.CmAgreementManagementApplication.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<DtoAddress> findAllAddresses() {
        List<DtoAddress> dtoAddressList = new ArrayList<>();
        List<Address> addressList = addressRepository.findAll();
        if (addressList.isEmpty()) {
            return null;
        }
        for (Address address : addressList) {
            DtoAddress dtoAddress = new DtoAddress();
            BeanUtils.copyProperties(address, dtoAddress);

            DtoCustomer dtoCustomer = new DtoCustomer();
            dtoCustomer.setName(address.getCustomer().getName());
            dtoAddress.setDtoCustomer(dtoCustomer);
            dtoAddressList.add(dtoAddress);
        }
        return dtoAddressList;
    }

    @Override
    public DtoAddress findAddressById(Long id) {
        Optional<Address> optionalFindAddressId = addressRepository.findById(id);
        if (optionalFindAddressId.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }
        Address address = optionalFindAddressId.get();
        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(address, dtoAddress);

        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setName(address.getCustomer().getName());
        dtoAddress.setDtoCustomer(dtoCustomer);
        return dtoAddress;
    }

    @Override
    public void deleteFoundAddressById(Long id) {
        Optional<Address> optionalFindAddressId = addressRepository.findById(id);
        if (optionalFindAddressId.isPresent()) {
            Address address = optionalFindAddressId.get();
            Customer customer = address.getCustomer();

            if (customer != null) {
                customerRepository.delete(customer);
            }
            addressRepository.delete(address);
        }
    }
}
