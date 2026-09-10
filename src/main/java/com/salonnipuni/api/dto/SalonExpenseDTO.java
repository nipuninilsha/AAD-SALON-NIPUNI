package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonExpenseDTO {
    private String id;
    private String category;
    private String description;
    private double amount;
    private LocalDate date;
    private String addedBy;
}
