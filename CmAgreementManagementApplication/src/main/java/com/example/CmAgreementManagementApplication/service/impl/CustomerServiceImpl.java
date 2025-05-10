package com.example.CmAgreementManagementApplication.service.impl;

import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoAddress;
import com.example.CmAgreementManagementApplication.dto.OneToOne.DtoCustomer;
import com.example.CmAgreementManagementApplication.exception.BaseException;
import com.example.CmAgreementManagementApplication.exception.ErrorMessage;
import com.example.CmAgreementManagementApplication.exception.MessageType;
import com.example.CmAgreementManagementApplication.model.relations.OneToOne.Address;
import com.example.CmAgreementManagementApplication.model.relations.OneToOne.Customer;
import com.example.CmAgreementManagementApplication.repository.ICustomerRepository;
import com.example.CmAgreementManagementApplication.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<DtoCustomer> findAllCustomers() {
        List<DtoCustomer> dtoCustomers = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            Address address = customer.getAddress();

            DtoCustomer dtoCustomer = new DtoCustomer();
            DtoAddress dtoAddress = new DtoAddress();

            BeanUtils.copyProperties(address, dtoAddress);
            BeanUtils.copyProperties(customer, dtoCustomer);

            dtoCustomer.setDtoAddress(dtoAddress);
            dtoCustomers.add(dtoCustomer);
        }
        return dtoCustomers;
    }

    @Override
    public DtoCustomer findCustomerById(Long id) {
        Optional<Customer> findCustomerId = customerRepository.findById(id);
        if (findCustomerId.isPresent()) {
            Customer customer = findCustomerId.get();
            Address address = customer.getAddress();

            DtoCustomer dtoCustomer = new DtoCustomer();
            DtoAddress dtoAddress = new DtoAddress();

            BeanUtils.copyProperties(address, dtoAddress);
            BeanUtils.copyProperties(customer, dtoCustomer);

            dtoCustomer.setDtoAddress(dtoAddress);
            return dtoCustomer;
        }
        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
    }

    @Override
    public void deleteFoundCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
    }
}
