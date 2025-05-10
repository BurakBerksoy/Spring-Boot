package com.example2.Lesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Ad boş bırakılamaz")
    @Size(min = 3, max = 15, message = "3-15")
    private String firstName;

    @NotEmpty(message = "Şifre boş bırakılamaz")
    @Size(min = 6, message = "En az 6")
    private String password;
}
