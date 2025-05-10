package com.example5.Lesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "")
    @Size(min = 3, max = 15, message = "")
    private String fullName;

    @NotEmpty(message = "")
    @Size(min = 6, message = "")
    private String password;
}
