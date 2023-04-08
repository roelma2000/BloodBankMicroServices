package com.assignment4.microserviceswebinterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seeker {

    private int seekerId;
    @NotBlank(message = "Firstname should not be blank.")
    private String firstName;

    @NotBlank(message = "LastName should not be blank.")
    private String lastName;

    @NotNull(message = "Age must not be null.")
    private int age;

    @NotNull(message = "Birthdate must not be null.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @NotBlank(message = "Gender must not be blank.")
    private String gender;

    @NotBlank(message = "Blood group must not be blank.")
    private String bloodGroup;

    @NotBlank(message = "City must not be blank.")
    private String city;

    @NotBlank(message = "Phone should not be blank.")
    @Size(min = 10, max = 10, message = "Phone number must be 10 numbers.")
    private String phone;
}
