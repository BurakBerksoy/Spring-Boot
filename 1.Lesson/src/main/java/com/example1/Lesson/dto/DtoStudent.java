package com.example1.Lesson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {

    private String firstName;
    private String lastName;
    private String toClass;
    private String email;
    private String phoneNumber;
    private String password;
    private String club;
}
