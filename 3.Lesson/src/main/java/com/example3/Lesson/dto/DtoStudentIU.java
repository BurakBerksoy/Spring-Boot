package com.example3.Lesson.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Boş bırakma")
    private String firstName;

    @NotEmpty(message = "Boş bırakma")
    private String password;
}
