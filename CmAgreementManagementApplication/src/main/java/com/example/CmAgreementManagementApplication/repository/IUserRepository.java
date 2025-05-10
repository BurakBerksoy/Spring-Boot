package com.example.CmAgreementManagementApplication.repository;

import com.example.CmAgreementManagementApplication.model.relations.ManyToMany.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
