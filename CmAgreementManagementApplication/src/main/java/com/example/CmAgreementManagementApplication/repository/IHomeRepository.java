package com.example.CmAgreementManagementApplication.repository;

import com.example.CmAgreementManagementApplication.model.relations.OneToMany.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeRepository extends JpaRepository<Home, Long> {
}
