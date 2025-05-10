package com.example.CmAgreementManagementApplication.repository;

import com.example.CmAgreementManagementApplication.model.relations.OneToOne.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
