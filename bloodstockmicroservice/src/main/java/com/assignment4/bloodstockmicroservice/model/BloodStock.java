package com.assignment4.bloodstockmicroservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity  //for creating the table
@Table(name = "tblbloodstock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generating auto inc
    @Column(name = "id")
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
