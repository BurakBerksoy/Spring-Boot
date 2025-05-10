package com.example4.Lesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Boş yok")
    @Size(min = 3, max = 15, message = "3-15")
    private String fullName;

    @NotEmpty(message = "Boş yok")
    @Size(min = 6, message = "en az 6")
    private String password;
}
