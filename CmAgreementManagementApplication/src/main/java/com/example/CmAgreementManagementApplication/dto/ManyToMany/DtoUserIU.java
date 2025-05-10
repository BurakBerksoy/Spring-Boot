package com.example.CmAgreementManagementApplication.dto.ManyToMany;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoUserIU {

    @NotEmpty(message = "İsim boş bırakılamaz")
    @Size(min = 3, max = 15)
    private String username;

    @NotEmpty(message = "Şifre boş bırakılamaz")
    @Size(min = 3, max = 15)
    private String password;
}
