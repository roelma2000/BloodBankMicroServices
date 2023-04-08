package com.assignment4.microserviceswebinterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodBank {
    private int bbnid;
    @NotBlank(message = "Blood bank name must not be blank.")
    private String bloodbankName;

    @NotBlank(message = "Address must not be blank.")
    private String address;

    @NotBlank(message = "City must not be blank.")
    private String city;

    @NotBlank(message = "Phone should not be blank.")
    @Size(min = 10, max = 10, message = "Phone number must be 10 numbers.")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digits.")
    private String phone;

    @NotBlank(message = "Website must not be blank.")
    private String website;

    @NotBlank(message = "Email must not be blank.")
    private String email;
}
