package com.example.CmAgreementManagementApplication.repository;

import com.example.CmAgreementManagementApplication.model.relations.ManyToOne.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
