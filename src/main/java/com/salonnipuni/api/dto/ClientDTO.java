package com.salonnipuni.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Contact number is required")
    private String contact;

    private String address;

    @Email(message = "Email must be a valid email address")
    private String email;

    private Integer points;
    private String tier;
}
