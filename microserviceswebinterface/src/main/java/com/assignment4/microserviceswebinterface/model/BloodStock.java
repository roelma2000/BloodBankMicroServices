package com.assignment4.microserviceswebinterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodStock {
    private int bsid;

    @NotBlank(message = "Blood group must not be blank.")
    private String bloodGroup;

    @NotNull(message = "Quantity must not be null.")
    private int quantity;

    @NotNull(message = "Provide appropriate date")
    @Future(message = "Date must be in future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate bestBefore;

    @NotBlank(message = "Status must not be blank.")
    private String status;
}
