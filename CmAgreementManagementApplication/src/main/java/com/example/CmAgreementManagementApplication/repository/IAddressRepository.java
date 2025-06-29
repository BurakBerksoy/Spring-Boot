package com.example.CmAgreementManagementApplication.repository;

import com.example.CmAgreementManagementApplication.model.relations.OneToOne.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
