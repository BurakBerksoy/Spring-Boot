package com.example.CmAgreementManagementApplication.dto.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoHome {
    private BigDecimal price;
    private List<DtoRoom> dtoRooms;
}
