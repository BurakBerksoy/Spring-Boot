package com.example6.Lesson.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Ad boş bırakılmaz")
    @Size(min = 3, max = 25, message = "Ad 3-25 karakter aralığında olmalıdır")
    private String fullName;
    private String password;
}
