package com.example.CmAgreementManagementApplication.dto.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoUser {
    private String username;
    private List<DtoCourse> dtoCourses;
}
