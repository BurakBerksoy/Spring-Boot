package com.example.CmAgreementManagementApplication.dto.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddress {
    private String description;
    private DtoCustomer dtoCustomer;
}
