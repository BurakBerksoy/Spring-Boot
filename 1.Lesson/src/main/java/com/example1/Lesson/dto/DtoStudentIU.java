package com.example1.Lesson.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Ad alanı boş bırakılamaz")
    @Size(min = 2, max = 15,message = "Ad 2-15 karakter aralığında olmalıdır")
    private String firstName;

    @NotEmpty(message = "Soyad alanı boş bırakılamaz")
    @Size(message = "Soyad 2-15 karakter aralığında olmalıdır")
    private String lastName;

    @NotEmpty(message = "Sınıf boş bırakılamaz")
    @Pattern(regexp = "9|10|11|12", message = "Geçerli bir sınıf giriniz (9, 10, 11, 12)")
    private String toClass;

    @Size(min = 11, max = 11, message = "Telefon numarası 11 haneli olmalıdır")
    @NotEmpty(message = "Telefon Numarası boş bırakılamaz")
    private String phoneNumber;

    @Email(message = "Geçerli bir E-posta giriniz")
    @NotEmpty(message = "E-posta boş bırakılamaz")
    private String email;

    @NotEmpty(message = "Şifre boş bırakılamaz")
    @Size(min = 4, message = "Şifre en az 4 karakterli olmalıdır")
    private String password;

    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String club;
}
